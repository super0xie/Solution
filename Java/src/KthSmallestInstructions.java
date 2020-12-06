
public class KthSmallestInstructions {
	
	public String kthSmallestPath(int[] destination, int k) {
        int h = destination[1];
        int v = destination[0];
        char[] arr = new char[h+v];
        
        for(int i = 0; i < arr.length; i++) {
        	if(h == 0) {
        		arr[i] = 'V';
        		continue;
        	}else if(v == 0) {
        		arr[i] = 'H';
        		continue;
        	}
        	//if h
        	long count = C(h+v-1, v);
        	if(k <= count) {
        		arr[i] = 'H';
        		h--;
        	}else {
        		arr[i] = 'V';
        		v--;
        		k -= count;
        	}
        }
        
        return String.valueOf(arr);
        
    }
	

	//nCr(a, b) = a!/b!/(a-b)!
	private long C(int a, int b) {
		if(b < a-b) b = a-b;
		
		long upper = 1;
		for(int i = a; i > b; i--) upper *= i;
		
		long lower = 1;
		for(int i = 2; i <= a-b; i++) lower *= i;
		
		return upper / lower;
	}
	
	private long CSafe(int a, int b) {
		if(b < a-b) b = a-b;
		long upper = 1;
		boolean[] used = new boolean[a-b+1];
		for(int i = a; i > b; i--) {
			upper *= i;
			for(int j = 2; j <= a-b; j++) {
				if(!used[j] && upper % j == 0) {
					upper /= j;
					used[j] = true;
				}
			}
		}
		return upper;
	}
	
	public static void main(String[] args) {
		KthSmallestInstructions test = new KthSmallestInstructions();
//		System.out.println(test.CSafe(5, 2));
		System.out.println(test.kthSmallestPath(new int[] {2,3}, 3));
	}
}
