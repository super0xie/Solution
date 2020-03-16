
public class RobotBoundedInCircle {
	
	public boolean isRobotBounded(String instructions) {
        
        int stepX = 0;
        int stepY = 0;
        int dir = 0;
        
        for(int i = 0; i < instructions.length(); i++) {
        	if(instructions.charAt(i) == 'L') dir--;
        	else if(instructions.charAt(i) == 'R') dir++;
        	else {
        		dir = dir % 4;
        		if(dir < 0) dir += 4;
        		
        		if(dir == 0) stepY++;
        		else if(dir == 1) stepX++;
        		else if(dir == 2) stepY--;
        		else stepX--;
        	}
        }
        
        dir = dir % 4;
		if(dir < 0) dir += 4;
        
        if(dir != 0) return true;
        
        if(stepX == 0 && stepY == 0) return true;
        return false;
    }
	
	public static void main(String[] args) {
		RobotBoundedInCircle test = new RobotBoundedInCircle();
		System.out.println((-1)%4);
	}
}
