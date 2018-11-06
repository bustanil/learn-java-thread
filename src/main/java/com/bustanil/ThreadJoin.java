package com.bustanil;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override public void run() {
                try {
                    System.out.println("Waiting for 10 seconds");
                    Thread.sleep(10000);
                    System.out.println("Done.");
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                }

            }
        };

        Thread t = new Thread(r);

        t.start();
        t.join(); // main thread will be suspended waiting for thread t to finish
        System.out.println("This should print after thread t finished.");
    }

}
