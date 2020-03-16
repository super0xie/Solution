
public class DietPlanPerformance {
	
	public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
		int sum = 0;
		int res = 0;
		for(int i = 0; i < calories.length; i++) {
			sum += calories[i];
			if(i >= k-1) {
				if(i >= k) sum -= calories[i-k];
				if(sum > upper) res++;
				else if(sum < lower) res--;
			}
		}
		return res;
    }
	
}
