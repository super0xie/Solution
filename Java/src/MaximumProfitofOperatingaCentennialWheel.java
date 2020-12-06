
public class MaximumProfitofOperatingaCentennialWheel {
	
	
	public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int res = 0;
        int time = -1;
        int remain = 0;
        int p = 0;
        for(int i = 0; i < customers.length; i++) {
        	remain += customers[i];
        	int toServe = Math.min(remain, 4);
        	remain -= toServe;
        	p += boardingCost * toServe - runningCost;
        	if(p > res) {
        		res = p;
        		time = i+1;
        	}
        }
        
        int count = customers.length+1;
        while(remain > 0) {
        	int toServe = Math.min(remain, 4);
        	remain -= toServe;
        	p += boardingCost * toServe - runningCost;
        	if(p > res) {
        		res = Math.max(res, p);
        		time = count;
        	}
        	count++;
        }
        
        return time;
    }
	
	public static void main(String[] args) {
		MaximumProfitofOperatingaCentennialWheel test = new MaximumProfitofOperatingaCentennialWheel();
		int[] customers = {2};
		System.out.println(test.minOperationsMaxProfit(customers, 2, 4));
	}
	
	
}
