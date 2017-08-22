package context;

public class UseMain {
    public static void main(String[] args) {
        Thread thread;
        thread = Thread.currentThread();
        System.out.println("Name of the main thread is " + thread.getName());

        System.out.println("Priority value is " + thread.getPriority());
        System.out.println();

        System.out.println("Setting name and priority\n");
        thread.setName("Thread #1");
        thread.setPriority(Thread.NORM_PRIORITY+3);

        System.out.println("New thread name is " + thread.getName());
        System.out.println("New priority value is " + thread.getPriority());
    }
}
