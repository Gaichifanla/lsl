package com.lsl.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsl.annotation.TaskLog;
import com.lsl.entity.Tasklog;
import com.lsl.service.TasklogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

@Aspect
@Component
public class TaskLogAspect {
//    @After("@annotation(taskLog)")
//    public void afterMethod(JoinPoint joinPoint,TaskLog taskLog){
//        ExpressionParser expressionParser = new SpelExpressionParser();
//        Expression expression=expressionParser.parseExpression(taskLog.spel());
//        String value = taskLog.value();
//        System.out.println(value);
//        System.out.println(Arrays.toString(joinPoint.getArgs()));
//
//    }
    @Resource
    private TasklogService tasklogService;
    @Around("@annotation(taskLog)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint, TaskLog taskLog) throws Throwable {
        Object[] args = joinPoint.getArgs();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonParam=objectMapper.writeValueAsString(args);


        // 解析JSON数组字符串为JSONArray对象
        JSONArray jsonArray = JSON.parseArray(jsonParam);

        JSONObject jsonObject = new JSONObject();
        // 遍历JSONArray中的元素
        for (Object obj : jsonArray) {
            if (obj instanceof JSONObject) {
                jsonObject = (JSONObject) obj;
                // 处理JSONObject对象
                System.out.println(jsonObject);
            }
        }


        int operatorid = Integer.parseInt(jsonObject.getString("userId"));
        String type = taskLog.type();
        int taskid = Integer.parseInt(jsonObject.getString("id"));
        String note = taskLog.value();

//        System.out.println(operatorid+type+taskid+note);

        Tasklog tasklog = Tasklog.builder()
                .operatorid(operatorid)
                .taskid(taskid)
                .note(note)
                .type(type)
                .build();

        tasklogService.insertTaskLog(tasklog);
        return joinPoint.proceed();
    }
}
