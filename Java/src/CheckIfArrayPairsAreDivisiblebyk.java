
public class CheckIfArrayPairsAreDivisiblebyk {
	
	public boolean canArrange(int[] arr, int k) {
        int[] count = new int[k];
        for(int i : arr) {
        	int idx = i % k;
        	if(idx < 0) idx+=k;
        	count[idx]++;
        }
        for(int i = 1; i <= count.length/2; i++) {
        	if(count.length % 2 == 0 && i == count.length/2) {
        		if(count[i] % 2 == 1) return false;
        	}else {
        		if(count[i] != count[k-i]) return false;
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		CheckIfArrayPairsAreDivisiblebyk test = new CheckIfArrayPairsAreDivisiblebyk();
		int[] arr = {-1,1,-2,2,-3,3,-4,4};
		System.out.println(test.canArrange(arr, 2));
//		System.out.println((-4)%3);
	}
}
