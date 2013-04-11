package expression;


import composite.ArithmeticExpression;
import composite.Expression;

public class DivisionExpression extends ArithmeticExpression {

    public DivisionExpression(Expression left, Expression right) {
        super(left, right);
    }

        @Override
	public int eval() {
                if (right.eval()==0) 
                    throw new UnsupportedOperationException ("Division by '0' is not allowed");
                else
                    return left.eval() / right.eval();
	}

        @Override
	public String prefixPrint() {
            return ":"+left.prefixPrint()+" "+right.prefixPrint();
        }

        @Override
	public String prettyPrint() {
		return left.prettyPrint()+" : "+right.prettyPrint();
	}
    
	
}