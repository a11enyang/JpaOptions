package com.yangweidong.jpaoptions.service;

import com.yangweidong.jpaoptions.dao.TicketEndingUserDao;
import com.yangweidong.jpaoptions.entity.TicketEndingUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.UUID;

@Service
public class TicketEndingUserService {
    @Autowired
    private TicketEndingUserDao ticketEndingUserDao;

    //登录并且设置token
    public String login(String name, String password){
        Optional<TicketEndingUser>  ticketEndingUser = ticketEndingUserDao.login(name, password);
        if (ticketEndingUser.isPresent()){
            String token = UUID.randomUUID().toString();
            TicketEndingUser user = ticketEndingUser.get();
            user.setTicketEndingUserToken(token);
            ticketEndingUserDao.save(user);
            return token;
        }
        return StringUtils.EMPTY;
    }

    //根据token查找
    public Optional<User> findByToken(String token) {
        Optional<TicketEndingUser> ticketEndingUser= ticketEndingUserDao.findByTicketEndingUserToken(token);
        if(ticketEndingUser.isPresent()){
            TicketEndingUser ticketEndingUser1 = ticketEndingUser.get();
            User user= new User(ticketEndingUser1.getTicketEndingUserName(), ticketEndingUser1.getTicketEndingUserPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return  Optional.empty();
    }


    //根据id查找对应的售票端管理员
    public TicketEndingUser findById(int id){
        Optional<TicketEndingUser> ticketEndingUser = ticketEndingUserDao.findById(id);
        return ticketEndingUser.orElse(null);
    }
}
