import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverseII {
	
	public int[] findDiagonalOrderTLE(List<List<Integer>> nums) {
		int m = nums.size();
		ArrayList<Integer> l = new ArrayList<>();
		int i = 0;
        int j = 0;
        int starti = 0;
        int startj = 0;
        boolean cont = true;
		while(cont) {
			cont = false;
			i = starti;
			j = startj;
			if(starti < m-1) starti++;
			else startj++;
			
            while(i >= 0) {
            	if(j < nums.get(i).size()) {
            		l.add(nums.get(i).get(j));
            		cont = true;
            	}
            	i--;
            	j++;
            }
        }
		
		return l.stream().mapToInt(n->n).toArray();
    }
	
	class N{
		int i;
		int s;
		int n;
		N(int i, int j, int n){
			this.i = i;
			this.s = i+j;
			this.n = n;
		}
	}
	
	public int[] findDiagonalOrder(List<List<Integer>> nums) {
		ArrayList<N> l = new ArrayList<>();
		for(int i = 0; i < nums.size(); i++) {
			for(int j = 0; j < nums.get(i).size(); j++) {
				l.add(new N(i, j, nums.get(i).get(j)));
			}
		}
		
		Collections.sort(l, (a, b)->{
			if(a.s != b.s) {
				return a.s-b.s;
			}else {
				return b.i-a.i;
			}
		});
		
		return l.stream().mapToInt(i->i.n).toArray();
    }
	
}
