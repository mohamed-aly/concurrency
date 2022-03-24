package com.concurrency;

class Runner extends Thread {

    //forces variable to be stored in main memory not the cache memory
    //of the processor
    //volatile is slower
    private volatile boolean isTerminated = false;

    @Override
    public void run() {
        while (!isTerminated) {
            System.out.println("Doing some stuff!");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isTerminated() {
        return isTerminated;
    }

    public void setTerminated(boolean terminated) {
        isTerminated = terminated;
    }
}

public class Worker {

    public static void main(String[] args) {
        Runner thread = new Runner();
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.setTerminated(true);
    }
}
