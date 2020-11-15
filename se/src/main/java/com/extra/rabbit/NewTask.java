package com.extra.rabbit;

import com.google.common.collect.Lists;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/4 07:27
 */
@Slf4j
public class NewTask {

    private static final String QUEUE_WORK = "WORK";

    public static void main(String[] args) throws IOException, TimeoutException {
        final ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        Connection connection = connectionFactory.newConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_WORK, false, false, false, null);
        final List<String> strs = Lists.newArrayList(
                "First message.",
                "Second message..",
                "Third message...",
                "Fourth message....",
                "Fifth message.....");
        for (String str : strs) {
            log.info("发送消息：[{}]",str);
            channel.basicPublish("",QUEUE_WORK,null,str.getBytes(StandardCharsets.UTF_8));
        }
    }

}
