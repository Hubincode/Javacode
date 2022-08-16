package com.hubin.honer;

import org.junit.Test;

import java.util.*;

public class Main2 {
    private static final Map<Integer,String> mapA=new HashMap<>();
    private static final Map<Integer,String> mapB=new HashMap<>();
    public  static void main(String[] args) {
        String ans="";
        Map<Integer,String> res=new HashMap<>();
        Scanner in = new Scanner(System.in);
//        String a =in.nextLine();
//        String b =in.nextLine();
        String a="abcbdab";
        String b="bcdbda";
        chaifeng(a,mapA);
        chaifeng(b,mapB);
        for(int i=0;i<mapB.size();i++){
            if(mapA.containsValue(mapB.get(i))){
                res.put(i,mapB.get(i));
            }
        }
//        Iterator<Map.Entry<Integer, String>> integer=res.entrySet().iterator();
        Iterator<Map.Entry<Integer, String>> integer=res.entrySet().iterator();
        while(integer.hasNext()){
            Map.Entry<Integer, String> next = integer.next();
            if(res.containsKey(next.getKey()+1)){
                ans+=next.getValue().substring(0,1);
            }else {
                ans+=next.getValue();
            }
        }


        System.out.println(ans.length());
    }
    private static void chaifeng(String string,Map<Integer,String> map){
        for(int i=0;i<string.length()-1;i++){
            map.put(i,string.substring(i,i+2));
        }

    }
}