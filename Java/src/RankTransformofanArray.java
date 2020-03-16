import java.util.Arrays;
import java.util.HashMap;

public class RankTransformofanArray {
	
	public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int[] cp = new int[arr.length];
        for(int i = 0; i < arr.length; i++) cp[i] = arr[i];
        Arrays.sort(cp);
        int r = 1;
        for(int i = 0; i < cp.length; i++) {
        	if(!map.containsKey(cp[i])) {
        		map.put(cp[i], r);
        		r++;
        	}
        }
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
        	res[i] = map.get(arr[i]);
        }
        return res;
    }
	
	public static void main(String[] args) {
		RankTransformofanArray test = new RankTransformofanArray();
		int[] res = test.arrayRankTransform(new int[] {37,12,28,9,100,56,80,5,12});
		for(int i : res) System.out.print(i + ", ");
	}
	
}
