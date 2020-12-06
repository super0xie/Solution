import java.util.Arrays;

public class MinimumNumberofDaystoMakemBouquets {
	
	public int minDays(int[] bloomDay, int m, int k) {
		if(bloomDay.length < m * k) return -1;
		
        int[] cp = Arrays.copyOf(bloomDay, bloomDay.length);
        Arrays.parallelSort(cp);
        
        int l = 0;
        int r = cp.length-1;
        
        while(l < r) {
        	int mid = l + (r-l)/2;
        	int res = cp[mid];
        	int count = 0;
        	int n = 0;
        	for(int i = 0; i < bloomDay.length; i++) {
        		if(bloomDay[i] > res) {
        			n += count / k;
        			count = 0;
        		}else {
        			count++;
        		}
        	}
        	n += count / k;
        	
        	if(n >= m) r = mid;
        	else l = mid+1;
        }
        
        return cp[l];
    }
	
	public static void main(String[] args) {
		MinimumNumberofDaystoMakemBouquets test = new MinimumNumberofDaystoMakemBouquets();
		int[] bloomDay = {1,10,3,10,2};
		test.minDays(bloomDay, 3, 1);
	}
	
}
