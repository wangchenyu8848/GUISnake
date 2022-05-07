package com.wcy.GUI.snake;

public class TimeDemo{

    public static void main(String[] args) {
        // run in a second
        // 每一秒钟执行一次
        final long timeInterval = 1000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //创建定时器
        Thread thread = new Thread(runnable);
        //开始执行
        thread.start();
    }
}