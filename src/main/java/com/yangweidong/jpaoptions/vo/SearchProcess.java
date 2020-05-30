package com.yangweidong.jpaoptions.vo;

import com.yangweidong.jpaoptions.entity.Seat;
import com.yangweidong.jpaoptions.entity.Station;
import com.yangweidong.jpaoptions.entity.Trip;
import com.yangweidong.jpaoptions.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Component
public class SearchProcess {
    @Autowired
    public RoleService roleService;

    @Autowired
    public TripService tripService;

    @Autowired
    public TrainService trainService;

    @Autowired
    public StationService stationService;

    @Autowired
    public SeatService seatService;

    public List<SearchResult> searchRoute(String begin, String end) {
        //模糊查询找到所有的相关路线
        List<Trip> trips = tripService.findTrips(begin, end);
        //输出的结果列表
        List<SearchResult> results = new ArrayList<>();
        for (Trip trip : trips) {
            //页面显示的一条结果
            SearchResult result = new SearchResult();
            //设置一条结果的内容
            result.setTripNumber(trip.getTripNumber());
            int beginNumber = 0;
            int endNumber = 0;
            //找到trip对应的stations, 然后找到开始和出发的显示并保存
            for (Station station : trip.getTripStations()) {
                if (station.getStationName().equals(begin)) {
                    result.setBegin(begin);
                    result.setBeginLeaveTime(station.getStationLeaveTime());
                    beginNumber = station.getStationSequence();
                } else if (station.getStationName().equals(end)) {
                    result.setEnd(end);
                    result.setEndArriveTime(station.getStationArriveTime());
                    endNumber = station.getStationSequence();
                } else {

                }
            }

            //找到trip对应的座位
            List<Seat> seatList = new ArrayList<>();
            for (Seat seat : trip.getTripSeats()) {
                int number = Integer.parseInt(String.valueOf(seat.getSeatSequence()).charAt(1) + "");
                if (((number - beginNumber) >= 1) && ((endNumber - number) >= 0)) {
                    seatList.add(seat);
                }
            }

            //计算是否有座位
            int whetherHaveSeat = 1;
            for (Seat seat : seatList) {
                whetherHaveSeat = seat.getSeatWhetherHaveEmpty() & whetherHaveSeat;
            }

            //计算剩余剩余座位
            int seatBinaryNumber = 0; //是所有相关的数字的或运算最后的结果
            //计算座位已经被占了多少
            for (Seat seat : seatList) {
                seatBinaryNumber |= Integer.parseUnsignedInt(seat.getSeatBinaryNumber(), 2);
            }
            int remainSeats = 4 - StringUtils.countOccurrencesOf(Integer.toBinaryString(seatBinaryNumber) , "1");
            result.setRemainSeats(remainSeats);
            results.add(result);
        }
        return results;
    }

}
