import java.util.ArrayList;
import java.util.Arrays;

public class BraceExpansion {

    private int index;

    public String[] expand(String S) {
        ArrayList<ArrayList<Character>> l = new ArrayList<>();

        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '{'){
                ArrayList<Character> option = new ArrayList<>();
                int j = i+1;
                while(S.charAt(j) != '}'){
                    if(S.charAt(j) == ',') {
                        j++;
                        continue;
                    }
                    option.add(S.charAt(j++));
                }
                l.add(option);
                i = j;
            }else{
                ArrayList<Character> option = new ArrayList<>();
                option.add(S.charAt(i));
                l.add(option);
            }
        }

        int numOfRes = 1;
        for(ArrayList<Character> option : l) numOfRes *= option.size();
        String[] res = new String[numOfRes];

        dfs(new char[l.size()], 0, res, l);

        Arrays.sort(res);
        return res;
    }

    private void dfs(char[] chars, int idx, String[] res, ArrayList<ArrayList<Character>> l) {
        if(idx == l.size()) {
            res[index++] = String.valueOf(chars);
        }else{
            ArrayList<Character> option = l.get(idx);
            for(char c : option){
                chars[idx] = c;
                dfs(chars, idx+1, res, l);
            }
        }
    }

    public static void main(String[] args) {
        BraceExpansion test = new BraceExpansion();
        String[] res = test.expand("{a,b}c{d,e}f");
    }

}