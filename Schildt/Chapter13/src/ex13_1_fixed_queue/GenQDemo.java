package ex13_1_fixed_queue;

public class GenQDemo {
    public static void main(String[] args) {
        Integer iStore[] = new Integer[10];
        Double dStore[] = new Double[10];

        GenQueue<Integer> q = new GenQueue<>(iStore);
        GenQueue<Double> q2 = new GenQueue<>(dStore);

        Integer iVal;

        System.out.println("Demonstration of number queue of type Integer");

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Adding " + i + " to the queue q");
                q.put(i);
            }
        }catch (QueueFullException exc){
            System.out.println(exc);
        }
        System.out.println();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("Getting next Integer type number from the q: ");
                iVal = q.get();
                System.out.println(iVal);
            }
        }catch (QueueEmptyException exc){
            System.out.println(exc);
        }
        System.out.println();


        Double dVal;

        System.out.println("Demonstration of number queue of type Double");

        try{
            for (int i = 0; i < 5; i++) {
                System.out.println("Adding " + (double)i/2 + " to the q2");
                q2.put((double)i/2);
            }
        }catch (QueueFullException exc){
            System.out.println(exc);
        }
        System.out.println();

        try{
            for (int i = 0; i < 5; i++) {
                System.out.print("Getting next Double type number from the q2: ");

                dVal = q2.get();
                System.out.println(dVal);
            }
        }catch (QueueEmptyException exc){
            System.out.println(exc);
        }
    }
}
