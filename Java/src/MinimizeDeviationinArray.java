import java.util.TreeSet;

public class MinimizeDeviationinArray {
	
	private class Interval implements Comparable<Interval>{
		int l;
		int r;
		Interval(int l, int r){
			this.l = l;
			this.r = r;
		}
		
		@Override
		public int compareTo(Interval other) {
			if(this.l != other.l)
				return this.l - other.l;
			else return this.r - other.r;
		}
	}
	
	public int minimumDeviation(int[] nums) {
		TreeSet<Interval> set = new TreeSet<>();
		
		for(int i = 0; i < nums.length; i++) {
			int n = nums[i];
			int upper = n;
			if(n % 2 == 1) upper = n * 2;
			while(n % 2 == 0) n = n / 2;
			Interval inter = new Interval(n, upper);
			set.add(inter);
		}
		
		
		int res = set.last().l - set.first().l;
		
		while(true) {
			Interval first = set.pollFirst();
			if(first.l < first.r) {
				first.l *= 2;
				set.add(first);
				res = Math.min(res, set.last().l - set.first().l);
			}
			else break;
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		MinimizeDeviationinArray test = new MinimizeDeviationinArray();
		System.out.println(test.minimumDeviation(new int[] {4,1,5,20,3}));
	}
	
}
