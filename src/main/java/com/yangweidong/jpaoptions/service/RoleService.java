package com.yangweidong.jpaoptions.service;

import com.yangweidong.jpaoptions.dao.RoleDao;
import com.yangweidong.jpaoptions.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    public RoleDao roleDao;

    public void saveRole(Role role){
        roleDao.save(role);
    }

}
