
public class GasStation {
	
	public int canCompleteCircuitv1(int[] gas, int[] cost) {
		int start = gas.length-1;
		int end = 0;
		int sum = gas[start]-cost[start];
		
		while(start > end) {
			if(sum >= 0) {
				sum = sum + gas[end]-cost[end];
				end++;
			}else {
				start--;
				sum = sum + gas[start] - cost[start];
			}
		}
		if(sum >= 0) return start;
		else return -1;
		
    }
	
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		
		for(int i = 0; i < gas.length ; i++) {
			int sum = 0;
			for(int j = i+1; ; j++) {
				sum = sum + gas[(j-1)%gas.length] - cost[(j-1)%gas.length];
				if(sum < 0) break;
				else {
					if(j % gas.length == i) return i;
				}
			}
			

		}
		
		return -1;
    }
	
	public static void main(String[] args) {
		GasStation test = new GasStation();
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		System.out.println(test.canCompleteCircuit(gas, cost));
		
	}
	
	
	
}
