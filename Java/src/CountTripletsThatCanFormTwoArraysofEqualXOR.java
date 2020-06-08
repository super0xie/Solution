
public class CountTripletsThatCanFormTwoArraysofEqualXOR {
	
	public int countTriplets(int[] arr) {
		int res = 0;
        for(int i = 0; i < arr.length-1; i++) {
        	int cur = arr[i];
        	for(int j = i+1; j < arr.length; j++) {
        		cur = cur ^ arr[j];
        		if(cur == 0) {
        			res += j-i;
        		}
        	}
        }
        return res;
    }
}
