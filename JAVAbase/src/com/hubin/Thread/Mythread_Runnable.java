package com.hubin.Thread;

public class Mythread_Runnable implements Runnable{
    @Override
    public void run() {
        System.out.println(getClass()+" is running");
    }

    public static void main(String[] args) {
        Mythread_Runnable mythread2=new Mythread_Runnable();
        Thread thread=new Thread(mythread2);
        thread.start();
    }
}
