package com.hubin.String;
import org.junit.Test;

import java.lang.Object;
import java.util.Collection;

public class Stringtest {
    private String string;


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Test
    public void Gettime(){
        Stringtest stringtest;
        long l=System.currentTimeMillis();
        System.out.println(l);
    }
}
