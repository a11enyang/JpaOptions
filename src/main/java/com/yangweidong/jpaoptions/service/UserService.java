package com.yangweidong.jpaoptions.service;

import com.yangweidong.jpaoptions.dao.UserDao;
import com.yangweidong.jpaoptions.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.swing.*;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserDao userDao;

    public List<User> findUserBetweenAge(String name, int age){
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> namePath = root.get("name");
                Predicate like = criteriaBuilder.like(namePath.as(String.class), name+"%");
                return like;
            }
        };
        return userDao.findAll(specification, Sort.by(Sort.Direction.DESC, "id"));
    }

    public Page<User> findUsersPagable(){
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        };
        Pageable pageable = PageRequest.of(0,1);
        return userDao.findAll(specification, pageable);
    }
}
