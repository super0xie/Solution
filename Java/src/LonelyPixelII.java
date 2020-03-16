

public class LonelyPixelII{
    
    public int findBlackPixel(char[][] picture, int N) {
        int m = picture.length;
        int n = picture[0].length;

        int[] cr = new int[m];
        int[] cl = new int[n];
        String[] sr = new String[m];

        for(int i = 0; i < m; i++){
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 'B') count++;
                sb.append(picture[i][j]);
            }
            cr[i] = count;
            sr[i] = sb.toString();
        }

        for(int j = 0; j < n; j++){
            int count = 0;
            String str = null;
            int i = 0;
            for(; i < m; i++){
                if(picture[i][j] == 'B'){
                    String cur = sr[i];
                    if(str == null) str = cur;
                    else{
                        if(!str.equals(cur)) {
                            cl[j] = -1;
                            break;
                        }
                    }
                    count++;
                }
            }
            if(i == m) cl[j] = count;
        }
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 'B' && cr[i] == cl[j] && cr[i] == N) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LonelyPixelII test = new LonelyPixelII();
        char[][] picture = {{'W','B','W','B','B','W'},{'W','B','W','B','B','W'},{'W','B','W','B','B','W'},{'B','W','B','W','W','B'}};
        System.out.print(test.findBlackPixel(picture, 3));
    }
}