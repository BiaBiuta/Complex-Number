import operatii.Parser;

public class Main {
    public static void main(String[] args) {
        String expression="";
        for(int i=0;i<args.length;i++){
            expression=expression+args[i];
        }
        Parser parser = new Parser(expression);
        parser.setCreateExpression(parser.expression);
    }
}