
public class FindPermutation {
	
	public int[] findPermutation(String s) {
        int[] res = new int [s.length()+1];
        for(int i = 0; i < res.length; i++) {
        	res[i] = i+1;
        }
        
        for(int i = 0; i < res.length-1; i++) {
        	if(s.charAt(i) == 'D') {
        		int start = i;
        		int end = i;
        		while(end < s.length()-1 && s.charAt(end+1) == 'D') end++;
        		end++;
        		
        		for(int j = end; j >= i; j--) {
        			res[j] = ++start;
        		}
        		
        		i = end;
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		FindPermutation test = new FindPermutation();
		
		test.findPermutation("D");
	}

}
