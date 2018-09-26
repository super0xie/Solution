import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortCharactersByFrequency {
    
    private class Char {
        int cha;
        int count;
        
        Char(int cha, int count){
            this.cha = cha;
            this.count = count;
        }
    }
    
    public String frequencySort(String s) {
        int[] counts = new int[256];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c <= 'z' && c >= 'a') counts[c]++;
            else counts[c]++;
        }
        
        Char[] chars = new Char[256];
        for(int i = 0; i < 256; i++) {
            chars[i] = new Char(i, counts[i]);
        }
        
        Arrays.sort(chars, (a,b)->{
            return b.count - a.count;
        });
        
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 256; i++) {
            
            int count = chars[i].count;
            while(count > 0) {
                sb.append((char)chars[i].cha);
                count--;
            }    
            
        }
        
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        SortCharactersByFrequency test = new SortCharactersByFrequency();
        System.out.println(test.frequencySort("Aabb"));
    }
    
}
