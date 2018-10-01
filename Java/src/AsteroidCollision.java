import java.util.Stack;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < asteroids.length; i++) {
        	if(asteroids[i] > 0) {
        		stack.push(asteroids[i]);
        	} else if(asteroids[i] < 0) {
        		if(stack.isEmpty()) stack.push(asteroids[i]);
        		else {
        			while(!stack.isEmpty()) {
            			if(stack.peek() > 0) {
            				if(stack.peek() > -asteroids[i]) {
                				break;
                			}else if(stack.peek() < -asteroids[i]) {
                				stack.pop();
                				if(stack.isEmpty()) {
                					stack.push(asteroids[i]);
                					break;
                				}
                			}else {
                				stack.pop();
                				break;
                			}
            			}else {
            				stack.push(asteroids[i]);
            				break;
            			}
            		}
        		}
        	}
        }
        
        int[] res = new int[stack.size()];
        int idx = res.length-1;
        while(!stack.isEmpty()) {
        	res[idx--] = stack.pop();
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] asteroids = {-2,-1,1,2};
		AsteroidCollision test = new AsteroidCollision();
		test.asteroidCollision(asteroids);
	}
}
