package com.bustanil;

public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override public void run() {
                try {
                    System.out.println("Waiting for 10 seconds");
                    Thread.sleep(10000);
                    System.out.println("Done.");
                } catch (InterruptedException e) {
                    System.out.println(Thread.interrupted()); // will print false because thrown InterruptedException already clear the interrupted status
                    System.out.println("Interrupted!");
                }

            }
        };

        Thread t = new Thread(r);

        t.start();
        System.out.println("Wait for 3 seconds then interrupt");
        Thread.sleep(3000);
        t.interrupt();
    }

}
