import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels {
    
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for(int i = 0; i < S.length(); i++) {
            last[S.charAt(i)-'a'] = i;
        }
        
        List<Integer> res = new ArrayList<>();
        int end = 0;
        int pre = 0;
        for(int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i)-'a']);
            if(i == end) {
                res.add(i-pre+1);
                pre = i+1;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        PartitionLabels test = new PartitionLabels();
        test.partitionLabels("ababcbacadefegdehijhklij");
    }
    
}
