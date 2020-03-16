public class LetterTilePossibilities{
    private int res;
    private int [] f = {1, 1, 2, 6, 24, 120, 720, 5040};
    public int numTilePossibilities(String tiles) {
        int n = 0;
        int[] number = new int[26];
        for(int i = 0; i < tiles.length(); i++){
            if(number[tiles.charAt(i)-'A'] == 0) n++;
            number[tiles.charAt(i)-'A']++;
        }

        int[] count = new int[n];
        int idx = 0;
        for(int i = 0; i < 26; i++)
            if(number[i] > 0) count[idx++] = number[i];

        dfs(0, 0, count, new int[n]);
        return res;
    }

    private void dfs(int idx, int sum, int[] count, int[] n){
        if(idx == count.length){
            if(sum > 0){
                int r = f[sum];
                for(int i = 0; i < count.length; i++) r /= f[n[i]];
                res += r;
            }
            return;
        }

        for(int i = 0; i <= count[idx]; i++){
            n[idx] = i;
            dfs(idx+1, sum+i, count, n);
        }
    }

    public static void main(String[] args) {
        LetterTilePossibilities test = new LetterTilePossibilities();
        System.out.println(test.numTilePossibilities("AAABBC"));
    }

}