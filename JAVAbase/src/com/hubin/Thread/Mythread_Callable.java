package com.hubin.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Mythread_Callable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(getClass()+" is running");
        return "lalalalala";
    }

    public static void main(String[] args) {
        Mythread_Callable mythread_callable=new Mythread_Callable();
        FutureTask futureTask=new FutureTask(mythread_callable);
        Thread thread=new Thread(futureTask);
        thread.start();
        while(true) {
            ;
        }
    }
}
