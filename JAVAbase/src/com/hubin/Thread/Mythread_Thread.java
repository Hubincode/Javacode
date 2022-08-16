package com.hubin.Thread;

public class Mythread_Thread extends Thread{
    @Override
    public void run() {
        System.out.println(getName()+" is running");
        super.run();
    }

    public static void main(String[] args) {
        Mythread_Thread mythreadThread =new Mythread_Thread();
        Mythread_Thread mythreadThread2 =new Mythread_Thread();
        mythreadThread.start();
        mythreadThread2.start();
    }
}
