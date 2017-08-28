package exercises;

interface Range{
    boolean isIn(int n);
}

public class Ex14_5 {
    public static void main(String[] args) {
        Range rng = n -> (n >= 10) && (n <=20);

        System.out.println(rng.isIn(21));
        System.out.println(rng.isIn(15));
    }
}
