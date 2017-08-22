package context;

class MyThread2 implements Runnable{
    public Thread thread;

    private volatile boolean suspended;
    private volatile boolean stopped;

    MyThread2(String name){
        thread = new Thread(this, name);
        suspended = false;
        stopped = false;
        thread.start();
    }

    public void run(){
        System.out.println(thread.getName() + " - starting");
        try {
            for (int i = 1; i < 1000; i++) {
                System.out.print(i + " ");
                if((i%10) == 0){
                    System.out.println();
                    Thread.sleep(250);
                }
                synchronized (this){
                    while (suspended){
                        wait();
                    }
                    if(stopped) break;
                }
            }
        }catch (InterruptedException exx){
            System.out.println(thread.getName() + " - interrupted");
        }
        System.out.println(thread.getName() + " - exit");
    }

    synchronized void mystop(){
        stopped = true;
        suspended = false;
        notify();
    }
    synchronized void mysuspend(){
        suspended = true;
    }

    synchronized void myresume(){
        suspended = false;
        notify();
    }
}
public class Suspend {
    public static void main(String[] args) {
        MyThread2 ob1 = new MyThread2("My Thread");

        try{
            Thread.sleep(1000);

            ob1.mysuspend();
            System.out.println("Thread suspended...");
            Thread.sleep(1000);

            ob1.myresume();
            System.out.println("Thread resumed...");
            Thread.sleep(1000);

            ob1.mysuspend();
            System.out.println("Thread suspended...");
            Thread.sleep(1000);

            ob1.myresume();
            System.out.println("Thread resumed...");
            Thread.sleep(1000);

            ob1.mysuspend();
            System.out.println("Thread suspended...");
            ob1.mystop();
        } catch (InterruptedException exc){
            System.out.println("Main thread interrupted");
        }
        try{

            ob1.thread.join();
        }catch (InterruptedException exc){
            System.out.println("Main thread interrupted");
        }

        System.out.println("Leaving main thread");
    }
}
