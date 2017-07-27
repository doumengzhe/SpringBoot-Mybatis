package com.dmz.controller;

import com.dmz.model.User;
import com.dmz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 豆孟哲 on 2017/7/26.
 */
@Controller
public class userController {
    @Autowired
    UserService userService;
    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUserById(int id){
       return userService.getUserById(id) ;
    }
    //访问index.jsp
    @RequestMapping("toindex")
    public String toIndex(){
        return "aa";
    }
}
