import java.util.ArrayList;
import java.util.HashSet;

public class TwoSumIIIDatastructuredesign {
    
//    private HashSet<Integer> set;
//    private HashSet<Integer> num;
//    
//    public void TwoSum() {
//        set = new HashSet<>();
//        num = new HashSet<>();
//    }
//    
//    /** Add the number to an internal data structure.. */
//    public void add(int number) {
//        for(int i : num) {
//            set.add(i + number);
//        }
//        num.add(number);
//    }
//    
//    /** Find if there exists any pair of numbers which sum is equal to the value. */
//    public boolean find(int value) {
//        return set.contains(value);
//    }
    
    private ArrayList<Integer> list;
    private boolean sorted = false;
    
    public void TwoSum() {
        list = new ArrayList<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
        sorted = false;
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if(!sorted)
            list.sort(null);
        sorted = true;
        
        int i = 0;
        int j = list.size()-1;
        while(i < j) {
            int sum = list.get(i) + list.get(j);
            if(sum == value) return true;
            if(sum < value) i++;
            else j--;
        }
        return false;
    }
}
