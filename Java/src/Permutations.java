import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permuteOld(int[] nums) {
        boolean [] used = new boolean[nums.length];
        ArrayList<Integer> intInStack = new ArrayList<Integer>();
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length; i++) {
            permuteHelperOld(i, nums, used, intInStack, result);
        }
        
        return result;
        
    }
    
    private void permuteHelperOld(int index, int[] nums, boolean[] used, ArrayList<Integer> intInStack, ArrayList<List<Integer>> result) {
        intInStack.add(nums[index]);
        used[index] = true;
        
        if(intInStack.size() == nums.length) {
            result.add(new ArrayList<Integer>(intInStack));
        }else {
            for(int i = 0; i < nums.length; i++) {
                if(!used[i]) permuteHelperOld(i, nums, used, intInStack, result);
            }
        }

        intInStack.remove(intInStack.size() - 1);
        used[index] = false;
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean [] used = new boolean[nums.length];
        ArrayList<Integer> intInStack = new ArrayList<Integer>();
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        permuteHelper(nums, used, intInStack, result);
        return result;
    }
    
    private void permuteHelper(int[] nums, boolean[] used, ArrayList<Integer> intInStack, ArrayList<List<Integer>> result) {
        if(intInStack.size() == nums.length) {
            result.add(new ArrayList<Integer>(intInStack));
        }else {
            for(int i = 0; i < nums.length; i++) {
                if(!used[i]) {
                    intInStack.add(nums[i]);
                    used[i] = true;
                    permuteHelper(nums, used, intInStack, result);
                    intInStack.remove(intInStack.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int [] nums = {1, 2, 3};
        Permutations p = new Permutations();
        List<List<Integer>> result = p.permute(nums);
        System.out.println("ok");
    }

}
