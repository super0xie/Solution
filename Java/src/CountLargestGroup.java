
public class CountLargestGroup {
	public int countLargestGroup(int n) {
        int[] count = new int[37];
        int max = 0;
        for(int i = 1; i <= n; i++) {
        	int sum = 0;
        	int j = i;
        	while(j > 0) {
        		sum += j % 10;
        		j = j / 10;
        	}
        	count[sum]++;
        	max = Math.max(max, count[sum]);
        }
        
        int res = 0;
        for(int i = 0; i < 37; i++) {
        	if(count[i] == max) res++;
        }
        
        return res;
        
    }
	
	
}
