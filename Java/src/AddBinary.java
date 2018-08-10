
public class AddBinary {
	
	public String addBinary(String a, String b) {
        int i = 1;
        int m, n, sum;
        int flag = 0;
        StringBuffer result = new StringBuffer();
        while(a.length()-i >= 0 || b.length()-i >= 0) {
        	if(a.length() - i < 0) m = 0;
        	else m = a.charAt(a.length()-i) - '0';
        	
        	if(b.length() - i < 0) n = 0;
        	else n = b.charAt(b.length()-i) - '0';
        	
        	sum = m + n + flag;
        	flag = 0;
        	
        	switch(sum) {
        	case 0:
        		result.append('0');break;
        	case 1:
        		result.append('1');break;
        	case 2:
        		result.append('0');
        		flag = 1;
        		break;
        	case 3:
        		result.append('1');
        		flag = 1;
        		break;
        	}
        		
        	i++;
        }
        
        if(flag == 1)
        	result.append('1');
        
        return result.reverse().toString();
    }
	
	public static void main(String[] args) {
		AddBinary test = new AddBinary();
		System.out.println(test.addBinary("1110", "11"));
		
	}

}
