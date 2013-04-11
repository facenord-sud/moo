package composite;

public abstract class ArithmeticExpression implements Expression {

    private Expression left;
    private Expression right;

    public ArithmeticExpression() {
    }

    public ArithmeticExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }
}