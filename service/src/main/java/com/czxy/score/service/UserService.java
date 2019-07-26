package com.czxy.score.service;

import com.czxy.domain.User;
import com.czxy.score.dao.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @version v 1.0
 * @date 2019/7/25
 */
@Service
@Transactional
public class UserService {

    @Resource
    private UserMapper userMapper;

    //登录逻辑
    public User login(User user){
        User userByNameAndPsw = userMapper.findUserByNameAndPsw(user);
        return userByNameAndPsw;
    }
}
