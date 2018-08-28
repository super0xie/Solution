
public class JudgeRouteCircle {
	
    public boolean judgeCircle(String moves) {
        int h = 0;
        int v = 0;
        
        for(int i = 0; i < moves.length(); i++) {
        	char c = moves.charAt(i);
        	
        	if(c == 'U') {
        		v++;
        	}else if(c == 'D') {
        		v--;
        	}else if(c == 'L') {
        		h++;
        	}else if(c == 'R') {
        		h--;
        	}
        	
        }
        
        return v==0 && h==0;
    }
    
}
