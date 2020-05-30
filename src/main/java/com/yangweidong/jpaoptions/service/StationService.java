package com.yangweidong.jpaoptions.service;


import com.yangweidong.jpaoptions.dao.StationDao;
import com.yangweidong.jpaoptions.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class StationService {
    @Autowired
    public StationDao stationDao;

    public void saveStation(Station station){
        stationDao.save(station);
    }
}
