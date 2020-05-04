import java.util.Arrays;

public class ReducingDishes {
	
	public int maxSatisfaction(int[] s) {
        int res = 0;
        Arrays.parallelSort(s);
        int cur = 0;
        int sum = 0;
        for(int i = s.length-1; i >= 0; i--) {
        	cur += sum + s[i];
        	res = Math.max(res, cur);
        	sum += s[i];
        }
        return res;
    }
	
	public static void main(String[] args) {
		ReducingDishes test = new ReducingDishes();
		System.out.println(test.maxSatisfaction(new int[] {-1,-4,-5}));
	}
	
}
