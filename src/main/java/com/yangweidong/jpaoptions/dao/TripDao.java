package com.yangweidong.jpaoptions.dao;

import com.yangweidong.jpaoptions.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.util.List;

@Repository
public interface TripDao extends JpaRepository<Trip, Integer>, JpaSpecificationExecutor<Trip> {
    @Query(value = "from Trip where tripLine like concat('%', ?1, '%', ?2, '%') ")
    List<Trip> findTripFuzzy(String being, String end);
}
