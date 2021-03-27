package com.djx.lottery.service.impl;

import com.djx.lottery.bean.User;
import com.djx.lottery.service.LotteryService;
import com.djx.lottery.utils.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author jx.duan
 * @program: lottery
 * @Description:
 * @date: 2021-03-27 16:16
 */
@Service
public class LotteryServiceImpl implements LotteryService {

    //由于没用mysql  用mqp存储用户信息
    private Map<Integer, User> map = new HashMap<>();
    private int a = 1;

    @Resource
    RedisUtil redisUtil;


    @Override
    public void addUser(String name) {
        User user = new User();
        a=a++;
        user.setId(a);
        user.setName(name);
        map.put(a , user);
        redisUtil.sSet("JoinUser",(int)a);

    }

    @Override
    public List<User> lotteryUser(long i) {
        List<String> users = redisUtil.sGetRand("JoinUser", i);

        List<User> list = users.stream().map(x -> {
            User user = map.get(x);
            return user;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<User> lotteryUserByDelete(long i) {
        List<String> users = redisUtil.sGetRandAndDel("JoinUser", i);
        List<User> list = users.stream().map(x -> {
            User user = map.get(x);
            return user;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public long sums() {
        long joinUser = redisUtil.sGetSetSize("JoinUser");
        System.out.println(map);
        return joinUser;
    }


    @Override
    public void deleteUserByRedis() {
        redisUtil.del("JoinUser");
    }
}
