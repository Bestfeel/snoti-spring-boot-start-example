package com.gizwits.gizwits;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationStartup.class);

    public void onApplicationEvent(ContextRefreshedEvent event) {

        NotiComponent notiComponent = (NotiComponent) event.getApplicationContext().getBean(NotiComponent.class);
        notiComponent.consume();

    }
}