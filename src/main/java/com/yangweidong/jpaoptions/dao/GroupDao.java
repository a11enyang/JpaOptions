package com.yangweidong.jpaoptions.dao;


import com.yangweidong.jpaoptions.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDao extends JpaRepository<Group, Integer>, JpaSpecificationExecutor<Group> {
}
