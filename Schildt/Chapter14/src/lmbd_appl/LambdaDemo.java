package lmbd_appl;

public class LambdaDemo {
    public static void main(String[] args) {
        MyValue myValue;
        myValue = () -> 98.6;

        System.out.println("Constant value: " + myValue.getValue());

        MyParamValue myParamValue = n -> 1.0 / n;

        System.out.println("Reciprocal of 4 is " + myParamValue.getValue(4.0));
        System.out.println("Reciprocal of 8 is " + myParamValue.getValue(8.0));

    }
}
