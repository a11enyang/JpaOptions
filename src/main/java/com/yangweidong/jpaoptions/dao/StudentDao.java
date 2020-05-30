package com.yangweidong.jpaoptions.dao;


import com.yangweidong.jpaoptions.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
}
