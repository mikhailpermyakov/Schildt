package exercises;

interface NumericFunc{
    int func(int n);
}
public class FactorialWithLambda {
    public static void main(String[] args) {
        MyFunc<Integer> nf = n -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };

        System.out.println("5! = " + nf.func(5));
        System.out.println("6! = " + nf.func(6));
    }
}
