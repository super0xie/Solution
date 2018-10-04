
public class Base7 {
    
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean positive = true;
        if(num < 0) {
            positive = false;
            num = -num;
        }
        while(num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if(!positive) sb.append('-');
        
        return sb.reverse().toString();
        
    }

}
