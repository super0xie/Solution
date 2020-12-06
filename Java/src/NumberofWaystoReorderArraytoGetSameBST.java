import java.util.ArrayList;

public class NumberofWaystoReorderArraytoGetSameBST {
	
	private int mod = 1000000000+7;
	
	
	public int numOfWays(int[] nums) {
        ArrayList<Integer> aux = new ArrayList<Integer>();
        for(int i : nums) aux.add(i);
        
        return (int)helper(aux)-1;
    }
	
	private long helper(ArrayList<Integer> nums) {
		if(nums.size() <= 1) return 1;
		ArrayList<Integer> l = new ArrayList<>();
		ArrayList<Integer> r = new ArrayList<>();
		int a = nums.get(0);
		
		for(int i = 1; i < nums.size(); i++) {
			if(nums.get(i) < a) l.add(nums.get(i));
			else r.add(nums.get(i));
		}
		
		long lr = helper(l);
		long rr = helper(r);
		long res = cal(l.size()+r.size(), l.size(), r.size());
		res = res * lr;
		res = res % mod;
		res = res * rr;
		res = res % mod;
		
		return res;
	}
	
	private long cal(int a, int b, int c) {
		long res = 1;
		int max = Math.max(b, c);
		int min = Math.min(b, c);
		
		for(long i = max+1; i <= a; i++) {
			res = res * i;
			res = res % mod;
		}
		
		for(int j = 2; j <= min; j++) {
			while (res % j != 0) {
                res += mod;
            }
			res = res / j;
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		NumberofWaystoReorderArraytoGetSameBST test = new NumberofWaystoReorderArraytoGetSameBST();
		int[] nums = {19,3,57,34,15,89,58,35,2,33,46,13,40,79,60,30,61,26,54,22,84,51,75,6,87,44,55,48,27,8,72,47,16,69,36,76,41,1,80,62,73,24,93,50,92,65,39,5,32,67,12,29,90,45,9,38,88,52,10,85,74,66,83,18,20,77,49,28,23,53,86,64,78,82,37,42,56,17,81,4,14,70,59,31,7,25,43,68,91,71,21,63,94,11};
		System.out.print(test.numOfWays(nums));
	}
}
