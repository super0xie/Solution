
public class ArrayNesting {
    
    public int arrayNestingOn2(int[] nums) {
        int res = 1;
        for(int i = 0; i < nums.length; i++) {
            boolean[] visited = new boolean[nums.length];
            
            visited[i] = true;
            int next = nums[i];
            int count = 1;
            while(!visited[next]) {
                visited[next] = true;
                next = nums[next];
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
    
    
    public int arrayNesting(int[] nums) {
        
        int[] reverse = new int [nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            reverse[nums[i]] = i;
        }
        int res = 1;
        boolean[] visited = new boolean[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            int count = 1;
            visited[i] = true;
            int next = nums[i];
            while(!visited[next]) {
                visited[next] = true;
                next = nums[next];
                count++;
            }
            
            int pre = reverse[i];
            while(!visited[pre]) {
                visited[pre] = true;
                pre = reverse[pre];
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
        ArrayNesting test = new ArrayNesting();
        System.out.println(test.arrayNesting(nums));
    }
    
}
