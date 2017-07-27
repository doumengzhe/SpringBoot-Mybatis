package com.dmz.controller;

import com.dmz.model.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 豆孟哲 on 2017/7/26.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
public class TestBootController {
    @RequestMapping("getuser")
    public User getUser(){
        User u=new User();
        u.setName("dmz");
        return  u;
    }
}
