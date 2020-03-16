import java.util.ArrayList;
import java.util.Collections;

public class ReduceArraySizetoTheHalf {
	
	public int minSetSize(int[] arr) {
        int[] count = new int[100001];
        ArrayList<Integer> l = new ArrayList<>();
        for(int i : arr) {
        	if(count[i] == 0) l.add(i);
        	count[i]++;
        }
        
        Collections.sort(l, (a, b)->{
        	return count[b]-count[a];
        });
        int res = 0;
        int c = 0;
        for(int i = 0; i < l.size(); i++) {
        	res++;
        	c += count[l.get(i)];
        	if(c >= arr.length / 2) break;
        }
        
        return res;
    }
	
}
