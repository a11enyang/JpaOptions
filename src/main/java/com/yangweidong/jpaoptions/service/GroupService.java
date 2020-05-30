package com.yangweidong.jpaoptions.service;

import com.yangweidong.jpaoptions.dao.GroupDao;
import com.yangweidong.jpaoptions.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    @Autowired
    public GroupDao groupDao;

    public void save(Group group){
        groupDao.save(group);
    }

    public Group findGroup(int id){
        return groupDao.findById(id).get();
    }
    public void deleteGroup(Group group){
        groupDao.delete(group);
    }
}
