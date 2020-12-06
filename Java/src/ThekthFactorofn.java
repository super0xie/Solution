
public class ThekthFactorofn {
	public int kthFactor(int n, int k) {
        int idx = 0;
        for(int i = 1; i <= n; i++) {
        	if(n % i == 0) idx++;
        	if(idx == k) return i;
        }
        return -1;
    }
}
