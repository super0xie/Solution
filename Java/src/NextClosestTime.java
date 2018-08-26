
public class NextClosestTime {
	
    public String nextClosestTime(String time) {
        int [] digits = new int [4];
        int minDigit = 10;
        for(int i = 0; i < time.length(); i++) {
        	if(i == 2) continue;
        	
        	if(i > 1) {
        		digits[i-1] = time.charAt(i) - '0';
        		if(digits[i-1] < minDigit) minDigit = digits[i-1];
        	}else {
        		digits[i] = time.charAt(i) - '0';
        		if(digits[i] < minDigit) minDigit = digits[i];
        	}
        }
        
        
        //3rd digit
        if(digits[3] != 9) {
        	int min = 10;
        	for(int i = 0; i < 4; i++) {
        		if(digits[i] > digits[3] && digits[i] < min) {
        			min = digits[i];
        		}
        	}
        	if(min != 10) {
        		digits[3] = min;
        		return buildResult(digits);
        	}
        }
        
        //2nd
        if(digits[2] != 5) {
        	int min = 6;
        	for(int i = 0; i < 4; i++) {
        		if(digits[i] > digits[2] && digits[i] < min) {
        			min = digits[i];
        		}
        	}
        	if(min != 6) {
        		digits[2] = min;
        		digits[3] = minDigit;
        		return buildResult(digits);
        	}
        }
        
        //1st
        if((digits[0] != 2 && digits[1] != 9) || (digits[0] == 2 && digits[1] != 3)) {
        	int min = 0;
        	if(digits[0]!=2) {
        		min = 10;
        	}else {
        		min = 4;
        	}
        	
        	for(int i = 0; i < 4; i++) {
        		if(digits[i] > digits[1] && digits[i] < min) {
        			min = digits[i];
        		}
        	}
        	
        	if( (digits[0] != 2 && min != 10) || (digits[0] == 2 && min != 4)) {
        		digits[1] = min;
        		digits[2] = minDigit;
        		digits[3] = minDigit;
        		return buildResult(digits);
        	}
        }
        
        
        digits[0] = minDigit;
        digits[1] = minDigit;
        digits[2] = minDigit;
        digits[3] = minDigit;
        
        return buildResult(digits);
    }
    
    private String buildResult(int [] digits) {
    	return "" + digits[0] + digits[1] + ":" + digits[2] + digits[3];
    }
    
    public static void main(String[] args) {
    	NextClosestTime test = new NextClosestTime();
    	System.out.println(test.nextClosestTime("13:55"));
    	
    	
    }
    
}
