package com.yangweidong.jpaoptions.dao;

import com.yangweidong.jpaoptions.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatDao extends JpaSpecificationExecutor<Seat>, JpaRepository<Seat, Integer> {

}
