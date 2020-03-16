import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandomO1Duplicatesallowed {

    private ArrayList<Integer> l;
    private int count;
    private HashMap<Integer, ArrayList<Integer>> map;
    private Random r;


    /** Initialize your data structure here. */
    public void RandomizedCollection() {
        count = 0;
        l = new ArrayList<>();
        map = new HashMap<>();
        r = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        l.add(val);
        count++;
        if(map.containsKey(val)){
            map.get(val).add(l.size()-1);
            return false;
        }else{
            ArrayList<Integer> indice = new ArrayList<>();
            indice.add(l.size()-1);
            map.put(val, indice);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            ArrayList<Integer> indice = map.get(val);
            int idx = indice.remove(indice.size()-1);
            l.set(idx, null);
            if(indice.isEmpty()){
                map.remove(val);
            }
            count--;

            if(count != 0 && count * 4 < l.size())
                rebuild();
            
            return true;
        }else{
            return false;
        }
    }

    private void rebuild(){
        ArrayList<Integer> aux = new ArrayList<>();
        map = new HashMap<>();
        for(int i = 0; i < l.size(); i++){
            if(l.get(i) != null){
                int val = l.get(i);
                aux.add(val);
                if(map.containsKey(val)){
                    map.get(val).add(aux.size()-1);
                }else{
                    ArrayList<Integer> indice = new ArrayList<>();
                    indice.add(aux.size()-1);
                    map.put(val, indice);
                }
            }
        }
        l = aux;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Integer res = null;
        while(res == null){
            int idx = r.nextInt(l.size());
            res = l.get(idx);
        }
        return res;
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomO1Duplicatesallowed test = new InsertDeleteGetRandomO1Duplicatesallowed();
        test.RandomizedCollection();
        test.insert(1);
        test.insert(1);
        test.insert(2);
        test.remove(1);
        for(int i = 0; i < 100; i++)
            System.out.println(test.getRandom());
    }
}