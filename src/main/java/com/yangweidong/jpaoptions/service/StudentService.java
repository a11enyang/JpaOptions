package com.yangweidong.jpaoptions.service;

import com.yangweidong.jpaoptions.dao.StudentDao;
import com.yangweidong.jpaoptions.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    public StudentDao studentDao;

    public void save(Student student){
        studentDao.save(student);
    }

    public Optional<Student> findStudent(int id){
        return studentDao.findById(id);
    }

    public void deleteStudent(Student student){
        studentDao.delete(student);
    }
}
