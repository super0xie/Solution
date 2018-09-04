
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        int[] counter = new int[10];
        String str = String.valueOf(n);
        int pre = str.charAt(str.length()-1) - '0';
        counter[pre]++;
        int cur = 0;
        int i;
        for(i = str.length()-2; i >= 0; i--) {
        	cur = str.charAt(i) - '0';
        	if(cur >= pre) {
        		counter[cur]++;
        		pre = cur;
        	}else {
        		counter[cur]++;
        		break;
        	}
        }
        
        if(i < 0) return -1;
        String prefix = str.substring(0, i);
        String suffix = "";
        for(int j = 0; j < 10; j++) {
        	if(counter[j] > 0 && j > cur) {
        		suffix = suffix + (char)('0'+j);
        		counter[j]--;
        		break;
        	}
        }
        
        for(int j = 0; j < 10; j++) {
        	while(counter[j]>0) {
        		suffix = suffix + (char)('0'+j);
        		counter[j]--;
        	}
        }
        
        long res = Long.parseLong(prefix+suffix);
        if(res > Integer.MAX_VALUE) return -1;
        else return (int)res;
        
    }
    
    public static void main(String[] args) {
    	NextGreaterElementIII test = new NextGreaterElementIII();
    	System.out.println(test.nextGreaterElement(12));
    }
}
