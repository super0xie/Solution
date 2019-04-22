import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class AlienDictionary {

    private boolean containCycle = false;
    public String alienOrder(String[] words) {
        HashSet<Integer>[] graph = new HashSet[26];
        
        for(String str : words) {
            for(int i = 0; i < str.length(); i++) {
                if(graph[str.charAt(i)-'a'] == null) graph[str.charAt(i)-'a'] = new HashSet<>();
            }
        }
        
        buildGraph(words, 0, words.length-1, graph, 0);

        boolean[] hasParent = new boolean[26];
        
        for(int i = 0; i < 26; i++){
            if(graph[i] == null) continue;
            for(int j : graph[i]) hasParent[j] = true;
        }
        
        ArrayList<Integer> start = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(graph[i] != null && !hasParent[i]) {
                start.add(i);
            }
        }
        if(start.isEmpty()) return "";

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        boolean[] onStack = new boolean[26];
        for(int s : start) {
            dfs(graph, s, visited, onStack, stack);
        }
        
        for(int i = 0; i < 26; i++) {
            if(graph[i] != null && !visited[i]) return "";
        }
        if(containCycle) return "";
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append((char)('a' + stack.pop()));
        }
        return sb.toString();
    }

    private void buildGraph(String[] words, int start, int end, HashSet<Integer>[] graph, int idx){
        for(int i = start; i <= end; i++){
            for(int j = i+1; j <= end; j++){
                if(words[i].charAt(idx) != words[j].charAt(idx)) graph[words[i].charAt(idx)-'a'].add(words[j].charAt(idx)-'a');
            }
        }

        for(int i = start; i <= end; i++){
            if(idx == words[i].length()-1) continue;
            int j = i+1;
            while(j <= end && words[j].charAt(idx) == words[i].charAt(idx)) j++;
            if(j - i > 1){
                buildGraph(words, i, j-1, graph, idx+1);
            }

            i = j-1;
        }
    }

    private void dfs(HashSet<Integer>[] graph, int i, boolean[] visited, boolean[] onstack, Stack<Integer> stack){
        if(containCycle) return;
        visited[i] = true;
        onstack[i] = true;

        for(int next : graph[i]){
            if(onstack[next]) {
                containCycle = true;
                return;
            }
            if(!visited[next]) dfs(graph, next, visited, onstack, stack);
        }
        stack.push(i);
        onstack[i] = false;
    }

    public static void main(String[] args) {
        AlienDictionary test = new AlienDictionary();
        System.out.println(test.alienOrder(new String[]{"dvpzu","bq","lwp","akiljwjdu","vnkauhh","ogjgdsfk","tnkmxnj","uvwa","zfe","dvgghw","yeyruhev","xymbbvo","m","n"}));
    }

}