package com.yangweidong.jpaoptions.controller;

import com.yangweidong.jpaoptions.entity.TicketEndingUser;
import com.yangweidong.jpaoptions.service.TicketEndingUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yangweidong.jpaoptions.vo.*;


@RestController
@CrossOrigin
public class TestApi {
    @Autowired
    public TicketEndingUserService ticketEndingUserService;

    @PostMapping("/token")
    public RequestLoginResult login(@RequestParam(value = "name", defaultValue = "yangweidong")String name,
                        @RequestParam(value = "password", defaultValue = "123")String password){
        String token = ticketEndingUserService.login(name, password);

//        if (token.isEmpty()){
//            return "no_token";
//        }

        RequestLoginResult requestLoginResult = new RequestLoginResult();
        requestLoginResult.setS("yangweidong");
        Meta meta = new Meta();
        meta.setMesg("成功");
        meta.setMesg("200");
        requestLoginResult.setMeta(meta);
        return requestLoginResult;
    }

    @GetMapping(value = "/api/users/user/{id}")
    public TicketEndingUser getUserDetail(@PathVariable int id){
        return ticketEndingUserService.findById(id);
    }

}
