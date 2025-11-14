package com.daonq1408.springbootsetup;

import com.daonq1408.springbootsetup.config.DotEnvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSetupApplication {

    public static void main(String[] args) {
        DotEnvConfig.loadEnv();
        SpringApplication.run(SpringBootSetupApplication.class, args);
    }

}
