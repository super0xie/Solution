
public class PushDominoes {
	
	public String pushDominoes(String dominoes) {
        char[] d = dominoes.toCharArray();
        int i = 0;
        while(i < d.length) {
        	if(d[i] == '.') {
        		int j = i;
            	while(j < d.length && d[j] == '.') j++;
            	if(j == d.length) break;
            	if(d[j] == 'L') {
            		for(int k = i; k < j; k++) d[k] = 'L';
            		i = j+1;
            	}else {
            		i = j;
            	}
        	}else if(d[i] == 'R') {
        		int j = i+1;
        		while(j < d.length && d[j] == '.') j++;
        		if(j == d.length || d[j] == 'R') {
        			for(int k = i+1; k < j; k++) d[k] = 'R';
        			i = j;
        		}else if(d[j] == 'L') {
            		int l = i;
            		int r = j;
            		while(l < r) {
            			d[l++] = 'R';
            			d[r--] = 'L';
            		}
            		i = j+1;
        		}
        	}else {
        		i++;
        	}
        }
        
        return String.valueOf(d);
    }
	
	public static void main(String[] args) {
		PushDominoes test = new PushDominoes();
		System.out.println(test.pushDominoes("RR.L"));
		
	}
	
}
