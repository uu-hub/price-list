package io.zbc.price;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableScheduling
@EnableAsync
@EnableTransactionManagement
@MapperScan({"io.zbc.price.dao"})
@SpringBootApplication
public class PriceListApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriceListApplication.class);
    }

}
