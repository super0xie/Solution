
public class ExcelSheetColumnNumber {
	
	public int titleToNumber(String s) {
        int res = 0;
        int current = 1;
        for(int i = s.length()-1; i >= 0; i--) {
        	res += current * (s.charAt(i) - 'A');
        	current *= 26;
        }
        return res+1;
    }
	
}
