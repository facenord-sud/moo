package expression;


import composite.ArithmeticExpression;

public class MultiplicationExpression extends ArithmeticExpression {

        @Override
	public int depth() {
		throw new UnsupportedOperationException();
	}

        @Override
	public int eval() {
		throw new UnsupportedOperationException();
	}

        @Override
	public String prefixPrint() {
		throw new UnsupportedOperationException();
	}

        @Override
	public String prettyPrint() {
		throw new UnsupportedOperationException();
	}
}