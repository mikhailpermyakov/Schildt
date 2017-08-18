package context;

class MyExtendThread extends Thread{
    public MyExtendThread(String name) {
        super(name);
        System.out.println("constructing " + name);
        /*this.*/start();
    }

    @Override  //optional
    public void run() {
        System.out.println("running " + getName() + "...");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(300);
                System.out.println("\t\tCounter value in " + getName() + " is " + i);
            }
        } catch (InterruptedException exc){
            System.out.println(getName() + " interrupted");
        }
        System.out.println("\tterminating " + getName() + "...");
    }
}
public class ExtendThread {
    public static void main(String[] args) {
        System.out.println("Starting main thread...");

      /*  MyExtendThread myExtendThread = */new MyExtendThread("Child #1 of MyExtendThread");

        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Interruption of main thread");
            }

        }
        System.out.println("Terminating main thread...");
    }
}
