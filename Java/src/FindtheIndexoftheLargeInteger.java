
public class FindtheIndexoftheLargeInteger {
	
	
	
	  
	interface ArrayReader {
		public int compareSub(int l, int r, int x, int y);
		public int length();
	}
	 
	
	public int getIndex(ArrayReader reader) {
        int l = 0;
        int r = reader.length()-1;
        
        while(l < r) {
        	
        	if((r-l)%2 == 1) {
        		int m = l + (r-l)/2;
        		int ret = reader.compareSub(l, m, m+1, r);
            	if(ret > 0) r = m;
            	else l = m+1;
        	} else {
        		int m = l + (r-l)/2;
        		int ret = reader.compareSub(l, m-1, m+1, r);
        		if(ret > 0) {
        			r = m-1;
        		}else if(ret < 0) {
        			l = m+1;
        		}else {
        			return m;
        		}
        	}
        }
        
        return l;
    }
	
}
