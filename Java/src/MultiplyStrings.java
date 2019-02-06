import java.util.ArrayList;

public class MultiplyStrings {
    
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        
        ArrayList<String> add = new ArrayList<>();
        int maxLen = 0;
        for(int i = num2.length()-1; i>=0; i--) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < num2.length()-1-i; j++) {
                sb.append('0');
            }
            int carry = 0;
            for(int j = num1.length()-1; j >= 0; j--) {
                int mul = (num2.charAt(i)-'0') * (num1.charAt(j)-'0');
                mul += carry;
                sb.append((char)(mul%10+'0'));
                carry = mul / 10;
            }
            if(carry > 0) sb.append((char)(carry+'0'));
            add.add(sb.toString());
            maxLen = Math.max(maxLen, sb.length());
        }
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < maxLen; i++) {
            int sum = carry;
            for(String str : add) {
                if(i < str.length()) {
                    sum += (int)(str.charAt(i)-'0');
                }
            }
            carry = sum / 10;
            sb.append((char)(sum % 10 + '0'));
        }
        if(carry > 0) sb.append((char)(carry+'0'));
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        MultiplyStrings test = new MultiplyStrings();
        System.out.println(test.multiply("123", "456"));
    }
    
}
