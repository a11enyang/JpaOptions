package com.yangweidong.jpaoptions.dao;

import com.yangweidong.jpaoptions.entity.TicketEndingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketEndingUserDao
        extends JpaRepository<TicketEndingUser, Integer>,
        JpaSpecificationExecutor<TicketEndingUser> {

    //根据账号和密码找到相关的管理员
    @Query("select u from TicketEndingUser as u where u.ticketEndingUserName = ?1 and u.ticketEndingUserPassword = ?2")
    Optional<TicketEndingUser > login(String name, String password);

    Optional<TicketEndingUser> findByTicketEndingUserToken(String token);
}
