
public class PerformStringShifts {
	
	public String stringShift(String s, int[][] shift) {
		int sum = 0;
        for(int[] sh : shift) {
        	if(sh[0] == 0) {
        		sum += sh[1];
        	}else {
        		sum -= sh[1];
        	}
        }
        
        if(sum > 0) {
        	sum = sum % s.length();
        	return s.substring(sum) + s.substring(0, sum);
        }else {
        	sum = -sum;
        	sum = sum % s.length();
        	return s.substring(s.length()-sum) + s.substring(0, s.length()-sum);
        }
    }
	
	public static void main(String[] args) {
		PerformStringShifts test = new PerformStringShifts();
		System.out.println(test.stringShift("abcdefg", new int[][] {{1,1},{1,1},{0,2},{1,3}}));
	}
	
}
