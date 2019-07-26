package com.czxy.score.service;

import com.czxy.domain.Log;
import com.czxy.score.dao.LogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @version v 1.0
 * @date 2019/7/25
 */
@Service
@Transactional
public class LogService {

    @Resource
    private LogMapper logMapper;

    public void addLog(Log log){
        logMapper.addLog(log);
    }
}
