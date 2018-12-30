
public class NRepeatedElementinSize2NArray {
	public int repeatedNTimes(int[] A) {
        boolean[] mem = new boolean [10000];
        for(int i : A) {
        	if(mem[i]) return i;
        	else mem[i] = true;
        }
        return 0;
    }
}
