package threadDemo;

/**
 * Created by Mayank on 9/6/16.
 */
public class Singleton {
    private volatile static Singleton singleton = null;
    private Singleton(){

    }

    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton = new Singleton();
                }
            }
        }return singleton;
    }

    public static void main(String[] args) {
        Singleton temp = new Singleton();

    }
}