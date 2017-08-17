package context;

class MyThread implements Runnable{
    String thrdName;

    public MyThread(String thrdName) {
        this.thrdName = thrdName;
    }

    @Override
    public void run() {
        System.out.println("starting" + thrdName);
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(400);
                System.out.println("Counter value in " + thrdName + " is " + i);
            }
        } catch (InterruptedException exc){
            System.out.println(thrdName + " interrupted");
        }
        System.out.println("terminating " + thrdName + "...");
    }
}
public class UseThreads{
    public static void main(String[] args) {
        System.out.println("starting main thread...");

        MyThread mt = new MyThread("child#1");

        Thread newThrd = new Thread(mt);
        newThrd.start();

        for (int i = 0; i < 50; i++) {
            System.out.println(".");
            try {
                Thread.sleep(100);
                System.out.println("Counter value in main is " + i);
            } catch (InterruptedException exc){
                System.out.println("Interruption of the main thread");
            }
        }
        System.out.println("finishing the main thread");
    }
}
