package com.djx.lottery.controller;

import com.djx.lottery.bean.User;
import com.djx.lottery.service.LotteryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.naming.Name;
import java.util.List;
import java.util.Map;

/**
 * @author jx.duan
 * @program: lottery
 * @Description:
 * @date: 2021-03-27 16:46
 */
@RequestMapping("/lottery")
@RestController
public class LotteryController {

    @Resource
    LotteryService lotteryService;


    @RequestMapping("/add/user/{name}")
    public String add(@PathVariable("name") String name){
        lotteryService.addUser(name);
        return "success 成功啦";
    }


    @RequestMapping("/sum/user")
    public String sum(){
        long sums = lotteryService.sums();

        return "success 成功啦 总参加人数:"+sums;
    }

    //不删除用户
    @RequestMapping("/user/{qua}")
    public String lottery(@PathVariable("qua") Long qua){

        List<User> list = lotteryService.lotteryUser(qua);
        return "success 成功啦 获奖:"+list;
    }

    //获奖之后 删除redis用户
    @RequestMapping("/pop/user/{qua}")
    public String pop(@PathVariable("qua") Long qua){
        List<User> list = lotteryService.lotteryUserByDelete(qua);
        return "success 成功啦 获奖:"+list;
    }


    //清空redis中抽奖用户
    @RequestMapping("/del/user")
    public String del(){
         lotteryService.deleteUserByRedis();
        return "success 成功啦";
    }
}
