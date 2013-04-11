package composite;

public interface Expression {

	public int depth();

	public int eval();

	public String prefixPrint();

	public String prettyPrint();
}