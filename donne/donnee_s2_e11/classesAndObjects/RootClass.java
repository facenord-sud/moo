public class RootClass {

    Class1 c1,c2;
    Class2 s;

    public RootClass() {
        s = new Class2("ABC");
        c1 = new Class1("ABC", s);
        c2 = f1().f1();       // [II]
        System.out.println(s.toString()+" "+c1.toString()+" "+c2.toString());
    }

    public static void main(String[] args) {
        new RootClass();
    }

    Class1 f1() {
        Class1 result = new Class1("Cuckoo", new Class2("Cuckoo")); // [III]
        return (Class1)c1.clone();
    }
}

class Class1 implements Cloneable {

    int i;
    String s1;
    Class2 s2;

    public Class1(String init, Class2 mo) {
        i = 1;
        s1 = new String(init); // [I]
        s2 = mo;
        s1=s1.concat("DEF");
        s2.concat("XYZ");
    }

    public Object clone() {
        try {
            return super.clone();}
        catch (CloneNotSupportedException e) {
            // This should never happen
            throw new InternalError(e.toString());}
    }

    public Class1 f1() {
        s1 = "123";
        i = i+1;
        return this;
    }
}

class Class2 {

    private String contents;

    public Class2(String init) {contents=init;}

    public void concat(String s) {
        contents=contents.concat(s);
    }

    
}