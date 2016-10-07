package threadDemo;

/**
 * Created by Mayank on 10/6/16.
 */

// by making sure that thread acquires locks in order, can ensure that deadlock wont occur in the application
public class TestThreadSolution {
    public static Object Lock1 = new Object();   // lock 1
    public static Object Lock2 = new Object();   // lock 2

    public static void main(String args[]) {
        ThreadDemo1 T1 = new ThreadDemo1();
        ThreadDemo2 T2 = new ThreadDemo2();
        T1.start();
        T2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (Lock1) {  // thread 1 first acquires lock 1 and then waits for lock 2 then acquires both locks
                System.out.println("Thread 1: Holding lock 1...");

                try {
                    Thread.sleep(10);
                }catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (Lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (Lock1) { // thread 2 first acquires lock 1 and then waits for lock 2 and then acquires both locks
                System.out.println("Thread 2: Holding lock 1...");

                try {
                    Thread.sleep(10);
                }catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 2...");

                synchronized (Lock2) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }


}
