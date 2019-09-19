package com.se.collection;

import org.junit.Test;

import java.util.HashMap;

public class MapToStringFormat {

    @Test
    public void demo1(){
        HashMap<String, String> map = new HashMap<>();
        map.put("adduser","kmj");
        map.put("addkey","12312321");
        System.out.println(map);
    }

}
