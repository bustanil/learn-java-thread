package com.bustanil;

public class WaitNotify {

    public static void main(String[] args) throws InterruptedException {

        final Object monitor = new Object();

        Thread t = new Thread(new Runnable() {
            @Override public void run() {
                synchronized (monitor) {
                    try {
                        System.out.println("Waiting for monitor");
                        monitor.wait();
                        System.out.println("Should print after this thread is notified");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();
        Thread.sleep(1000);
        System.out.println("Notifying the thread waiting for monitor");

        synchronized (monitor) { // wait and notify should always be done in a synchronized block!
            monitor.notify();
        }
    }

}
