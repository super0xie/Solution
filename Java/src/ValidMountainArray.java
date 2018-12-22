
public class ValidMountainArray {
	public boolean validMountainArray(int[] A) {
        if(A.length < 3) return false;
        boolean inc = true;
        if(A[1] < A[0]) return false;
        for(int i = 1; i < A.length; i++) {
        	if(A[i] == A[i-1]) return false;
        	else if(A[i] < A[i-1]) {
        		if(inc) inc = false;
        	}else {
        		if(!inc) return false;
        	}
        }
        if(inc) return false;
        return true;
    }
	
	public static void main(String[] args) {
		ValidMountainArray test = new ValidMountainArray();
		int[] A = {9,8,7,6,5,4,3,2,1,0};
		System.out.println(test.validMountainArray(A));
	}
}
