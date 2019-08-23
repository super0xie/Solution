public class AlphabetBoardPath{

    int[][] map = {
        {0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4},
        {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4},
        {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4},
        {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4},
        {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4},
        {5, 0}};

    public String alphabetBoardPath(String target) {
        char cur = 'a';
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < target.length(); i++){
            if(target.charAt(i) == cur){
                sb.append("!");
            }else{
                int[] loc = map[cur-'a'];
                int[] tar = map[target.charAt(i) - 'a'];
                int v = tar[0] - loc[0];
                int h = tar[1] - loc[1];

                if(cur == 'z'){
                    if(v > 0) for(int j = 0; j < v; j++) sb.append("D");
                    else if(v < 0) for(int j = 0; j < -v; j++) sb.append("U");
                    if(h > 0) for(int j = 0; j < h; j++) sb.append("R");
                    else if(h < 0) for(int j = 0; j < -h; j++) sb.append("L");
                }else{
                    if(h > 0) for(int j = 0; j < h; j++) sb.append("R");
                    else if(h < 0) for(int j = 0; j < -h; j++) sb.append("L");
                    if(v > 0) for(int j = 0; j < v; j++) sb.append("D");
                    else if(v < 0) for(int j = 0; j < -v; j++) sb.append("U");
                }

                sb.append("!");
                cur = target.charAt(i);
            }
        }

        return sb.toString();
    }

}