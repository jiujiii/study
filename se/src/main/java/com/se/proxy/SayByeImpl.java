package com.se.proxy;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/2 16:27
 */
public class SayByeImpl implements SayBye {

    private String bye = "bye";

    @Override
    public String sayBye() {
        return this.bye;
    }
}
