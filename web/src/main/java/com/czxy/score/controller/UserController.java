package com.czxy.score.controller;

import com.czxy.domain.Log;
import com.czxy.domain.User;
import com.czxy.score.service.LogService;
import com.czxy.score.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private LogService logService;

    @PostMapping("/add")
    public ResponseEntity<String> add(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Log log = new Log();
        log.setUid(user.getId());
        log.setUsername(user.getUsername());
        log.setOperat("add");
        log.setTime(new Date());
        logService.addLog(log);

        System.out.println("... 执行add方法");
        return new ResponseEntity<>("add..OK", HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Log log = new Log();
        log.setUid(user.getId());
        log.setUsername(user.getUsername());
        log.setOperat("update");
        log.setTime(new Date());
        logService.addLog(log);

        System.out.println("... 执行update方法");
        return new ResponseEntity<>("update..OK", HttpStatus.OK);
    }

    @PostMapping("/del")
    public ResponseEntity<String> del(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Log log = new Log();
        log.setUid(user.getId());
        log.setUsername(user.getUsername());
        log.setOperat("del");
        log.setTime(new Date());
        logService.addLog(log);

        System.out.println("... 执行del方法");
        return new ResponseEntity<>("del..OK", HttpStatus.OK);
    }

    //登录
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody User user, HttpServletRequest request) {
        try {
            User login = userService.login(user);
            if (login != null) {
                request.getSession().setAttribute("user", login);
                return new ResponseEntity<>(true, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(false, HttpStatus.OK);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
