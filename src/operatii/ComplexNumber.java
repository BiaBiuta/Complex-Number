package operatii;

public class ComplexNumber {
    private double re;
    private double im;

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }
    public ComplexNumber adunare(ComplexNumber a){
        this.re+=a.re;
        this.im+=a.im;
        return this;
    }
    public ComplexNumber scadere(ComplexNumber a){
        this.re-=a.re;
        this.im-=a.im;
        return this;
    }
    public ComplexNumber inmultire(ComplexNumber a){
        double x=this.re;
        this.re=this.re*a.re-this.im*a.im;
        this.im=this.im*a.re+x*a.im;
        return this;
    }
    public ComplexNumber impartire(ComplexNumber a){
        double x=a.im;
        a.setIm((-1)*x);
        this.inmultire(a);
        this.re=this.re/(a.re*a.re+a.im*a.im);
        this.im=this.im/(a.re*a.re+a.im*a.im);
        return this;
    }

    @Override
    public String toString() {
        if(im<0){
            return re+""+im+"*i";
        }
        return re+"+"+im+"*i";
    }

    public ComplexNumber conjugatul(){
        return null;
    }



}
