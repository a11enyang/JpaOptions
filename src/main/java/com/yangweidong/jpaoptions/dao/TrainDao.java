package com.yangweidong.jpaoptions.dao;

import com.yangweidong.jpaoptions.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainDao extends JpaRepository<Train, Integer>, JpaSpecificationExecutor<Train> {
}
