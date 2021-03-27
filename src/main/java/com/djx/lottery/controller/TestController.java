package com.djx.lottery.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jx.duan
 * @program: lottery
 * @Description:
 * @date: 2021-03-27 14:09
 */
@RequestMapping("/test")
@RestController
public class TestController {



    @RequestMapping("/12")
    public String get(){
        return "success 成功啦";
    }
}
