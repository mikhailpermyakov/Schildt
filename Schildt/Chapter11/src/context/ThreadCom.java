package context;

class TickTock{
    private String state;

    synchronized void tick(boolean running){
        if(!running){
            state = "ticked";
            notify();
            return;
        }
        System.out.println("Tick ");

        state = "ticked";
        notify();

        try{
            while(!state.equals("tocked"))
                wait();
        } catch (InterruptedException exc){
            System.out.println("Thread interrupted...");
        }
    }

    synchronized void tock(boolean running){
        if(!running){
            state = "tocked";
            notify();
            return;
        }
        System.out.println("Tock");

        state = "tocked";
        notify();

        try{
            while(!state.equals("ticked"))
                wait();
        } catch (InterruptedException exc){
            System.out.println("Thread interrupted");
        }
    }
}
class MyThread1 implements Runnable{
    Thread thread;
    private TickTock ttOb;

    MyThread1(String name, TickTock ttOb){
        thread = new Thread(this, name);
        this.ttOb = ttOb;
        thread.start();
    }
    public void run(){
        if(thread.getName().compareTo("Tick") == 0){
            for (int i = 0; i < 5; i++) {
                ttOb.tick(true);
            }
            ttOb.tick(false);
        }else {
            for (int i = 0; i < 5; i++) {
                ttOb.tock(true);
            }
            ttOb.tock(false);
        }
    }
}
public class ThreadCom {
    public static void main(String[] args) {
        TickTock tt = new TickTock();
        MyThread1 mt1 = new MyThread1("Tick", tt);
        MyThread1 mt2 = new MyThread1("Tock", tt);

        try {
            mt1.thread.join();
            mt2.thread.join();
        }catch (InterruptedException exc){
            System.out.println("Main thread interrupted");
        }
    }
}
