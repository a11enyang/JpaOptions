package com.yangweidong.jpaoptions.service;

import com.yangweidong.jpaoptions.dao.TripDao;
import com.yangweidong.jpaoptions.entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TripService {
    @Autowired
    public TripDao tripDao;

    //1.保存一个Trip对象
    public void saveTrip(Trip trip){
        tripDao.save(trip);
    }

    //2.根据路线模糊查找Trip对象,并返回列表
    public List<Trip> findTrips(String begin, String end){
        return tripDao.findTripFuzzy(begin, end);
    }
}
