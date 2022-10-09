package com.TCU;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableSwagger2
@EnableScheduling
@EnableAsync
@EnableKnife4j
public class AcidApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcidApplication.class,args);
    }
}