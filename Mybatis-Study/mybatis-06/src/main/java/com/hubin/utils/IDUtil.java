package com.hubin.utils;

import org.junit.Test;

import java.util.UUID;

public class IDUtil {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void testgetId(){
        System.out.println(getId());
    }
}
