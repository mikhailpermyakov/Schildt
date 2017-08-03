package com.q_and_e;

class Swap {
    private int a;
    private int aSwap;
    Swap(int i){
        a = i;
    }

    public void swap(Swap obj){
        aSwap = obj.a;
        obj.a = this.a;
        this.a = aSwap;
    }

    public int getA(){
        return a;
    }
}

public class SwapDemo {
    public static void main(String[] args) {

        Swap swap1 = new Swap(5);
        Swap swap2 = new Swap(10);

        System.out.println("original objects:");
        System.out.println("swap1.a = " + swap1.getA());
        System.out.println("swap2.a = " + swap2.getA());

        swap1.swap(swap2);

        System.out.println("after swap1.swap(swap2):");
        System.out.println("swap1.a = " + swap1.getA());
        System.out.println("swap2.a = " + swap2.getA());

        swap2.swap(swap1);

        System.out.println("after swap2.swap(swap1):");
        System.out.println("swap1.a = " + swap1.getA());
        System.out.println("swap2.a = " + swap2.getA());

        swap2.swap(swap1);

        System.out.println("swap1.swap(swap2) once again:");
        System.out.println("swap1.a = " + swap1.getA());
        System.out.println("swap2.a = " + swap2.getA());

    }
}
