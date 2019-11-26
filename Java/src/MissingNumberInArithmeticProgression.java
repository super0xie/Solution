
public class MissingNumberInArithmeticProgression {
	
	public int missingNumber(int[] arr) {
        int d = Integer.MIN_VALUE;
        int pre = 0;
        for(int i = 1; i < arr.length; i++) {
        	int diff = arr[i] - arr[i-1];
        	if(d == Integer.MIN_VALUE) {
        		d = diff;
        		pre = arr[i-1];
        	}else if(diff != d){
        		if(d == diff * 2) {
        			return pre + diff;
        		}else {
        			return arr[i-1] + d;
        		}
        	}
        	
        }
        
        return arr[0];
    }
	
	public static void main(String[] args) {
		MissingNumberInArithmeticProgression test = new MissingNumberInArithmeticProgression();
		int[] arr = {1,2,3,5};
		System.out.println(test.missingNumber(arr));
	}
	
}
