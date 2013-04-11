package expression;


import composite.ArithmeticExpression;
import composite.Expression;

public class MultiplicationExpression extends ArithmeticExpression {
    
        public MultiplicationExpression(Expression left, Expression right) {
        super(left, right);
    }

        @Override
	public int eval() {
		return left.eval() * right.eval();
	}

        @Override
	public String prefixPrint() {
            return "*"+left.prefixPrint()+" "+right.prefixPrint();
        }

        @Override
	public String prettyPrint() {
		return left.prettyPrint()+" * "+right.prettyPrint();
	}
}