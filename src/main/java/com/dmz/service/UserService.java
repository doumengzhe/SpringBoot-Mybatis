package com.dmz.service;

import com.dmz.dao.userDao;
import com.dmz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 豆孟哲 on 2017/7/26.
 */
@Service
public class UserService {
    @Autowired
    userDao userdao;
    @Transactional()
    public User getUserById(int id){
       return userdao.getUserById(id) ;
    }
}
