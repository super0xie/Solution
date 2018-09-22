
public class AddStrings {
	public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while(i >= 0 || j >= 0) {
        	int sum = 0;
        	if(i >= 0 && j >= 0) {
        		sum = (int)(num1.charAt(i--) - '0') + (int)(num2.charAt(j--) - '0') + carry;
        	}else {
        		if(i >= 0) sum = (int)(num1.charAt(i--) - '0') + carry;
        		else sum = (int)(num2.charAt(j--) - '0') + carry;
        	}
        	
        	if(sum > 9) {
    			carry = 1;
    			sum = sum % 10;
    		}else {
    			carry = 0;
    		}
    		sb.append("" + sum);
        }
        
        if(carry > 0) sb.append("" + 1);
        return sb.reverse().toString();
        
    }
	
	public static void main(String[] args) {
		AddStrings test = new AddStrings();
		test.addStrings("408", "5");
	}
}
