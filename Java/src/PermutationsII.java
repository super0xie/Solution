import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermutationsII {
    
    private List<List<Integer>> result;
    private HashMap<Integer, Integer> table;
    private int size;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        size = nums.length;       
        table = new HashMap<Integer, Integer>();
        result = new ArrayList<List<Integer>>();
        for(int num : nums) {
            table.merge(num, 1, Integer::sum);
        }
        
        
        List<Integer> list = new ArrayList<Integer>();
        for(int key : table.keySet()) {
            helper(list, 0, key);  
        }

        
        return result;
    }
    
    private void helper(List<Integer> list, int count, int num) {
        list.add(num);
        count++;
        table.merge(num, -1, Integer::sum);
        
        if(count == size) {
            List<Integer> oneResult = new ArrayList<Integer>(list);

            result.add(oneResult);
        }else {
            for(int key : table.keySet()) {
                if(table.get(key) > 0) helper(list, count, key);   
            }
        }
        
        list.remove(list.size()-1);
        table.merge(num, 1, Integer::sum);  
        
    }
    
    
    public static void main(String[] args) {
        PermutationsII test = new PermutationsII();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = test.permuteUnique(nums);
        
        
        for(List<Integer> list : result) {
            for(int num : list) {
                System.out.print(num + ", ");
                
            }
            System.out.print("\n");
        }
        
        System.out.println("hello");
    }
    
    
    
    
}
