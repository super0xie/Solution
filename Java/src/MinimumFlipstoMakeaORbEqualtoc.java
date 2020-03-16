
public class MinimumFlipstoMakeaORbEqualtoc {
	
	public int minFlips(int a, int b, int c) {
		boolean[] aa = helper(a);
		boolean[] bb = helper(b);
		boolean[] cc = helper(c);
        
		int res = 0;
        for(int i = 0; i < 32; i++) {
        	if((aa[i] | bb[i]) != cc[i]) {
        		if(cc[i]) res++;
        		else {
        			if(aa[i]) res++;
        			if(bb[i]) res++;
        		}
        	}
        }
        
        return res;
    }
	
	private boolean[] helper(int i) {
		boolean[] res = new boolean[32];
		int idx = 0;
		while(i > 0) {
			res[idx++] = i % 2 == 1;
			i = i / 2;
		}
		return res;
	}
	
	public static void main(String[] args) {
		MinimumFlipstoMakeaORbEqualtoc test = new MinimumFlipstoMakeaORbEqualtoc();
		System.out.println(test.minFlips(1, 2, 3));
	}
	
}
