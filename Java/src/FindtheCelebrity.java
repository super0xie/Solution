import java.util.ArrayList;
import java.util.List;

public class FindtheCelebrity {
	boolean knows(int a, int b) {
		boolean[][] aux = {{true, false, true}, {false, true, true}, {false, false, true}};
		return aux[a][b];
		
	}
	
	public int findCelebrity(int n) {
        List<Integer> can = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
        	can.add(i);
        }
        
        while(can.size() > 1) {
        	List<Integer> aux = new ArrayList<Integer>();
        	for(int i = 0; i < can.size(); i = i + 2) {
        		if(i != can.size()-1) {
        			if(knows(can.get(i), can.get(i+1))) {
        				aux.add(can.get(i+1));
        			}else {
        				aux.add(can.get(i));
        			}
        		}else {
        			aux.add(can.get(i));
        		}
        	}
        	can = aux;
        }
        
        if(can.size() == 1) {
        	int cand = can.get(0);
        	
        	for(int i = 0; i < n; i++) {
        		if(cand == i) continue;
        		if(knows(cand, i)) return -1;
        		if(!knows(i, cand)) return -1;
        	}
        	
        	return cand;
        	
        }else return -1;
    }
	
	public static void main(String[] args) {
		FindtheCelebrity test = new FindtheCelebrity();
		System.out.println(test.findCelebrity(3));
	}
	
}
