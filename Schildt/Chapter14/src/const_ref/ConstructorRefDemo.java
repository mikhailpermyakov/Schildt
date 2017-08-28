package const_ref;

public class ConstructorRefDemo {
    public static void main(String[] args) {
        MyFunc myClassCons = MyClass::new;

        MyClass myClass = myClassCons.func("Test");

        System.out.println("String str in myClass: " + myClass.getStr());
    }
}
