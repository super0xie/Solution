import java.util.HashSet;
import java.util.LinkedList;

public class DesignSnakeGame {
	
	
	
	private LinkedList<int[]> list = new LinkedList<int[]>();
	private HashSet<String> taken = new HashSet<String>();
	private int width;
	private int height;
	private int[] head = new int[2];
	private int[][] food;
	private int index = 0;
	
	public void SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        list.add(new int[] {0,0});
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
    	
    	int [] target = new int [2];
        if(direction.equals("U")) {
        	target[0] = head[0]-1;
        	target[1] = head[1];
        }else if(direction.equals("L")) {
        	target[0] = head[0];
        	target[1] = head[1]-1;
        }else if(direction.equals("R")) {
        	target[0] = head[0];
        	target[1] = head[1]+1;
        }else if(direction.equals("D")) {
        	target[0] = head[0]+1;
        	target[1] = head[1];
        }
        
        if(target[0] < 0 || target[0] >= height || target[1] < 0 || target[1] >= width) return -1;
        
        
        if(index < food.length && target[0] == food[index][0] && target[1] == food[index][1]) {
        	taken.add("" + target[0] + "," + target[1]);
        	list.add(target);
        	index++;
        	head = target;
        	return index;
        }
        
        int [] removed = list.removeFirst();
        taken.remove("" + removed[0] + "," + removed[1]);
        if(taken.contains("" + target[0] + "," + target[1])) return -1;
        taken.add("" + target[0] + "," + target[1]);
        list.add(target);
        head = target;
        return index;
    }

}
