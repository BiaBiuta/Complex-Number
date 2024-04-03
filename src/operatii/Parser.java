package operatii;

import Execution.ExpressionFactory;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {
    public String expression;
    public String operationParser;

    public Parser(String expression) {
        this.expression = expression;
    }
    public boolean validateop(String x,String b){
        if(!x.equals(b)){
            return false;
        }
        return true;
    }
    public boolean validate(String[]args){
        for(int i=0; i< args.length;i++){
            if(i%2==0){
                if(!validateTerms(args[i]))return false;
            }
            else {
                if (args[i].length() != 1) {
                    return false;
                } else if (!(args[i].equals("+")) && !(args[i].equals("-")) && !(args[i].equals("*")) && !validateop(args[i],args[1])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validateTermA(String arg){
        if(arg.matches("[-]?[0-9]+"))return true;
        return false;
    }
    public boolean validateTermB(String arg){
        if(arg.matches("[0-9]+i"))return true;
        return false;
    }
    public boolean validateTerm(String arg){
        if(arg.matches("[0-9]+[+-][0-9]*[*]?[i]?"))return true;
        return false;
    }
    /*
    *
    * */
    public boolean validateTerms(String arg){
        String[] splitArg=arg.split("[+-]");
        if(splitArg.length>2) return false;
        else if(splitArg.length==1){
            if(splitArg[0].contains("i")){
                if(!validateTermB(splitArg[0]))return false;
            }
            else{
                if(!validateTermA(splitArg[0]))return false;
            }
        }
        else if(splitArg.length==2){
            if(!validateTerm(arg)) return false;
        }
        return true;
     }

    /*
    * creaza un array de numere complexe din stringul dat
    * returneaza array daca expresia e valida
    * sau exceptie de invalid input daca nu
    * */
    public ArrayList<ComplexNumber> parser(String expression) {
        Operation operation = null;
        ArrayList<ComplexNumber> parsedExpression = new ArrayList<>();
        String[] args = expression.split(" ");
        if(validate(args)) {
            this.operationParser = args[1];
            for (int i = 0; i < args.length; i = i + 2) {
                String[] parti = args[i].split("[+-]");
                String[] separator = args[i].split("[^ +-]");
                String[] argI = new String[0];
                if (!Objects.equals(parti[1], "i")) {
                    argI = parti[1].split("\\*");
                } else {
                    String i1 = "1";
                    argI = new String[]{i1};
                }
                if (separator[1].equals("-")) {
                    ComplexNumber numar = new ComplexNumber(Double.parseDouble(parti[0]), (-1) * Double.parseDouble(argI[0]));
                    parsedExpression.add(numar);
                } else {
                    ComplexNumber numar = new ComplexNumber(Double.parseDouble(parti[0]), Double.parseDouble(argI[0]));
                    parsedExpression.add(numar);
                }
            }
            return parsedExpression;
        }
        else {
            throw new IllegalArgumentException("Invalid input: :" + expression);
        }
    }
    public void setCreateExpression(String expression){
        ArrayList<ComplexNumber> parsedExpression = parser(expression);
        Operation operation = null;
        switch (operationParser) {
            case "+" -> operation = Operation.ADDITION;
            case "-" -> operation = Operation.SUBTRACTION;
            case "*" -> operation = Operation.MULTIPLICATION;
            case "/" -> operation = Operation.DIVISION;
        }
        ExpressionFactory createExpression = ExpressionFactory.getInstance();
        createExpression.createExpression(operation,parsedExpression);
    }


}
