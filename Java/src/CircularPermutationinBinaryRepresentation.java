import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularPermutationinBinaryRepresentation {
	
	public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ret = helper(n);
        List<Integer> res = new ArrayList<>();
        
        int idx = 0;
        for(int i = 0; i < ret.size(); i++) {
        	if(ret.get(i) == start) {
        		idx = i;
        		break;
        	}
        }
        
        for(int i = idx; i < ret.size(); i++) res.add(ret.get(i));
        for(int i = 0; i < idx; i++) res.add(ret.get(i));
        return res;
	}
	
	
	private ArrayList<Integer> helper(int n) {
		if(n == 1) return new ArrayList<Integer>(Arrays.asList(0, 1));
		else {
			ArrayList<Integer> res = helper(n-1);
			int add = 1 << (n-1);
			for(int i = res.size()-1; i >= 0; i--) {
				res.add(add + res.get(i));
			}
			return res;
		}
	}
	
	public static void main(String[] args) {
		CircularPermutationinBinaryRepresentation test = new CircularPermutationinBinaryRepresentation();
		List<Integer> res = test.circularPermutation(3, 2);
		for(int i : res) System.out.print(i + ", ");
	}
	
}
