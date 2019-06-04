
public class OutputContestMatches {
	
	public String findContestMatch(int n) {
        String [] strs = new String[n];
        for(int i = 0; i < n; i++) {
        	strs[i] = String.valueOf(i+1);
        }
        
        while(n>1) {
        	for(int i = 0; i < n/2; i++) {
        		String str1 = strs[i];
        		String str2 = strs[n-i-1];
        		strs[i] = "(" + str1 + "," + str2 + ")";
        	}
        	n = n/2;
        }
        
        return strs[0];
    }
	
	public static void main(String[] args) {
		OutputContestMatches test = new OutputContestMatches();
		System.out.println(test.findContestMatch(16));
		
	}
	

}
