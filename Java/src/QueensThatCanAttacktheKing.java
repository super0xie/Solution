import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class QueensThatCanAttacktheKing {
	
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int[] q : queens) {
        	int encode = q[0] * 8 + q[1];
        	set.add(encode);
        }
        
        int r = king[0];
        int c = king[1];
        
        while(r < 8) {
        	int encode = r * 8 + c;
        	if(set.contains(encode)) {
        		res.add(Arrays.asList(r, c));
        		break;
        	}
        	r++;
        }
        
        r = king[0];
        c = king[1];
        while(r >= 0) {
        	int encode = r * 8 + c;
        	if(set.contains(encode)) {
        		res.add(Arrays.asList(r, c));
        		break;
        	}
        	r--;
        }
        
        r = king[0];
        c = king[1];
        while(c < 8) {
        	int encode = r * 8 + c;
        	if(set.contains(encode)) {
        		res.add(Arrays.asList(r, c));
        		break;
        	}
        	c++;
        }
        
        r = king[0];
        c = king[1];
        while(c >= 0) {
        	int encode = r * 8 + c;
        	if(set.contains(encode)) {
        		res.add(Arrays.asList(r, c));
        		break;
        	}
        	c--;
        }
        
        r = king[0];
        c = king[1];
        while(r < 8 && c < 8) {
        	int encode = r * 8 + c;
        	if(set.contains(encode)) {
        		res.add(Arrays.asList(r, c));
        		break;
        	}
        	r++;
        	c++;
        }
        
        r = king[0];
        c = king[1];
        while(r < 8 && c >= 0) {
        	int encode = r * 8 + c;
        	if(set.contains(encode)) {
        		res.add(Arrays.asList(r, c));
        		break;
        	}
        	r++;
        	c--;
        }
        
        r = king[0];
        c = king[1];
        while(r >= 0 && c < 8) {
        	int encode = r * 8 + c;
        	if(set.contains(encode)) {
        		res.add(Arrays.asList(r, c));
        		break;
        	}
        	r--;
        	c++;
        }
        
        r = king[0];
        c = king[1];
        while(r >= 0 && c >= 0) {
        	int encode = r * 8 + c;
        	if(set.contains(encode)) {
        		res.add(Arrays.asList(r, c));
        		break;
        	}
        	r--;
        	c--;
        }
        
        return res;
    }
	
}
