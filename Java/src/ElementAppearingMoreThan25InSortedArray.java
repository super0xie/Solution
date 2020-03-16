
public class ElementAppearingMoreThan25InSortedArray {
	
	public int findSpecialInteger(int[] arr) {
		if(arr.length == 1) return arr[0];
        float n = arr.length * 0.25f;
        int count = 1;
        
        for(int i = 1; i < arr.length; i++) {
        	if(arr[i] == arr[i-1]) {
        		count++;
        	}else {
        		count = 1;
        	}
        	if(count > n) return arr[i];
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		ElementAppearingMoreThan25InSortedArray test = new ElementAppearingMoreThan25InSortedArray();
		int[] arr = {1,2,2,6,6,6,6,7,10};
		System.out.println(test.findSpecialInteger(arr));
	}
	
}
