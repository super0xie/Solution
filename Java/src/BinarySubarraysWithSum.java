
public class BinarySubarraysWithSum {
	
	public int numSubarraysWithSumTLE(int[] A, int S) {
		int sum = 0;
		int[] prefix = new int[A.length];
		for(int i = 0; i < prefix.length; i++) {
			sum += A[i];
			prefix[i] = sum;
		}
		
		int res = 0;
		for(int i = 0; i < A.length; i++) {
			for(int j = i; j < A.length; j++) {
				if(helper(prefix, i, j) == S) res++;
			}
		}
		return res;
        
    }
	
	private int helper(int[] prefix, int i, int j) {
		if(i == 0) return prefix[j];
		else {
			return prefix[j] - prefix[i-1];
		}
	}
	
	public int numSubarraysWithSum(int[] A, int S) {
		int i = 0;
		int j = 0;
		int sum = A[0];
		int res = 0;
		while(j < A.length && i <= j) {
			if(sum < S) {
				j++;
				if(j < A.length) sum += A[j];
			}else if(sum > S) {
				if(i == j) {
					j++;
					if(j < A.length) sum += A[j];
				}else {
					sum -= A[i];
					i++;
				}
			}else {
				int l = i;
				int aux = sum;
				while(l <= j && aux == S) {
					res++;
					aux -= A[l];
					l++;
				}
				j++;
				if(j < A.length) sum += A[j];
			}	
		}
		return res;
	}
	
	public static void main(String[] args) {
		BinarySubarraysWithSum test = new BinarySubarraysWithSum();
		int[] A = {0,0,0,0,0,0,1,0,0,0};
		System.out.println(test.numSubarraysWithSum(A, 0));
	}

}
