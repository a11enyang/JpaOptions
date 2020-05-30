package com.yangweidong.jpaoptions.service;

import com.yangweidong.jpaoptions.dao.TrainDao;
import com.yangweidong.jpaoptions.entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.text.normalizer.UBiDiProps;

@Service
public class TrainService {
    @Autowired
    public TrainDao trainDao;

    public void saveTrain(Train train){
        trainDao.save(train);
    }

}
