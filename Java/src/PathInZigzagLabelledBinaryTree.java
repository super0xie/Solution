import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    int[] starts = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576};
    public List<Integer> pathInZigZagTree(int label) {
        int ret = Arrays.binarySearch(starts, label);
        if(ret < 0)
            ret = -ret - 1 - 1;
        
        int[] res = new int[ret+1];
        int idx = res.length-1;
        int start = starts[idx];
        int diff = label - start;
        int width = starts[idx];
        int i = 0;
        if(idx % 2 == 0)
            i = diff;
        else
            i = width - diff -1;

        while(idx >= 0){
            if(idx % 2 == 0){
                label = starts[idx] + i;
            }else{
                label = starts[idx+1] - i - 1;
            }
            
            res[idx] = label;
            idx--;
            i = i / 2;
        }

        List<Integer> result = new ArrayList<>();
        for(i = 0; i < res.length; i++){
            result.add(res[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        PathInZigzagLabelledBinaryTree test = new PathInZigzagLabelledBinaryTree();
        List<Integer> res = test.pathInZigZagTree(14);
        for(int i : res) System.out.print(i + ", ");
    }
    
}