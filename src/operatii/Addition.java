package operatii;

import java.util.ArrayList;

public class Addition extends ComplexExpression{
    public Addition(ArrayList<ComplexNumber> args){
        this.operation = Operation.ADDITION;
        this.args = args;
    }
    @Override
    public ComplexNumber executeOneOperation(ComplexNumber arg,ComplexNumber finalResult) {
        ComplexNumber result = finalResult.adunare(arg);
        return result;
    }

}
