package composite;

public class Constant implements Expression {

    private int constant;

    public Constant(int constant) {
        this.constant = constant;
    }

    public Constant(int constantLeft, int constantRight) {
    }

    @Override
    public int depth() {
        return 0;
    }

    @Override
    public int eval() {
        return constant;
    }

    @Override
    public String prefixPrint() {
        return Integer.toString(constant);
    }

    @Override
    public String prettyPrint() {
        return Integer.toString(constant);
    }
}