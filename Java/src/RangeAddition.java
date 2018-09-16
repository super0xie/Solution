
public class RangeAddition {
	
	public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update : updates) {
        	res[update[0]] += update[2];
        	if(update[1]+1 < length)
        		res[update[1]+1] -= update[2];
        }
        int sum = 0;
        for(int i = 0; i < res.length; i++) {
        	sum += res[i];
        	res[i] = sum;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		RangeAddition test = new RangeAddition();
		int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
		test.getModifiedArray(5, updates);
	}
	
}
