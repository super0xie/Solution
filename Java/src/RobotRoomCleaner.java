import java.util.HashSet;

public class RobotRoomCleaner {

	interface Robot {
		public boolean move();
		public void turnLeft();
		public void turnRight();
		public void clean();
	}
	
	private HashSet<Integer> visited;
	
	public void cleanRoom(Robot robot) {
		visited = new HashSet<Integer>();
		dfs(robot, 0, 0, 0);
    }
	
	//dir 0 up, 1 right, 2 down, 3 left
	private void dfs(Robot robot, int i, int j, int dir) {
		visited.add(1000 * i + j);
		robot.clean();
		//turn to up
		switch(dir) {
		case 0:
			break;
		case 1:
			robot.turnLeft();
			break;
		case 2:
			robot.turnLeft();
			robot.turnLeft();
			break;
		case 3:
			robot.turnRight();
			break;
		}
		
		//up
		if(!visited.contains(1000 * (i-1) + j)) {
			if(robot.move()) {
				dfs(robot, i-1, j, 0);
				robot.turnLeft();
				robot.turnLeft();
				robot.move();
				robot.turnLeft();
				robot.turnLeft();
			}
			
		}
		
		if(!visited.contains(1000 * (i) + j+1)) {
			robot.turnRight();
			if(robot.move()) {
				dfs(robot, i, j+1, 1);
				robot.turnLeft();
				robot.move();
				robot.turnRight();
			}else {
				robot.turnLeft();
			}
		}
		
		if(!visited.contains(1000 * (i+1) + j)) {
			robot.turnLeft();
			robot.turnLeft();
			if(robot.move()) {
				dfs(robot, i+1, j, 2);
				robot.move();
			}else {
				robot.turnLeft();
				robot.turnLeft();
			}
			
		}
		
		if(!visited.contains(1000 * (i) + j-1)) {
			robot.turnLeft();
			if(robot.move()) {
				dfs(robot, i, j-1, 3);
				robot.turnRight();
				robot.move();
				robot.turnLeft();
			}else {
				robot.turnRight();
			}
		}
		
	}
	 
	 

}
