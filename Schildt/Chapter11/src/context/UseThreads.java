package context;

class MyThread implements Runnable{
    String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("starting " + threadName + "...");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(400);
                System.out.println("Counter value in " + threadName + " is " + i);
            }
        } catch (InterruptedException exc){
            System.out.println(threadName + " interrupted...");
        }
        System.out.println("terminating " + threadName + "...");
    }
}

class ImprovedThread implements Runnable{

    Thread thread;
    public ImprovedThread(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("starting " + thread.getName() + "...");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(300);
                System.out.println("Counter value in " + thread.getName() + " is " + i);
            }
        } catch (InterruptedException exc){
            System.out.println(thread.getName() + " interrupted");
        }
        System.out.println("terminating " + thread.getName() + "...");
    }
}
public class UseThreads{
    public static void main(String[] args) {
        System.out.println("starting main thread...");

        MyThread mt = new MyThread("child#1 of MyThread");
        Thread newThrd = new Thread(mt);
        newThrd.start();

        ImprovedThread it = new ImprovedThread("child#1 of ImprovedThread");

        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
               // System.out.println("Counter value in main is " + i);
            } catch (InterruptedException exc){
                System.out.println("Interruption of the main thread");
            }
        }
        System.out.println("finishing the main thread");
    }
}
