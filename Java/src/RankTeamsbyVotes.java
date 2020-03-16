import java.util.ArrayList;
import java.util.Collections;

public class RankTeamsbyVotes {
    
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] count = new int[26][n];
        
        for(int i = 0; i < votes.length; i++) {
            for(int j = 0; j < n; j++) {
                count[votes[i].charAt(j)-'A'][j]++;
            }
        }
        
        ArrayList<Integer> l = new ArrayList<>();
        
        for(int i = 0; i < 26; i++) {
            int j = 0;
            for(; j < n; j++) {
                if(count[i][j] != 0) break;
            }
            if(j != n) l.add(i);
        }
        
        Collections.sort(l, (a, b)->{
            for(int i = 0; i < n; i++) {
                if(count[a][i] != count[b][i]) {
                    return count[b][i] - count[a][i];
                }
            }
            return a - b;
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < l.size(); i++) {
            sb.append((char)('A' + l.get(i)));
        }
        return sb.toString();
        
    }
    
    public static void main(String[] args) {
        RankTeamsbyVotes test = new RankTeamsbyVotes();
        String[] votes = {"BCA","CAB","CBA","ABC","ACB","BAC"};
        System.out.println(test.rankTeams(votes));
        
    }
    
}
