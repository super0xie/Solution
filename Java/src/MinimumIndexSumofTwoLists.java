import java.util.ArrayList;
import java.util.HashMap;

public class MinimumIndexSumofTwoLists {
    
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++) {
            String str = list1[i];
            map.put(str, i);
        }
        
        int sum = Integer.MAX_VALUE;
        ArrayList<String> l = new ArrayList<>();
        for(int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int s = i + map.get(list2[i]);
                if(s < sum) {
                    sum = s;
                    l.clear();
                    l.add(list2[i]);
                }else if(s == sum){
                    l.add(list2[i]);
                }
            }
        }
        
        String[] res = new String[l.size()];
        for(int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;
    }
    
}
