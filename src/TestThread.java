/**
 * Created by Mayank on 9/5/16.
 */


public class TestThread {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static class Thread1 extends Thread{
        public void run(){
            synchronized (lock1){
                System.out.println("Thread 1 is holding on lock1..");
            }try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1 waiting for lock2");
            synchronized (lock2){
                System.out.println("Thread 1 now acquired lock 2 , holding both lock 1 and 2 ");
            }
        }

    }


    public static class Thread2 extends Thread{
        public void run(){
            synchronized (lock2){
                System.out.println("Thread 2 is holding on lock2..");
            }try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2 waiting for lock1");
            synchronized (lock1){
                System.out.println("Thread 2 has now acquired lock 1 , holding both lock 1 and 2 ");
            }
        }

    }


    public static void main(String[] args) {
        Thread1 t1= new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();

    }
}
