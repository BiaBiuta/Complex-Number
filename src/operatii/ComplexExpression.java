package operatii;

import java.util.ArrayList;

public abstract class ComplexExpression {
        //protected ComplexNumber finalResult;
        protected Operation operation;
        protected ArrayList<ComplexNumber> args;

        public ComplexExpression(Operation operation, ArrayList<ComplexNumber> args) {
                this.operation = operation;
                this.args = args;
        }

        public ComplexExpression() {
        }

        public abstract ComplexNumber executeOneOperation(ComplexNumber arg,ComplexNumber finalResult);
        public void executeAll(){
                ComplexNumber finalResult = new ComplexNumber(0,0);
                for(ComplexNumber arg : args){
                        finalResult=executeOneOperation(arg,finalResult);

                }
                System.out.println(finalResult.toString());
        }
}
