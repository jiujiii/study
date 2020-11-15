package com.extra.spring.eventbus;

import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/3 08:49
 */
public class EventBusTest {

    @Test
    public void demo(){
        new LogPublisher().publishEvent(new LogEvent("logloglog"));
    }

}
