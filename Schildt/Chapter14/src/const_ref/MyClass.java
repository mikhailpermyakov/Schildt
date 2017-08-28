package const_ref;

public class MyClass {
    private String str;

    public MyClass(String str) {
        this.str = str;
    }

    public MyClass() {
        str = "";
    }

    String getStr(){
        return str;
    }
}
