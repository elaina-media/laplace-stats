package net.mikoto.laplace.statistics;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("net.mikoto.laplace.statistics.mapper")
public class LaplaceStatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaplaceStatisticsApplication.class, args);
    }

}
