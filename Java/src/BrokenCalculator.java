import java.util.HashSet;
import java.util.LinkedList;

public class BrokenCalculator {

    public int brokenCalcTLE(int X, int Y) {
        if(X == Y) return 0;
        int min = Integer.MAX_VALUE;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(X);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(X);
        int step = 0;
        
        while(Y % 2 == 0 && Y / 2 >= X) {
            Y = Y / 2;
            step++;
        }

        while(!queue.isEmpty()){
            if(min <= step) break;
            LinkedList<Integer> aux= new LinkedList<>();
            while(!queue.isEmpty()){
                int polled = queue.poll();
                if(polled >= Y){
                    min = Math.min(min, step+polled-Y);
                }else{
                    int n = polled * 2;
                    if(!visited.contains(n)){
                        aux.add(n);
                        visited.add(n);
                    }
                    n = polled - 1;
                    if(n > 0){
                        if(!visited.contains(n)){
                            aux.add(n);
                            visited.add(n);
                        }
                    }
                }
            }
            step++;
            queue = aux;

        }
        return min;
    }
    
    public int brokenCalcBad(int X, int Y) {
        if(X == Y) return 0;
        int min = Integer.MAX_VALUE;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(X);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(X);
        int step = 0;
        
        while(Y % 2 == 0 && Y / 2 >= X) {
            Y = Y / 2;
            step++;
        }

        while(!queue.isEmpty()){
            if(min <= step) break;
            LinkedList<Integer> aux= new LinkedList<>();
            while(!queue.isEmpty()){
                int polled = queue.poll();
                if(polled >= Y){
                    min = Math.min(min, step+polled-Y);
                }else{
                    int n = polled * 2;
                    if(!visited.contains(n)){
                        aux.add(n);
                        visited.add(n);
                    }
                    if(n > Y) {
                        int res = step+1;
                        if(Y % 2 != 0)
                            res++;
                        res += polled - (Y+1)/2;
                        min = Math.min(min, res);
                    }else {
                        n = polled-1;
                        if(n > 0){
                            if(!visited.contains(n)){
                                aux.add(n);
                                visited.add(n);
                            }
                        }
                    }
                }
            }
            step++;
            queue = aux;

        }
        return min;
    }
    
    public int brokenCalc(int X, int Y) {
        if(X >= Y) return X-Y;
        int step = 0;
        
        while((Y+1) / 2 >= X) {
            if(Y % 2 == 1) {
                step++;
                Y++;
            }
            Y = Y / 2;
            step++;
        }
        if(X == Y) return step;
        int res = step+1;
        if(Y % 2 != 0)
            res++;
        res += X - (Y+1)/2;

        
        return res;
    }
    


    public static void main(String[] args) {
        BrokenCalculator test = new BrokenCalculator();
        System.out.print(test.brokenCalcBad(1, 1000000000));
    }
}
