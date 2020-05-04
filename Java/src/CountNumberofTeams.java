
public class CountNumberofTeams {
	
	public int numTeams(int[] rating) {
		int res = 0;
        for(int i = 0; i < rating.length; i++) {
        	int lst = 0;
        	int rst = 0;
        	
        	for(int j = 0; j < rating.length; j++) {
        		if(rating[j] < rating[i]) {
        			if(j < i) lst++;
        			else rst++;
        		}
        	}
        	
        	int lgt = i-lst;
        	int rgt = rating.length-i-1-rst;
        	
        	res += lst * rgt + lgt * rst;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] rating = {2,5,3,4,1};
		CountNumberofTeams test = new CountNumberofTeams();
		System.out.println(test.numTeams(rating));
	}
	
}
