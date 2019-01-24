
public class IntegertoRoman {
    
    
    public String intToRoman(int n) {
        StringBuilder sb = new StringBuilder();
        while(n >= 1000) {
            sb.append("M");
            n -= 1000;
        }
        
        if(n >= 900) {
            sb.append("CM");
            n -= 900;
        }
        
        if(n >= 400 && n < 500) {
            sb.append("CD");
            n -= 400;
        }
        
        if(n >= 500) {
            sb.append("D");
            n -= 500;
        }
        
        while(n >= 100) {
            sb.append("C");
            n -= 100;
        }
        
        if(n >= 90) {
            sb.append("XC");
            n -= 90;
        }
        
        if(n >= 40 && n < 50) {
            sb.append("XL");
            n -= 40;
        }
        
        if(n >= 50) {
            sb.append("L");
            n -= 50;
        }
        
        while(n >= 10) {
            sb.append("X");
            n -= 10;
        }
        
        if(n >= 9) {
            sb.append("IX");
            n -= 9;
        }
        
        if(n >= 4 && n < 5) {
            sb.append("IV");
            n -= 4;
        }
        
        if(n >= 5) {
            sb.append("V");
            n -= 5;
        }
        
        while(n >= 1) {
            sb.append("I");
            n -= 1;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        IntegertoRoman test = new IntegertoRoman();
        System.out.println(test.intToRoman(1994));
    }
    
}
