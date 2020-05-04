
public class MinimumNumberofFrogsCroaking {
	
	public int minNumberOfFrogs(String str) {
        int c = 0;
        int r = 0;
        int o = 0;
        int a = 0;
        int count = 0;
        int max = 0;
        
        for(int i = 0; i < str.length(); i++) {
        	if(str.charAt(i) == 'c') {
        		c++;
        		count++;
        	}else if(str.charAt(i) == 'r') {
        		if(c <= 0) return -1;
        		c--;
        		r++;
        	}else if(str.charAt(i) == 'o') {
        		if(r <= 0) return -1;
        		r--;
        		o++;
        	}else if(str.charAt(i) == 'a') {
        		if(o <= 0) return -1;
        		o--;
        		a++;
        	}else {
        		if(a <= 0) return -1;
        		a--;
        		count--;
        	}
        	
        	max = Math.max(max, count);
        }
        if(count != 0) return -1;
        
        return max;
    }
	
}
