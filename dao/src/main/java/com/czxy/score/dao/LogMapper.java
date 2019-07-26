package com.czxy.score.dao;

import com.czxy.domain.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @version v 1.0
 * @date 2019/7/25
 */
@Mapper
public interface LogMapper {

    @Insert("INSERT INTO tab_log VALUES(#{id},#{uid},#{username},#{operat},#{time})")
    public void addLog(Log log);
}
