package com.hubin.honer;

import org.junit.Test;

import java.util.*;

public class Main {
    private static Map<String,Integer> map=new HashMap<>();
    public  static void main(String[] args) {
        int ans=0;
        Scanner in = new Scanner(System.in);
        String string=in.nextLine();
        addmap();
        char[] chars=string.toCharArray();
        for(int i = 0; i<chars.length; i++){
            if(map.containsKey(String.valueOf(chars[i]))){
                ans+=map.get(String.valueOf(chars[i]));
            }

        }
        System.out.println(ans);
    }
    public static void addmap(){
        map.put("0",1);
        map.put("4",1);
        map.put("6",1);
        map.put("8",2);
        map.put("9",1);
        map.put("a",1);
        map.put("b",1);
        map.put("d",1);
        map.put("e",1);
        map.put("A",1);
        map.put("B",2);
        map.put("D",1);
    }

    @Test
    public void test(){
        Main main=new Main();
        String[] args={"1","2"};
        main.main(args);

    }

}