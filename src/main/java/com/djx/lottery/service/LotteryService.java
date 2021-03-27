package com.djx.lottery.service;

import com.djx.lottery.bean.User;

import java.util.List;

/**
 * @author jx.duan
 * @program: lottery
 * @Description:
 * @date: 2021-03-27 16:16
 */
public interface LotteryService {

    //添加用户
    void addUser(String name);

    //获奖n名 不删除用户
    List<User> lotteryUser(long i);

    //获取n名用户 获取完之后删除用户 （用于一等奖 二等奖 三等奖 ）
    List<User> lotteryUserByDelete(long i);

    //参加总人数
    long sums();

    //清空redis用户
    void deleteUserByRedis();
}
