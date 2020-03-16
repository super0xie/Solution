
public class DistanceBetweenBusStops {
	
	public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        
        if(start > destination) {
        	int aux = start;
        	start = destination;
        	destination = aux;
        }
        
        boolean bet = false;
        int dis = 0;
        for(int i = 0; i < distance.length; i++) {
        	sum += distance[i];
        	if(i == start) bet = true;
        	if(i == destination) bet = false;
        	if(bet) dis += distance[i];
        }
        
        return Math.min(dis, sum-dis);
    }
	
	public static void main(String[] args) {
		DistanceBetweenBusStops test = new DistanceBetweenBusStops();
		int[] distance = {1,2,3,4};
		System.out.print(test.distanceBetweenBusStops(distance, 0, 3));
	}
}
