import java.util.Arrays;

public class NumberOfDaysToLevelUpBadge{


    public static int[] expReqOnLevel = {
        0, 60, 80, 120, 240, 435, 
        690, 1090, 1715, 2765, 4340, 
        6700, 10000, 15000, 21000, 27440, 
        34500, 43000, 52500, 65500, 83500, 
        110000, 140000, 175000, 215000, 268000,
        345000, 454000, 588000, 760000, 1000000
    };

    public static int[] expPerDayOnLevel = {
        500, 500, 500, 500, 500, 500,
        1000, 1000, 1000, 1000, 1500,
        1500, 1500, 1500, 1500, 2000, 
        2000, 2000, 2000, 2000, 2500, 
        2500, 2500, 2500, 2500, 2700,
        3000, 3500, 4000, 4500, 5000
    };

    public static int[] daysReqForLevel = {
        0, 1, 1, 1, 1, 1, 
        2, 2, 3, 4, 5, 
        7, 9, 12, 16, 20, 
        24, 28, 33, 39, 48, 
        59, 71, 85, 101, 122, 
        150, 187, 225, 268, 321
    };

    public static void main(String[] args) {
        int level = 0;
        int exp = 0;

        for(int d = 1; d < 400; d++){
            
            int expGain = expPerDayOnLevel[level];
            int newExp = exp + expGain;
            int res = Arrays.binarySearch(expReqOnLevel, newExp);
            int newLevel = 0;
            if(res >= 0) newLevel = res;
            else newLevel = -res-2;

            if(expPerDayOnLevel[newLevel] != expGain){
                expGain = expPerDayOnLevel[newLevel];
                newExp = exp + expGain;
                res = Arrays.binarySearch(expReqOnLevel, newExp);
                newLevel = 0;
                if(res >= 0) newLevel = res;
                else newLevel = -res-2;
            }
            
            for(int i = level+1; i <= newLevel; i++){
                System.out.println(i + " " + d + ", ");
            }
            level = newLevel;
            exp = newExp;

        }


    }
}