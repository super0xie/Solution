
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		long min = 1;
		long cur = 26;
		long pre = 1;
		long left = n;
		
		while(n >= min) {
			long remain = left % cur;
			long digit = remain / pre;
			if(digit > 0) {
        		sb.append((char)('A'+digit-1));
        		left -= digit * pre;
        	}else {
        		sb.append((char)('Z'));
        		left -= 26 * pre;
        	}
			pre = cur;
			cur = cur * 26;
			min = min * 26 + 1;
		}
		
		
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();
		System.out.println(test.convertToTitle(52));
	}

}
