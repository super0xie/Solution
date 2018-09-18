
public class MaxChunksToMakeSorted {
	public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int end = 0;
        
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] > end) end = arr[i];
        	if(i == end) {
        		res++;
        		end++;
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		MaxChunksToMakeSorted test = new MaxChunksToMakeSorted();
		int[] arr = {1,0,2,3,4};
		test.maxChunksToSorted(arr);
		
	}

}
