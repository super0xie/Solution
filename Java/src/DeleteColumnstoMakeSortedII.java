import java.util.ArrayList;

public class DeleteColumnstoMakeSortedII {
	
	public int minDeletionSize(String[] A) {
        
        ArrayList<String> l = new ArrayList<>();
        for(String str : A) {
        	l.add(str);
        }
        boolean [] needDelete = new boolean[A[0].length()];
        minDeletionSize(l, 0, needDelete);
        int count = 0;
		for(int j = 0; j < needDelete.length; j++) {
			if(needDelete[j]) count++;
		}
		return count;
    }
	
	public void minDeletionSize(ArrayList<String> l, int start, boolean [] needDelete) {
        for(int i = start; i < l.get(0).length() ; i++) {
        	boolean [] ret = inorder(l, i);
        	if(!ret[0]) needDelete[i] = true;
        	else {
        		if(ret[1]) return;
        		
        		int rest = 0;
        		for(int j = 0; j < l.size()-1; j++) {
        			int k = j+1;
        			while(k < l.size() && l.get(k).charAt(i) == l.get(j).charAt(i)) {
        				k++;
        			}
        			if(k - j > 1) {
        				ArrayList<String> aux = new ArrayList<>();
        				for(int n = j; n < k; n++) {
        					aux.add(l.get(n));
        				}
        				minDeletionSize(aux, i+1, needDelete);
        				j = k-1;
        			}
        		}
    			return;
        	}
        }
    }
	
	private boolean[] inorder(ArrayList<String> l, int idx) {
		boolean strict = true;
		for(int i = 0; i < l.size()-1; i++) {
			if(l.get(i).charAt(idx) > l.get(i+1).charAt(idx)) return new boolean[] {false, false};
			else if(l.get(i).charAt(idx) == l.get(i+1).charAt(idx)) strict = false;
		}
		return new boolean[] {true, strict};
	}
	
	public static void main(String[] args) {
		DeleteColumnstoMakeSortedII test = new DeleteColumnstoMakeSortedII();
		String[] A = {"bwwdyeyfhc","bchpphbtkh","hmpudwfkpw","lqeoyqkqwe","riobghmpaa","stbheblgao","snlaewujlc","tqlzolljas","twdkexzvfx","wacnnhjdis"};
		System.out.println(test.minDeletionSize(A));
	}
}
