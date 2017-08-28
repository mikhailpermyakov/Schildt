public class MethodRefDemo2 {
    public static void main(String[] args) {
        boolean result;

        MyIntNum myNum = new MyIntNum(12);
        MyIntNum myNum2 = new MyIntNum(16);
        MyIntNum myNum3 = new MyIntNum(35);

        IntPredicate ip = myNum::isFactor;

        result = ip.test(3);
        if(result) System.out.println("3 is a divider of " + myNum.getNum());

        IntPredicate ip2 = myNum2::isFactor;
        result = ip2.test(3);
        if (!result) System.out.println("3 is not a divider of " + myNum2.getNum());

        IntPredicate ip3 = myNum3::hasCommonFactor;
        result = ip3.test(6);
        System.out.println(result);
    }

}
