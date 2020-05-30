package com.yangweidong.jpaoptions.dao;

import com.yangweidong.jpaoptions.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StationDao extends JpaRepository<Station, Integer>, JpaSpecificationExecutor<Station> {
}
