import java.util.function.Predicate;

public class UsePredicateInterface {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> (n % 2) == 0;

        if(isEven.test(4)) System.out.println("4 is an even number");
        if(!isEven.test(5)) System.out.println("5 is not an even number");
    }

}
