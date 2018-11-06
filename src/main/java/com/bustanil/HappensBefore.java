package com.bustanil;

public class HappensBefore {

    public static void main(String[] args) {
        // https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/package-summary.html#MemoryVisibility
        // 1. Each action in a thread happens-before every action in that thread that comes later in the program's order.
        int x = 0;
        int y = x + 10;
        System.out.println(y); // should be consistently 10

        // 2. An unlock (synchronized block or method exit) of a monitor happens-before every subsequent lock (synchronized block or method entry) of that same monitor.
        // And because the happens-before relation is transitive, all actions of a thread prior to unlocking happen-before all actions subsequent to any thread locking that monitor.

        final Object monitor = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("Thread 1 is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (monitor) {
                    System.out.println("Thread 1 got the lock!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread 1 released the lock!");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("Thread 2 is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (monitor) {
                    System.out.println("Thread 2 got the lock!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread 2 released the lock!");

            }
        });

        t1.start();
        t2.start();



    }

}
