
import composite.Constant;
import composite.Expression;
import expression.AdditionExpression;
import expression.SubstractionExpression;
import expression.MultiplicationExpression;
import expression.DivisionExpression;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leo
 */
public class Calculator {
    
    public static void main(String[] args) {
        Expression a = new MultiplicationExpression(new DivisionExpression(new Constant(2), new Constant(0)), new Constant(4));
        System.out.println(a.depth());
        System.out.println(a.eval());
        System.out.println(a.prefixPrint());
        System.out.println(a.prettyPrint());
    }
}
