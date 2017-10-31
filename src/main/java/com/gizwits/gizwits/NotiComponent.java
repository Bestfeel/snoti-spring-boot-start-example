package com.gizwits.gizwits;

import com.gizwits.noti2.client.NotiClient;
import com.gizwits.noti2.client.NotiEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by feel on 2017/10/12.
 */
@Component
@Slf4j
public class NotiComponent {

    @Autowired
    private NotiClient notiClient;

    /**
     * 订阅(接收)推送事件消息
     */
    @Async
    public void consume() {

        Thread thread = new Thread(() -> {
            String messgae = null;
            while ((messgae = notiClient.reveiceMessgae()) != null) {
                log.info("实时接收snoti消息:{}", messgae);
            }
        });

        thread.start();

        notiClient.addListener(event -> {

            if (event == NotiEvent.DESTORY) {
                try {

                    while (!notiClient.messageNone()) {
                        TimeUnit.SECONDS.sleep(1);
                    }

                    thread.interrupt();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        });
    }

}
