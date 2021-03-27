package com.djx.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author jx.duan
 * @program: lottery
 * @Description:
 * @date: 2021-03-27 13:30
 */

@SpringBootApplication
@EnableTransactionManagement
public class LotteryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotteryApplication.class, args);
    }

}
