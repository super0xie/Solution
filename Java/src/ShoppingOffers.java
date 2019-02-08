import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class ShoppingOffers{

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int min = Integer.MAX_VALUE;
        int len = needs.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] n = new int[needs.size()+1];
        for(int i = 0; i < needs.size(); i++){
            n[i] = needs.get(i);
        }
        int key = encode(n);
        map.put(key, 0);

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            int cost = 0;
            for(int i = 0; i < len; i++){
                cost += polled[i] * price.get(i);
            }
            cost += polled[len];
            min = Math.min(cost, min);

            for(List<Integer> spec : special){
                int i = 0;
                for(; i < len; i++){
                    if(polled[i] < spec.get(i)) break;
                }
                if(i == len){
                    int[] copy = polled.clone();
                    for(i = 0; i < needs.size(); i++){
                        copy[i] -= spec.get(i);
                    }

                    copy[len] += spec.get(len);

                    key = encode(copy);
                    if(map.containsKey(key) && map.get(key) <= copy[len]) continue;
                    else{
                        map.put(key, copy[len]);
                        queue.add(copy);
                    }
                }
            }
        }

        return min;
    }

    private int encode(int[] node){
        int res = 0;
        for(int i = 0; i < node.length-1; i++){
            res += node[i];
            res = res * 10;
        }
        return res;
    }

    public static void main(String[] args) {
        ShoppingOffers test = new ShoppingOffers();
        List<Integer> price = Arrays.asList(2,3,4);
        List<List<Integer>> special = Arrays.asList(Arrays.asList(1,1,0,4), Arrays.asList(2,2,1,9));
        List<Integer> needs = Arrays.asList(1,2,1);
        System.out.println(test.shoppingOffers(price, special, needs));
        
    }

}