package Execution;

import operatii.*;

import java.util.ArrayList;

public class ExpressionFactory{
    private static ExpressionFactory instance = new ExpressionFactory();

    private ExpressionFactory() {

    }

    public static ExpressionFactory getInstance() {
        return instance;
    }

    public void createExpression(Operation operation, ArrayList<ComplexNumber> args) {
        switch (operation) {
            case ADDITION:
                Addition expression=new Addition(args);
                expression.executeAll();
                break;
            case SUBTRACTION:
                Subtraction expression2=new Subtraction(args);
                expression2.executeAll();
                //expression = new SubtractionExpression(args);
                break;
            case MULTIPLICATION:
                Multiplication expression3=new Multiplication(args);
                expression3.executeAll();
                //expression = new MultiplicationExpression(args);
                break;
            case DIVISION:
                Divide expression4=new Divide(args);
                expression4.executeAll();
                //expression = new DivisionExpression(args);
                break;
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }

    }
}
