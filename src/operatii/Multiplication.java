package operatii;

import java.util.ArrayList;

public class Multiplication extends ComplexExpression {
    public Multiplication(ArrayList<ComplexNumber> args){
        this.operation = Operation.MULTIPLICATION;
        this.args = args;
    }
    @Override
    public ComplexNumber executeOneOperation(ComplexNumber arg,ComplexNumber finalResult) {
        //ComplexNumber result = new ComplexNumber(1,0);
        if(arg== args.get(0)){
            finalResult.setIm(arg.getIm());
            finalResult.setRe(arg.getRe());
        }
        else {
            finalResult.inmultire(arg);
        }
        return finalResult;
    }
}
