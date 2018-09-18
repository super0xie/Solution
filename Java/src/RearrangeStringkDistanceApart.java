import java.util.Arrays;

public class RearrangeStringkDistanceApart {
    
    private class CWithCount{
        char c;
        int count;
        CWithCount(char c){
            this.c = c;
            this.count = 0;
        }
    }
    
    public String rearrangeString(String s, int k) {
        if(k == 0) return s;
        CWithCount[] count = new CWithCount[26];
        for(int i = 0; i < 26; i++) {
            count[i] = new CWithCount((char) ('a'+i));
        }
        int max = (s.length() - 1) / k + 1;
        int maxLimit = s.length() - (max-1) * k;
        int maxCount = 0;
        for(char c : s.toCharArray()) {
            count[c - 'a'].count++;
            if(count[c-'a'].count > max) return "";
            if(count[c-'a'].count == max) maxCount++;
            if(maxCount > maxLimit) return "";
        }
        
        Arrays.sort(count, (a,b)->{ return b.count - a.count;});
        
        char[] res = new char[s.length()];
        int start = 0;
        int left = s.length();
        int idx = 0;
        while(left > 0) {
            while(count[idx].count == 0) idx++;
            while(res[start] != 0) start++;
            for(int i = start; i < s.length(); i = i + k) {
                res[i] = count[idx].c;
                count[idx].count--;
                left--;
                if(count[idx].count == 0) break;
            }
            
        }
        
        return String.valueOf(res);
    }
    
    public static void main(String[] args) {
        String s = "aabbcc";

        RearrangeStringkDistanceApart test = new RearrangeStringkDistanceApart();
        System.out.println(test.rearrangeString(s, 2));
        
        
    }
}
