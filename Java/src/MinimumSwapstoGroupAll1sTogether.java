public class MinimumSwapstoGroupAll1sTogether{

    public int minSwaps(int[] data) {
        int len = 0;
        for(int i = 0; i < data.length; i++) {
            if(data[i] == 1) len++;
        }

        int count = 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < data.length; i++){
            if(data[i] == 1) count++;
            if(i >= len){
                if(data[i-len] == 1) count--;
            }

            if(i >= len-1){
                res = Math.min(res, len-count);
            }
        }

        return res;
    }
}