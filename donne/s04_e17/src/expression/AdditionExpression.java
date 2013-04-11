package expression;

import composite.ArithmeticExpression;
import composite.Expression;

public class AdditionExpression extends ArithmeticExpression {

    private final String sign = "+";
    
    public AdditionExpression(Expression left, Expression right) {
        super(left, right);
    }

        @Override
	public int eval() {
		return left.eval() + right.eval();
	}

        @Override
	public String prefixPrint() {
            return "+"+left.prefixPrint()+" "+right.prefixPrint();
        }

        @Override
	public String prettyPrint() {
		return left.prettyPrint()+" + "+right.prettyPrint();
	}
}