
public class DeleteColumnstoMakeSorted {
	
	public int minDeletionSize(String[] A) {
		int res = 0;
        for(int j = 0; j < A[0].length(); j++) {
        	for(int i = 1; i < A.length; i++) {
        		if(A[i].charAt(j) < A[i-1].charAt(j)) {
        			res++;
        			break;
        		}
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		DeleteColumnstoMakeSorted test = new DeleteColumnstoMakeSorted();
		String[] A = {"zyx","wvu","tsr"};
		System.out.println(test.minDeletionSize(A));
	}
}
