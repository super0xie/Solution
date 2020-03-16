import java.util.HashSet;
import java.util.LinkedList;

public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> visited = new HashSet<>();

        LinkedList<String> q = new LinkedList<>();
        q.add(start);
        visited.add(start);

        int count = 1;

        while(!q.isEmpty()){
            LinkedList<String> aux = new LinkedList<>();
            while(!q.isEmpty()){
                String polled = q.poll();
                for(String str : bank){
                    if(diff(str, polled)==1){
                        if(str.equals(end)) return count;
                        if(!visited.contains(str)){
                            visited.add(str);
                            aux.add(str);
                        }
                    }
                }
            }

            q = aux;
            count++;
        }
        return -1;
    }

    private int diff(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) count++;
        }
        return count;
    }

}