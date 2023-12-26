package operatii;

import java.util.ArrayList;

public class Subtraction extends ComplexExpression{
    public Subtraction(ArrayList<ComplexNumber> args){
        this.operation = Operation.SUBTRACTION;
        this.args = args;
    }
    @Override
    public ComplexNumber executeOneOperation(ComplexNumber arg,ComplexNumber finalResult) {
        //ComplexNumber result = new ComplexNumber(0,0);
        if(arg== args.get(0)){
            finalResult.adunare(arg);
        }
        else {
            finalResult.scadere(arg);
        }
        return finalResult;
    }


}
