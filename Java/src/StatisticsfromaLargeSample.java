
public class StatisticsfromaLargeSample {
	
	public double[] sampleStats(int[] count) {
        long total = 0;
        int n = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxCount = 0;
        int mode = 0;
        for(int i = 0; i < count.length; i++) {
        	if(count[i] == 0) continue;
        	min = Math.min(min, i);
        	max = Math.max(max, i);
        	if(count[i] > maxCount) {
        		maxCount = count[i];
        		mode = i;
        	}
        	n += count[i];
        	total += count[i] * i;
        }
        
        double[] res = new double[5];
        res[0] = (double)min;
        res[1] = (double)max;
        res[2] = (double)total / n;
        res[4] = mode;
        
        int idx = (n+1) / 2;
        int sum = 0;
        for(int i = 0; i < count.length; i++) {
        	if(count[i] == 0) continue;
        	if(idx > count[i]) {
        		idx -= count[i];
        	}else {
        		sum += i;
        		if(idx == 0) break;
        		if(n % 2 == 1) break;
        		if(count[i] == idx) idx = 0;
        		else {
        			sum += i;
        			break;
        		}
        	}
        }
        
        res[3] = (double)sum / (n % 2 == 1 ? 1 : 2);
        
        return res;
    }
	
	public static void main(String[] args) {
		StatisticsfromaLargeSample test = new StatisticsfromaLargeSample();
		int[] count = {264,912,1416,1903,2515,3080,3598,4099,4757,5270,5748,6451,7074,7367,7847,8653,9318,9601,10481,10787,11563,11869,12278,12939,13737,13909,14621,15264,15833,16562,17135,17491,17982,18731,19127,19579,20524,20941,21347,21800,22342,21567,21063,20683,20204,19818,19351,18971,18496,17974,17677,17034,16701,16223,15671,15167,14718,14552,14061,13448,13199,12539,12265,11912,10931,10947,10516,10177,9582,9102,8699,8091,7864,7330,6915,6492,6013,5513,5140,4701,4111,3725,3321,2947,2357,1988,1535,1124,664,206,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		test.sampleStats(count);
	}
	
}
