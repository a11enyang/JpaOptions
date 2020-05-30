package com.yangweidong.jpaoptions.controller;

import com.yangweidong.jpaoptions.dao.GroupDao;
import com.yangweidong.jpaoptions.dao.StudentDao;
import com.yangweidong.jpaoptions.dao.UserDao;
import com.yangweidong.jpaoptions.entity.*;
import com.yangweidong.jpaoptions.service.*;
import com.yangweidong.jpaoptions.vo.SearchProcess;
import com.yangweidong.jpaoptions.vo.SearchResult;
import org.springframework.beans.BeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.tools.jstat.Literal;

import javax.transaction.Transactional;
import java.security.PublicKey;
import java.sql.ResultSet;
import java.util.*;
import java.util.zip.GZIPOutputStream;

@RestController
@RequestMapping("/User")
public class UserApi {
    @Autowired
    public UserService userService;

    @Autowired
    public GroupService groupService;

    @Autowired
    public StudentService studentService;

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

    @Autowired
    public SearchProcess searchProcess;

    @GetMapping("/findOne")
    public void findOneWithSpecification() {
        String name = "yangweidong";
        int age = 21;
        List<User> users = userService.findUserBetweenAge(name, age);
        for (User u: users) {
            System.out.println(u.toString());
        }
    }

    @GetMapping("/findUsersOnePage")
    public void findUsersPageable(){
        Page<User> usersPage = userService.findUsersPagable();
        for (User u:
             usersPage) {
            System.out.println(u);
        }
    }

    @GetMapping("/saveWithForeignKey")
    @Transactional
    public void saveWithForeignKey(){
        Role role = new Role();
        role.setRoleName("学生");

        Student student = new Student();
        student.setStudentName("杨韦岽");

        student.getRoles().add(role);

        roleService.saveRole(role);
        studentService.save(student);

    }

    @GetMapping("/test")
    @Transactional
    public void test(){
        //车次
        Trip trip1 = new Trip();
        trip1.setTripNumber(12);
        trip1.setTripStatus(true);
        trip1.setTripLine("北京-上海-广州-重庆");

        //站点1
        Station station1 = new Station();
        station1.setStationName("北京");
        station1.setStationLeaveTime("2020-05-28 11:05");
        station1.setStationSequence(1);

        //站点2
        Station station2 = new Station();
        station2.setStationName("上海");
        station2.setStationArriveTime("2020-05-29 9:05");
        station2.setStationLeaveTime("2020-05-29 11:05");
        station2.setStationSequence(2);


        //站点3
        Station station3 = new Station();
        station3.setStationName("广州");
        station3.setStationArriveTime("2020-05-30 9:05");
        station3.setStationLeaveTime("2020-05-30 11:05");
        station3.setStationSequence(3);


        //站点4
        Station station4 = new Station();
        station4.setStationName("重庆");
        station4.setStationArriveTime("2020-06-01 9:05");
        station4.setStationSequence(4);


        //座位表1
        Seat seat1 = new Seat();
        seat1.setSeatFirstStation("北京");
        seat1.setSeatSecondStation("上海");
        seat1.setSeatBinaryNumber("0100");
        seat1.setSeatWhetherHaveEmpty(1);
        seat1.setSeatSequence(12);

        //座位表2
        Seat seat2 = new Seat();
        seat2.setSeatFirstStation("上海");
        seat2.setSeatSecondStation("广州");
        seat2.setSeatBinaryNumber("0010");
        seat2.setSeatWhetherHaveEmpty(1);
        seat2.setSeatSequence(23);


        //座位表3
        Seat seat3 = new Seat();
        seat3.setSeatFirstStation("广州");
        seat3.setSeatSecondStation("重庆");
        seat3.setSeatBinaryNumber("1101");
        seat3.setSeatWhetherHaveEmpty(1);
        seat3.setSeatSequence(34);

        Set<Station>  stations= new HashSet<>();
        stations.add(station1);
        stations.add(station2);
        stations.add(station3);
        stations.add(station4);
        Set<Seat> seats = new HashSet<>();
        seats.add(seat1);
        seats.add(seat2);
        seats.add(seat3);

        trip1.setTripSeats(seats);
        trip1.setTripStations(stations);

        tripService.saveTrip(trip1);

    }

    @GetMapping("/test1")
    @Transactional
    public void test1(){
        String begin = "北京";
        String end = "广州";
        List<SearchResult>   results  =  searchProcess.searchRoute(begin,end);
        System.out.println(results.get(0).getRemainSeats());

        //下一步需要找出最右边的0的位置  可以可以进行封装
        int postion = 0;
        while (seatBinaryNumber != 0 && postion != 3){
            if ((seatBinaryNumber & 1) == 0){
                System.out.println(postion);
                break;
            }
            postion ++;
            seatBinaryNumber = seatBinaryNumber >> 1;
        }
        result.setWhetherHaveSeat(whetherHaveSeat);

        //将座位表的位置设置为1
        for (Seat seat :  seatList){
//            seat.setSeatBinaryNumber(String.valueOf((Integer.parseUnsignedInt(seat.getSeatBinaryNumber(), 2) & (1 << postion))));
            char[] s = seat.getSeatBinaryNumber().toCharArray();
            s[3 -postion] = '1';
            seat.setSeatBinaryNumber(String.valueOf(s));
        }



        System.out.println(result);
    }

}
