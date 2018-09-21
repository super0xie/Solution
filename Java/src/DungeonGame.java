
public class DungeonGame {
    
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        
        dp[dungeon.length-1][dungeon[0].length-1] = Math.min(0, dungeon[dungeon.length-1][dungeon[0].length-1]);
        
        for(int i = dungeon.length-2; i >= 0; i--) {
            dp[i][dungeon[0].length-1] = Math.min(dungeon[i][dungeon[0].length-1] + dp[i+1][dungeon[0].length-1], 0);
        }
        
        for(int j = dungeon[0].length-2; j >= 0; j--) {
            dp[dungeon.length-1][j] = Math.min(dp[dungeon.length-1][j+1] + dungeon[dungeon.length-1][j], 0);
        }
        
        for(int i = dungeon.length-2; i >= 0; i--) {
            for(int j = dungeon[0].length-2; j >= 0; j--) {
                dp[i][j] = Math.min(Math.max(dp[i+1][j], dp[i][j+1]) + dungeon[i][j], 0);
            }
        }
        return 1-dp[0][0];
    }
    
    public static void main(String[] args) {
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        DungeonGame test = new DungeonGame();
        test.calculateMinimumHP(dungeon);
    }
    
}
