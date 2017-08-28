class MyIntPredicates{
    static boolean isPrime(int n){
        if(n < 2) return false;
        for (int i = 2; i < n / i; i++) {
            if((n % i) == 0)
                return false;
        }
        return true;
    }
    static boolean isEven(int n){
        return (n % 2) == 0;
    }

    static boolean isPositive(int n){
        return n > 0;
    }
}
public class MethodRefDemo {
    private static boolean numTest(IntPredicate p, int v){
        return p.test(v);
    }
    public static void main(String[] args) {
        boolean result = numTest(MyIntPredicates::isPrime, 17);

        if (result) System.out.println("17 is a prime number");

        result = numTest(MyIntPredicates::isEven, 12);
        if(result) System.out.println("12 is an even number");

        result = numTest(MyIntPredicates::isPositive, -2);
        if(!result) System.out.println("-2 is not a positive number");



    }
}
