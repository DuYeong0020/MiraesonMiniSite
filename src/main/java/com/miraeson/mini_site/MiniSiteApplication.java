package com.miraeson.mini_site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication @EntityScan("com.miraeson.domain")
public class MiniSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniSiteApplication.class, args);
    }

}
