package com.extra.spring.eventbus;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/3 08:40
 */
public class LogEvent implements EventSource {

    private String logContent;

    public LogEvent(String logContent) {
        this.logContent = logContent;
    }
}
