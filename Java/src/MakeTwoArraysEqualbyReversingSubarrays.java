
public class MakeTwoArraysEqualbyReversingSubarrays {
	
	public boolean canBeEqual(int[] target, int[] arr) {
        int[] count1 = new int[1001];
        int[] count2 = new int[1001];
        
        for(int i : target) {
        	count1[i]++;
        }
        for(int i : arr) {
        	count2[i]++;
        }
        
        for(int i = 0; i < count1.length; i++) {
        	if(count1[i] != count2[i]) return false;
        }
        return true;
    }
	
}
