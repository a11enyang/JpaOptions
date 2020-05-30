package com.yangweidong.jpaoptions.service;

import com.yangweidong.jpaoptions.dao.SeatDao;
import com.yangweidong.jpaoptions.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
    @Autowired
    public SeatDao seatDao;

    public void saveSeat(Seat seat){
        seatDao.save(seat);
    }
}
