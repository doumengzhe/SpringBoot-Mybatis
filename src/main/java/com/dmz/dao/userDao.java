package com.dmz.dao;

import com.dmz.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by 豆孟哲 on 2017/7/26.
 */
@Repository
public interface userDao {
    public User getUserById(int id);
}
