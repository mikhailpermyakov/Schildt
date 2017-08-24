class TwoGen<T, V>{
    T obT;
    V obV;

    TwoGen(T obT, V obV){
        this.obT = obT;
        this.obV = obV;
    }

    void showTypes(){
        System.out.println("Type T is " + obT.getClass().getName());
        System.out.println("Type V is " + obV.getClass().getName());
    }

    T getObT(){
        return obT;
    }

    V getObV(){
        return obV;
    }
}

public class SimpGen {
    public static void main(String[] args) {
        TwoGen<Integer, String> tgObj = new TwoGen<>(88,"Generics");

        tgObj.showTypes();

        int t = tgObj.getObT();
        System.out.println(t);

        String str = tgObj.getObV();
        System.out.println(str);
    }
}
