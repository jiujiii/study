package com.extra.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/4 07:28
 */
@Slf4j
public class Work {

    private static final String QUEUE_WORK="WORK";

    public static void main(String[] args) throws IOException, TimeoutException {
        final ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        Connection connection = connectionFactory.newConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_WORK,false,false,false,null);
        channel.basicConsume(QUEUE_WORK,true,(customerTag,deliver) -> {
            String message = new String(deliver.getBody(),StandardCharsets.UTF_8);
            log.info("接收消息：[{}]",message);
            try {
                doWork(message);
            } catch (InterruptedException e) {
                log.info("线程终端");
            }
        },customerTag -> {});
    }

    private static void doWork(String task) throws InterruptedException {
        for (char ch: task.toCharArray()) {
            if (ch == '.') Thread.sleep(1000);
        }
    }
}
