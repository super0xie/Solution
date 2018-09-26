
public class BeautifulArrangementII {
	
	public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int i = 2;
        int j = n;
        
        res[0] = 1;
        int idx = 1;
        int count = 0;
        boolean left = false;
        
        while(count < k) {
            
            if(count == k-1) {
                if(!left) {
                    while(i <= j) res[idx++] = i++;
                }else {
                    while(i <= j) res[idx++] = j--;
                }
                break;
            }
            
            if(left) res[idx++] = i++;
            else res[idx++] = j--;
            
            left = !left;
            count++;
        }
        return res;
    }
	
	public static void main(String[] args) {
	    BeautifulArrangementII test = new BeautifulArrangementII();
	    test.constructArray(5, 2);
	}

}
