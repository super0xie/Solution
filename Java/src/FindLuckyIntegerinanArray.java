
public class FindLuckyIntegerinanArray {
	
	public int findLucky(int[] arr) {
        int[] count = new int[501];
        for(int i : arr) count[i]++;
        
        for(int i = 500; i > 0; i--) {
        	if(i == count[i]) return i;
        }
        return -1;
    }
	
}
