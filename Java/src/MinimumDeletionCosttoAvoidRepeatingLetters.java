
public class MinimumDeletionCosttoAvoidRepeatingLetters {
	
	public int minCost(String s, int[] cost) {
		int res = 0;
		
		for(int i = 0; i < s.length(); i++) {
			int j = i+1;
			int max = cost[i];
			int sum = cost[i];
			while(j < s.length() && s.charAt(j) == s.charAt(i)) {
				max = Math.max(max, cost[j]);
				sum += cost[j];
				j++;
			}
			if(j != i+1) res += sum - max;
			i = j-1;
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		String s = "aabaa";
		int[] cost = {1,2,3,4,1};
		MinimumDeletionCosttoAvoidRepeatingLetters test = new MinimumDeletionCosttoAvoidRepeatingLetters();
		test.minCost(s, cost);
	}
}
