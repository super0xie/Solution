import java.util.LinkedList;
import java.util.List;

public class AddtoArrayFormofInteger {
	
	public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        int carry = 0;
        int i = A.length-1;
        while(K > 0 || i >= 0) {
        	int a = 0, b = 0;
        	b = K % 10;
        	K = K / 10;
        	if(i >= 0) a = A[i];
        	int sum = carry + a + b;
        	
        	if(sum >= 10) {
        		carry = 1;
        		sum = sum % 10;
        	}else {
        		carry = 0;
        	}
        	res.addFirst(sum);
        	i--;
        }
        
        if(carry > 0) res.addFirst(carry);
        return res;
    }
}
