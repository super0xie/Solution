import java.util.HashMap;

public class RemoveBoxes {

    public int removeBoxes(int[] boxes) {
        HashMap<String, Integer> memo = new HashMap<>();
        int res = dfs(boxes, memo);
        return res;
    }

    private int dfs(int[] box, HashMap<String, Integer> memo){
        recode(box);
        String encode = encode(box);
        if(memo.containsKey(encode)) return memo.get(encode);


        int res = 0;
        for(int i = 0; i < box.length; i++) {
            // System.arraycopy(src, srcPos, dest, destPos, length);
            int j = i+1;
            while(j < box.length && box[j] == box[i]) j++;
            int count = j-i;

            if(box.length == count) {
                res = count * count;
                break;
            }

            int[] subBox = new int[box.length-count];
            int idx = 0;
            for(int k = 0; k < box.length; k++){
                if(k >= i && k < j) continue;
                subBox[idx++] = box[k];
            }

            res = Math.max(res, count * count + dfs(subBox, memo));
        }

        memo.put(encode, res);
        return res;
    }

    private void recode(int[] box){
        HashMap<Integer, Integer> map = new HashMap<>();
        int code = 1;
        for(int i = 0; i < box.length; i++){
            if(!map.containsKey(box[i])){
                map.put(box[i], code);
                box[i] = code;
                code++;
            }else{
                box[i] = map.get(box[i]);
            }
        }
    }

    private String encode(int[] box){
        StringBuilder sb = new StringBuilder();
        for(int i : box){
            sb.append(i);
            sb.append(',');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] boxes = {3, 8, 8, 5, 5, 3, 9, 2, 4, 4, 6, 5, 8, 4, 8, 6, 9, 6, 2, 8, 6, 4, 1, 9, 5, 3, 10, 5, 3, 3, 9, 8, 8, 6, 5, 3, 7, 4, 9, 6, 3, 9, 4, 3, 5, 10, 7, 6, 10, 7};
        RemoveBoxes test = new RemoveBoxes();
        System.out.println(test.removeBoxes(boxes));
    }

}