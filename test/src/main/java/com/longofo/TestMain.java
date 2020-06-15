package com.longofo;

import java.sql.Date;

public class TestMain {

    static {
        System.out.println("TestMain static block run...");
        java.sql.Date now = new Date(System.currentTimeMillis());
        System.out.println("TestMain Date :" + now);
    }

    public static void main(String[] args) {
        System.out.println("TestMain main start...");
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(3000);
                System.out.println("TestMain main running...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TestMain main end...");
    }
}