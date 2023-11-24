package com.lsl.service.impl;

import com.lsl.mapper.TeammemberMapper;
import com.lsl.service.TeammemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeammemberServiceImpl implements TeammemberService {
    @Resource
    private TeammemberMapper teammemberMapper;

}
