public class Start {

    A f1;
    B f2;
    C f3;

    public Start() {
        f1 = new A();
        f2 = new B();
        f3 = new C();
        f1.message();
        f1=f2;
        f1.message();
        f1=f3;
        f1.message();
        f2.message_from_a();
        f3.message();}

    public static void main(String args[]) {
        new Start();}
}

class A {
    void message() {
        System.out.print("A ");}
}

class B extends A {
    void message() {
        System.out.print("B ");}
    void message_from_a() {
        super.message();}
}

class C extends A {
    void message() {
        System.out.print("C ");}
}