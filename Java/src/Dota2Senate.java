
public class Dota2Senate {
	
	public String predictPartyVictory(String senate) {
        int count = 0;
        int rCount = 0;
        int dCount = 0;
        char[] chars = senate.toCharArray();
        for(int i = 0; i < senate.length(); i++) {
        	if(chars[i] == 'R') rCount++;
        	if(chars[i] == 'D') dCount++;
        }
        
        if(rCount == 0) return "Dire";
        else if(dCount == 0) return "Radiant";
        
        for(int i = 0; i < senate.length(); i++) {

        	if(chars[i] == 'R') {
        		if(count >= 0) count++;
        		else {
        			count++;
        			chars[i] = ' ';
        			rCount--;
        			if(rCount == 0) return "Dire";
        		}
        	}else if(chars[i] == 'D') {
        		if(count <= 0) count--;
        		else {
        			count--;
        			chars[i] = ' ';
        			dCount--;
        			if(dCount == 0) return "Radiant";
        		}
        		
        		
        	}
        	
        	if(i == senate.length()-1) i=-1;
        	
        }
        
        return null;
    }
	
	public static void main(String[] args) {
		Dota2Senate test = new Dota2Senate();
		System.out.println(test.predictPartyVictory("RDD"));
	}
}
