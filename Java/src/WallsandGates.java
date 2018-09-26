import java.util.HashSet;
import java.util.LinkedList;

public class WallsandGates {
    
    private class Node{
        int i;
        int j;
        Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public void wallsAndGates(int[][] rooms) {
        HashSet<Integer> visited = new HashSet<Integer>();
        LinkedList<Node> queue = new LinkedList<Node>();
        
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    queue.add(new Node(i, j));
                    visited.add(200 * i + j);
                }
            }
        }
        
        int[][] adj = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        int dis = 1;
        while(!queue.isEmpty()) {
            LinkedList<Node> aux = new LinkedList<Node>();
            
            while(!queue.isEmpty()) {
                Node polled = queue.poll();
                
                for(int i = 0; i < 4; i++) {
                    int r = polled.i + adj[i][0];
                    int c = polled.j + adj[i][1];
                    
                    if(r >= 0 && r < rooms.length && c >= 0 && c < rooms[0].length 
                            && rooms[r][c] != -1 &&!visited.contains(200 * r + c)) {
                        rooms[r][c] = dis;
                        aux.add(new Node(r, c));
                        visited.add(200 * r + c);
                    }
                }
            }
            
            dis++;
            queue = aux;
        }
    }
    
    public static void main(String[] args) {
        WallsandGates test = new WallsandGates();
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        test.wallsAndGates(rooms);
    }

}
