import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import apple.laf.JRSUIConstants.State;

public class SwapAdjacentinLRString {

    

    public boolean canTransformBFS(String start, String end) {
        if(start.equals(end)) return true;
        int[] countStart = new int[3];
        int[] countEnd = new int[3];

        for(int i = 0; i < start.length(); i++){
            if(start.charAt(i) == 'L') countStart[0]++;
            else if(start.charAt(i) == 'R') countStart[1]++;
            else if(start.charAt(i) == 'X') countStart[2]++;

            if(end.charAt(i) == 'L') countEnd[0]++;
            else if(end.charAt(i) == 'R') countEnd[1]++;
            else if(end.charAt(i) == 'X') countEnd[2]++;
        }

        for(int i = 0; i < 3; i++){
            if(countStart[i] != countEnd[i]) return false;
        }

        LinkedList<String> queue = new LinkedList<>();
        queue.add(start);
        HashSet<String> visited = new HashSet<>();
        visited.add(start);
        while(!queue.isEmpty()){
            String polled = queue.poll();
            for(String str : helper(polled)){
                if(str.equals(end)) return true;
                if(!visited.contains(str)){
                    queue.add(str);
                    visited.add(str);
                }
            }
        }
        return false;
    }

    private List<String> helper(String str){
        char[] chars = str.toCharArray();
        List<String> res = new ArrayList<>();

        for(int i = 0; i < chars.length-1; i++){
            char c = chars[i];
            char n = chars[i+1];
            if(c == 'R' && n == 'X'){
                chars[i] = 'X';
                chars[i+1] = 'R';
                res.add(String.valueOf(chars));
            } else if(c == 'X' && n == 'L'){
                chars[i] = 'L';
                chars[i+1] = 'X';
                res.add(String.valueOf(chars));
            }
            chars[i] = c;
            chars[i+1] = n;
        }
        return res;

    }

    public boolean canTransform(String start, String end) {
        if(start.equals(end)) return true;

        int i = 0;
        int j = 0;

        while(i < start.length() && j < end.length()){
            while(i < start.length() && start.charAt(i) == 'X') i++;
            while(j < end.length() && end.charAt(j) == 'X') j++;
            if(i == start.length() || j == start.length()){
                if(i == j) return true;
                else return false;
            }
            

            if(start.charAt(i) != end.charAt(j)) return false;
            if(start.charAt(i) == 'L' && i < j) return false;
            if(start.charAt(i) == 'R' && i > j) return false;

            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        SwapAdjacentinLRString test = new SwapAdjacentinLRString();
        System.out.print(test.canTransformBFS("XXXXXXRXXLXRXXXXXRXXXXXRXXXXXLXXXLXLXXRXXXXXLXXXXX", "XXRXXXXLXXRXXXRXXXXRXXXXXLXXLXXXXXXLXXXXRXXXXLXXXX"));
    }

}