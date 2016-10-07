package threadDemo;

/**
 * Created by Mayank on 9/6/16.
 */
public class Singleton {

    private static Singleton instance;
    //will create multiple instances of Singleton class if called by more than one thread parallel

    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
            instance=new Singleton();}
        }
        return instance;
    }




    //Without volatile modifier it's possible for another thread in Java to see half initialized state of singleton variable,
    // but with volatile variable guaranteeing happens-before relationship,
    // all the write will happen on volatile _instance before any read of _instance variable.

    private volatile static Singleton singleton = null;
    private Singleton(){

    }

    public static Singleton getSingleton(){
        if (singleton == null){  // Single Checked  check 1 - without locking
            synchronized (Singleton.class){
                if(singleton==null){ //Double Checked - with locking
                    singleton = new Singleton();
                }
            }
        }return singleton;
    }

    public static void main(String[] args) {
        Singleton temp = new Singleton();

    }
}