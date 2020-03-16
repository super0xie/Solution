import java.util.ArrayList;

public class DeleteColumnstoMakeSortedII {

	public int minDeletionSize(String[] A) {
        ArrayList<String> l = new ArrayList<>();
        for(String str : A) {
        	l.add(str);
		}
		ArrayList<ArrayList<String>> groups = new ArrayList<>();
		groups.add(l);

		int len = A[0].length();
		boolean [] needDelete = new boolean[A[0].length()];
		
		for(int i = 0; i < len; i++){
			boolean cont = false;
			ArrayList<ArrayList<String>> aux = new ArrayList<>();
			for(ArrayList<String> group : groups){
				boolean[] res = inorder(group, i);
				if(!res[0]){
					needDelete[i] = true;
					aux = groups;
					cont = true;
					break;
				}else if(!res[1]){
					cont = true;
					for(int j = 0; j < group.size()-1; j++){
						int k = j+1;
						while(k < group.size() && group.get(k).charAt(i) == group.get(k-1).charAt(i)) k++;
						if(k-j > 1){
							ArrayList<String> curr = new ArrayList<>();
							for(int n = j; n < k; n++){
								curr.add(group.get(n));
							}
							aux.add(curr);
						}
					}
				}
			}
			if(!cont) break;
			else groups = aux;
		}

        int count = 0;
		for(int j = 0; j < needDelete.length; j++) {
			if(needDelete[j]) count++;
		}
		return count;
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
