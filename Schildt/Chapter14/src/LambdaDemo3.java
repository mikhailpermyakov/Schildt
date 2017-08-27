interface StringTest{
    boolean test(String aStr, String bStr);
}
public class LambdaDemo3 {
    public static void main(String[] args) {
        StringTest isIn = (a, b) -> a.indexOf(b) != -1;

        String str = "This is a test";

        System.out.println("The tested string is: " + str);

        if(isIn.test(str, "This"))
            System.out.println("'This' found");
        else
            System.out.println("'This' not found");

        if(isIn.test(str, "xuz"))
            System.out.println("'xyz' found");
        else
            System.out.println("'xyz' not found");
    }
}
