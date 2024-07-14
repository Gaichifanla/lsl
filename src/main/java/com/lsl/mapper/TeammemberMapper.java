package com.lsl.mapper;


import com.lsl.entity.Teammember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author acer
* @description 针对表【teammember】的数据库操作Mapper
* @createDate 2024-06-17 22:07:46
* @Entity .com.lsl.entity.Teammember
*/
@Mapper
public interface TeammemberMapper extends BaseMapper<Teammember> {


}
