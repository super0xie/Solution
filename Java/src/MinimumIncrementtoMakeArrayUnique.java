import java.util.HashSet;

public class MinimumIncrementtoMakeArrayUnique {
	
	public int minIncrementForUniqueTLE(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        
        for(int i : A) {
        	if(!set.contains(i)) {
        		set.add(i);
        	}else {
        		while(set.contains(i)) {
        			res++;
        			i++;
        		}
        		set.add(i);
        	}
        }
        
        return res;
    }
	
	public int minIncrementForUnique(int[] A) {
        boolean[] set = new boolean[40000];
        int res = 0;
        
        for(int i : A) {
        	if(!set[i]) {
        		set[i] = true;
        	}else {
        		while(set[i]) {
        			res++;
        			i++;
        		}
        		set[i] = true;
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		MinimumIncrementtoMakeArrayUnique test = new MinimumIncrementtoMakeArrayUnique();
		int[] A = {3,2,1,2,1,7};
		System.out.println(test.minIncrementForUnique(A));
	}
	
}
