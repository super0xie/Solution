
public class LastMomentBeforeAllAntsFallOutofaPlank {
	
	public int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        if(right.length != 0) {
        	int min = Integer.MAX_VALUE;
        	for(int i : right) min = Math.min(min, i);
        	res = Math.max(res, n-min);
        }
        
        if(left.length != 0) {
        	int max = Integer.MIN_VALUE;
        	for(int i : left) max = Math.max(max, i);
        	res = Math.max(res, max);
        }
        return res;
    }
	
}
