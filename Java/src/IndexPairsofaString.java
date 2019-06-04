import java.util.ArrayList;
import java.util.HashSet;

public class IndexPairsofaString {

    public int[][] indexPairs(String text, String[] words) {
        ArrayList<int[]> l = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for(String str : words) set.add(str);

        for(int i = 0; i < text.length(); i++){
            for(int j = i; j < text.length(); j++){
                String sub = text.substring(i, j+1);
                if(set.contains(sub)) l.add(new int[] {i, j});
            }
        }

        int[][] res = new int[l.size()][2];
        for(int i = 0; i < l.size(); i++) res[i] = l.get(i);
        return res;
    }

    public static void main(String[] args) {
        IndexPairsofaString test = new IndexPairsofaString();
        int[][] res = test.indexPairs("ababa", new String[] {"aba","ab"});
        for(int[] p : res){
            System.out.println(p[0] + ", " + p[1]);
        }

    }

}