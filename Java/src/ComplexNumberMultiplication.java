
public class ComplexNumberMultiplication {
    class ComplexNumber{
        int a;
        int b;
        
        ComplexNumber(String str){
            int plusIdx = str.indexOf('+');
            a = Integer.parseInt(str.substring(0, plusIdx));
            b = Integer.parseInt(str.substring(plusIdx+1, str.length()-1));
        }
        
        public ComplexNumber() {
            
        }

        public String toString() {
            return "" + a + "+" + b + "i";
        }
        
        ComplexNumber mul(ComplexNumber t) {
            ComplexNumber res = new ComplexNumber();
            res.a = this.a * t.a - this.b * t.b;
            res.b = this.a * t.b + this.b * t.a;
            return res;
        }
        
    }
    
    public String complexNumberMultiply(String a, String b) {
        ComplexNumber ca = new ComplexNumber(a);
        ComplexNumber cb = new ComplexNumber(b);
        return ca.mul(cb).toString();
    }

}
