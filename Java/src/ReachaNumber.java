import java.util.LinkedList;

public class ReachaNumber {
    public int reachNumberTLE(int target) {
        if(target == 0) return 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        queue.add(0);
        int step = 1;
        
        while(!queue.isEmpty()) {
            LinkedList<Integer> aux = new LinkedList<Integer>();
            
            while(!queue.isEmpty()) {
                int polled = queue.poll();
                
                if(polled-step == target || polled+step == target) return step;
                
                aux.add(polled-step);
                aux.add(polled+step);
            }
            
            step++;
            queue = aux;
        }
        
        return -1;
    }

    public int reachNumber(int target) {
        if(target == 0) return 0;
        if(target < 0) target = -target;
        int start = 0;
        if(target % 2 == 1) start = 1;
        else start = 2;
        int stop = Integer.MAX_VALUE/2;
        for(int i = start; i < stop; i=i+2){
            for(int j = 2 * i - 1; j <= 2 * i; j++){
                int end = (1 + j) * j / 2;
                if(target <= end) return j;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        ReachaNumber test = new ReachaNumber();
        System.out.print(test.reachNumber(-1000000000));
    }


}