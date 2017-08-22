package context;

class SumArray{

    synchronized int sumArray(int nums[]){
        int sum = 0;

        for (int num : nums) {
            sum += num;
            System.out.println("Current value of " + Thread.currentThread().getName() + ": " + sum);

            try {
                Thread.sleep(10);
            } catch (InterruptedException exc) {
                System.out.println("Main thread interrupted");
            }
        }
        return sum;
    }
}
class MyThread0 implements Runnable{
    private Thread thread;
    private static SumArray sa = new SumArray();
    private int nums[];

    MyThread0 (String name, int nums[]){
        thread = new Thread(this, name);
        this.nums = nums;
        thread.start();
    }
    public void run(){

        System.out.println(thread.getName() + " - starting...");

        int answer = sa.sumArray(nums);
        System.out.println("Sum for " + thread.getName() + ": " + answer);

        System.out.println(thread.getName() + " - finishing...");
    }
}
public class Sync {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};

        MyThread0 mt1 = new MyThread0("Child #1", nums);
        MyThread0 mt2 = new MyThread0("Child #2", nums);
    }
}
