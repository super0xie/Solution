import java.util.Arrays;

public class TaskScheduler {
    
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c : tasks) {
            count[c - 'A']++;
        }

        int left = tasks.length;
        int cur = 0;
        int[] lastIndex = new int [26];
        Arrays.fill(lastIndex, -n-1);
        
        while(left > 0) {
            int max = 0;
            int c = 0;
            for(int i = 0; i < 26; i++) {
                if(count[i] > max && cur - lastIndex[i] > n) {
                    max = count[i];
                    c = i;
                }
            }
            
            if(max != 0) {
                count[c]--;
                left--;
                lastIndex[c] = cur;
                cur++;
                
            }else {
                cur++;
            }
        }
        
        return cur;
    }
    
    public static void main(String[] args) {
        TaskScheduler test = new TaskScheduler();
        char[] tasks = {'A','A','A','B','B','B'};
        test.leastInterval(tasks, 2);
    }

}
