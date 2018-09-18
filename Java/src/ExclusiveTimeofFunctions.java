import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFunctions {
    
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<Integer>();
        int cur = -1;
        int curTime = -1;
        int[] res = new int[n];
        for(String log : logs) {
            String[] strs = log.split(":");
            int id = Integer.parseInt(strs[0]);
            boolean start = strs[1].equals("start");
            int time = Integer.parseInt(strs[2]);
            
            if(cur == -1) {
                //first start
                cur = id;
                curTime = time;
            }else {
                if(start) {
                    stack.push(cur);
                    res[cur] += time - curTime;
                    cur = id;
                    curTime = time;
                }else {
                    res[cur] += time - curTime + 1;
                    if(!stack.isEmpty())
                        cur = stack.pop();
                    curTime = time+1;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        ExclusiveTimeofFunctions test = new ExclusiveTimeofFunctions();
        List<String> logs = Arrays.asList("0:start:0",
                "1:start:2",
                "1:end:5",
                "0:end:6");
        
        test.exclusiveTime(2, logs);
        
    }

}
