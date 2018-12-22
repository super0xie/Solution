
public class ThreeEqualParts {
	
	public int[] threeEqualParts(int[] A) {
        StringBuilder sb = new StringBuilder();
        boolean allZero = true;
        String l = null;
        String r = null;
        for(int i = 0; i < A.length; i++) {
        	if(A[i] == 0 && allZero) l = "0";
        	else {
        		allZero = false;
        		sb.append(A[i]);
        		l = sb.toString();
        	}
        	r = "0";
        	for(int j = A.length-1; j > i+1; j--) {
        		if(A[j] != 0) {
        			int k = j+1;
        			StringBuilder prefix = new StringBuilder("1");
            		while(k < A.length && A[k]==0) {
            			prefix.append('0');
            			k++;
            		}
            		if(k == A.length) {
            			r = prefix.toString();
            		}else {
            			r = prefix.toString() + r;
            		}
        		}
        		if(l.equals(r)) {
        			String str = helper(A, i+1, j-1);
        			if(l.equals(str)) {
        				return new int [] {i, j};
        			}
        		}
        	}
        }
        
        
        return new int[] {-1, -1};
    }
	
	private String helper(int[] A, int i, int j) {
		StringBuilder sb = new StringBuilder();
        boolean allZero = true;;
        for(int idx = i; idx <= j; idx++) {
        	if(A[idx] == 0 && allZero) {
        		continue;
        	}else {
        		allZero = false;
        		sb.append(A[idx]);
        	}
        }
        if(sb.length() == 0) return "0";
        else return sb.toString();
	}
	
	public static void main(String[] arg) {
		ThreeEqualParts test = new ThreeEqualParts();
		int[] A = {1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,0,1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,0,0,0,1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,0};
		int[] res = test.threeEqualParts(A);
		System.out.println(res);
		System.out.println("hello");
	}

}
