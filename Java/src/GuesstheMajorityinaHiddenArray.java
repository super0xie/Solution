import java.util.Arrays;

public class GuesstheMajorityinaHiddenArray {
	
	 interface ArrayReader {
		 public int query(int a, int b, int c, int d);
		 public int length();
	 }
	
	public int guessMajority(ArrayReader reader) {
        int n = reader.length();
        int r1 = reader.query(0, 1, 2, 3);
        int r2 = reader.query(1, 2, 3, 4);
        int c1 = 0;
        int c2 = 0;
        int i1 = 0;
        int i2 = 0;
        int i3 = -1;
        
        if(r1 == 4) {
        	i1 = 0;
        	i2 = 1;
        	if(r2 == 4) {
        		c1 = 5; 
        		c2 = 0;
        	}else {
        		c1 = 4;
        		c2 = 1;
        		i3 = 4;
        	}
        }else if(r1 == 2) {
        	if(r2 == 2) {
        		i1 = 0;
        		i2 = 4;
        		int r3 = reader.query(0, 1, 3, 4);
        		if(r3 == 0) {
        			c1 = 2;
        			c2 = 3;
        			i3 = 2;
        		}else if(r3 == 4){
        			c1 = 4;
        			c2 = 1;
        			i3 = 2;
        		}else if(r3 == 2) {
        			c1 = 4;
        			c2 = 1;
        			int r4 = reader.query(0, 2, 3, 4);
        			if(r4 == 4) i3 = 1;
        			else i3 = 3;
        		}
        	}else if(r2 == 0){
        		int r3 = reader.query(0, 1, 3, 4);
        		c1 = 3;
        		c2 = 2;
        		i3 = 4;
        		if(r3 == 0) {
        			i1 = 0;
        			i2 = 2;
        		} else {
        			i1 = 0;
        			i2 = 1;
        		}
        	}else {
        		i1 = 1;
        		i2 = 2;
        		c1 = 4;
        		c2 = 1;
        		i3 = 0;
        	}
        } else {
        	if(r2 == 0) {
        		i1 = 0;
        		i2 = 4;
        		c1 = 3;
        		c2 = 2;
        		int r3 = reader.query(0, 1, 3, 4);
        		if(r3 == 0) i3 = 1;
        		else i3 = 2;
        	}else if(r2 == 2) {
        		i3 = 4;
        		c1 = 2;
        		c2 = 3;
        		i1 = 0;
        		int r3 = reader.query(0, 1, 3, 4);
        		if(r3 == 2) i2 = 2;
        		else {
        			int r4 = reader.query(0, 2, 3, 4);
        			if(r4 == 2) i2 = 1;
        			else i2 = 3;
        		}
        	}
        }
        
        for(int i = 5; i < n-1; i+=2) {
        	int r = reader.query(i1, i2, i, i+1);
        	if(r == 4) c1+=2;
        	else if(r == 2) {
        		c1++;
        		c2++;
        	}else {
        		c2+=2;
        		if(i3 < 0) i3 = i;
        	}
        }
        
        if(n % 2 == 0) {
        	if(i3 < 0) return i1;
        	int[] idx = {i1, i2, i3};
        	Arrays.parallelSort(idx);
        	int r = reader.query(idx[0], idx[1], idx[2], n-1);
        	if(r == 0) c2++;
        	else if(r == 2) c1++;
        }
        
        if(c1 == c2) return -1;
        else if(c1 > c2) return i1;
        else return i3;
    }
	

}
