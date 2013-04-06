public class Start {

	public static void main(String args[]) {
		C c = new C();
		int result = c.zork();
		System.out.println(result);
		B b = new B();
		result = b.zork();
		System.out.println(result);
	}
}

class A {

	public int foo() {
		return 1;
	}

	public int zork() {
		return this.bar();
	}

	public int bar() {
		return 3;
	}

}

class B extends A {

	public int foo() {
		return super.zork();
	}

}

class C extends B {

	public int zork() {
		return this.foo() + 5;
	}

	public int bar() {
		return 7;
	}

}

