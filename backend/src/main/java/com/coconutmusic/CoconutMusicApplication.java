package com.coconutmusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class CoconutMusicApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoconutMusicApplication.class, args);
    }
}
