package Execution;

import operatii.ComplexExpression;
import operatii.NumarComplex;
import operatii.Operation;

import java.util.ArrayList;

public class ContainerFactory implements ExpressionFactory {
    @Override
    public ComplexExpression createExpression(Operation operation, ArrayList<NumarComplex>numbers){
        switch(operation){
            case ADDITION :
                return operation.execute();
        }
    }
}
