package composite;

public abstract class ArithmeticExpression implements Expression {

    protected Expression left;
    protected Expression right;

    public ArithmeticExpression() {
    }

    public ArithmeticExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int depth() {
        return 1 + left.depth();
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }
}