package operatii;

import java.util.ArrayList;

public class Divide extends ComplexExpression{
    public Divide(ArrayList<ComplexNumber> args){
        this.operation = Operation.DIVISION;
        this.args = args;
    }
    @Override
    public ComplexNumber executeOneOperation(ComplexNumber arg,ComplexNumber finalResult) {
        if(arg== args.get(0)){
            finalResult.setIm(arg.getIm());
            finalResult.setRe(arg.getRe());
        }
        else {
            finalResult.impartire(arg);
        }
        return finalResult;
    }
}

