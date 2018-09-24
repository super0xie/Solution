import java.util.HashSet;
import java.util.LinkedList;

public class EscapeTheGhosts {
	
	private class Node{
		int i;
		int j;
		Node(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	public boolean escapeGhostsTLE(int[][] ghosts, int[] target) {
        HashSet<Integer> visited = new HashSet<Integer>();
        LinkedList<Node> queue = new LinkedList<Node>();
        HashSet<Integer> g = new HashSet<Integer>();
        int[][] neighbor = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i = 0; i < ghosts.length; i++) {
        	int encode = ghosts[i][0] * 10000 + ghosts[i][1];
        	g.add(encode);
        }
        queue.add(new Node(target[0], target[1]));
        int targetEncode = target[0] * 10000 + target[1];
        if(targetEncode == 0) return true;
        visited.add(targetEncode);
        
        while(!queue.isEmpty()) {
        	LinkedList<Node> aux = new LinkedList<Node>();
        	
        	boolean findPlayer = false;
        	while(!queue.isEmpty()) {
        		Node polled = queue.poll();
        		for(int i = 0; i < 4; i++) {
        			int r = polled.i + neighbor[i][0];
        			int c = polled.j + neighbor[i][1];
        			int encode = 10000 * r + c;
        			if(visited.contains(encode)) continue;
        			
        			if(encode == 0) findPlayer = true;
        			if(g.contains(encode)) return false;
        			
        			aux.add(new Node(r,c));
        			visited.add(encode);
        		}
        	}
        	if(findPlayer) return true;
        	queue = aux;
        }
        
        return false;
    }
	
	public boolean escapeGhosts(int[][] ghosts, int[] target) {
		int tarDis = Math.abs(target[0]) + Math.abs(target[1]);
		
		for(int i = 0; i < ghosts.length; i++) {
			int dis = Math.abs(target[0] - ghosts[i][0]) + Math.abs(target[1] - ghosts[i][1]);
			if(dis <= tarDis) return false;
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		int[] target = {3649,6156};
		int[][] ghosts = {{793,9579},{4375,8541},{7668,2976},{1405,-6226},{-6384,3429},{-8324,-1472},{4738,2717},{6182,2630},{-6738,1189},{-2851,-6597},{8377,6154},{6416,-4056},{-9358,-4503},{-5996,-4935},{-4087,8710},{-8537,-4851},{-4614,3900},{4628,850},{3892,8172},{6559,9750},{1704,-6017},{-1500,-4280},{5595,-8308},{1069,2097},{7171,-8754},{-2018,357},{-6349,-6607},{-9551,7222},{5196,-248},{5491,-1606},{1547,537},{-2657,-4177},{6582,-8872},{5436,-459},{6419,-3583},{-9798,8511},{-1802,6384},{-9717,7592},{839,9498},{2228,9980},{5455,-2751},{7210,2230},{-763,4687},{5444,-4496},{-2357,-8637},{7416,-9812},{-7962,-9934},{-8414,4825},{-7659,-5894},{8337,1484},{-5647,9054},{4581,-7605},{-3857,8343},{6834,9327},{-8837,-5064},{8680,958},{-3720,2124},{-535,1323},{-3436,-5330},{9440,-6890},{1872,-903},{-2410,598},{-154,9004},{-1512,2410},{9537,-7930},{-164,6859},{-1401,-4886},{6144,-9442},{6,-6827},{-8561,8014},{4617,7851},{-8756,-638},{4250,-6725},{1403,3367},{-1244,2536},{-8906,-9625},{-9950,1484},{7566,-9272},{7631,-665},{-1134,-6653},{-9273,-6891},{9110,2471},{-8844,-1683},{-3533,8801},{8585,-5125},{-5140,9914},{5212,-6899},{-6638,4092},{-7790,-901},{-4212,5948},{1526,2238},{-9513,7842},{1274,2462},{7528,116},{6648,-4132},{-6157,9177},{8119,1814},{-4279,-5573},{-8003,-9858},{-6671,3189}};
		EscapeTheGhosts test = new EscapeTheGhosts();
		test.escapeGhosts(ghosts, target);
	}

}
