package com.lsl.mapper;

import com.lsl.entity.Priority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PriorityMapper {
    /**
     * 查询所有任务等级
     * @return
     */
    @Select("select * from priority")
    public List<Priority> list();
}
