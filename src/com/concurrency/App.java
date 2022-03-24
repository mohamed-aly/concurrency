package com.concurrency;
class Runner1 extends Thread {

    @Override
    public void run() {
        for(int i = 0; i < 100; ++i){
            System.out.println("Runner1 " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Runner2 extends Thread {


    @Override
    public void run() {
        for(int i = 0; i < 100; ++i){
            System.out.println("Runner2 " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class App {
    public static void main(String[] args) {
        Thread runner1 = new Runner1();
        Thread runner2 = new Runner2();

        runner1.start();
        runner2.start();

        try {
            //wait for this thread to die
            runner1.join();
            runner2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished the tasks...");
    }
}
