package com.lsl.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsl.entity.Team;
import com.lsl.entity.Teammember;
import com.lsl.mapper.TeammemberMapper;
import com.lsl.service.TeammemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author acer
* @description 针对表【teammember】的数据库操作Service实现
* @createDate 2024-06-17 22:07:46
*/
@Service
public class TeammemberServiceImpl extends ServiceImpl<TeammemberMapper, Teammember> implements TeammemberService {
    @Resource
    private TeammemberMapper teammemberMapper;

    /**
     * 根据teamId查询成员
     *
     * @param teamId
     * @return
     */
    @Override
    public List<Teammember> getTeamMemberTeamId(int teamId) {
        return teammemberMapper.selectList(Wrappers.<Teammember>lambdaQuery().eq(Teammember::getTeamId,teamId));
    }

    @Override
    public Teammember getTeamMemberByUserId(int userId) {
        return teammemberMapper.selectOne(Wrappers.<Teammember>lambdaQuery().eq(Teammember::getUserId,userId));
    }
}
