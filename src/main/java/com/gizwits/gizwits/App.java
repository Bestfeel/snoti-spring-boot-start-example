package com.gizwits.gizwits;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by feel on 2017/10/12.
 */
@SpringBootApplication(scanBasePackages = {"com.gizwits"})
@Slf4j
public class App {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(App.class);
        springApplication.addListeners(new ApplicationStartup());
        springApplication.run(args);

    }
}
