import java.util.HashSet;

public class PathCrossing {
	
	public boolean isPathCrossing(String path) {
        int i = 0;
        int j = 0;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        for(int k = 0; k < path.length(); k++) {
        	char c = path.charAt(k);
        	if(c == 'N') {
        		j++;
        	}else if(c == 'S') {
        		j--;
        	}else if(c == 'E') {
        		i++;
        	}else {
        		i--;
        	}
        	int code = 100000 * i + j;
        	if(visited.contains(code)) return true;
        	visited.add(code);
        }
        return false;
    }
	
	public static void main(String[] args) {
		String path = "NESWW";
		PathCrossing test = new PathCrossing();
		test.isPathCrossing(path);
	}
	
}
