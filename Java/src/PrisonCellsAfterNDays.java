import java.util.HashMap;

public class PrisonCellsAfterNDays {
    
    public int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(cellToInt(cells), 0);
        
        for(int i = 1; i <= N; i++) {
            int[] aux = new int [8];
            for(int j = 1; j < 7; j++) {
                aux[j] = cells[j-1] == cells[j+1] ? 1 : 0 ;
            }
            cells = aux;
            
            int num = cellToInt(cells);
            if(map.containsKey(num)) {
                int start = map.get(num);
                int len = i - start;
                int tar = (N-start) % len + start;
                
                for(int key : map.keySet()) {
                    if(map.get(key) == tar) {
                        int[] res = intToCell(key);
                        return res;
                    }
                }
                
            }else {
                map.put(num, i);
            }
            
        }
        
        return cells;
    }
    
    private int cellToInt(int[] cells) {
        int res = 0;
        int n = 1;
        for(int i = 0; i < cells.length; i++) {
            if(cells[i] == 1) res += n;
            n = n * 2;
        }
        return res;
    }
    
    private int[] intToCell(int n) {
        int[] res = new int[8];
        for(int i = 0; i < res.length; i++) {
            res[i] = n%2;
            n = n >> 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
//        PrisonCellsAfterNDays test = new PrisonCellsAfterNDays();
//        int[] cells = {1,0,0,1,0,0,1,0};
//        int[] res = test.prisonAfterNDays(cells, 1000000000);
//        System.out.println("test");
//        System.out.println((~(1^0)&1));
    }
}
