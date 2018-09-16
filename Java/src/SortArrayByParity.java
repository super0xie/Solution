
public class SortArrayByParity {
	public int[] sortArrayByParity(int[] A) {
        int [] res = new int[A.length];
        int start = 0;
        int end = A.length-1;
        for(int num : A) {
        	if(num % 2 == 0) res[start++] = num;
        	else res[end--] = num;
        }
        return res;
        
    }

}
