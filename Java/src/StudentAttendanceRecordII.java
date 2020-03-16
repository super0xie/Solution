import java.util.Arrays;

public class StudentAttendanceRecordII {

    public int checkRecordOld(int n) {
        if(n == 1) return 3;
        if(n == 2) return 8;
        int mod = 1000000000 + 7;
        long pp0 = 1;//0
        long pp1 = 0;//1
        long ap1 = 1;//2
        long pa1 = 1;//3
        long lp0 = 1;//4
        long lp1 = 0;//5
        long pl0 = 1;//6
        long pl1 = 0;//7
        long al1 = 1;//8
        long la1 = 1;//9
        long ll0 = 1;//10
        long ll1 = 0;//11

        for(int i = 3; i <= n; i++){
            long newpp0 = (pp0 + lp0) % mod;
            long newpp1 = (pp1 + lp1 + ap1) % mod;
            long newap1 = (pa1 + la1) % mod;
            long newpa1 = (pp0 + lp0) % mod;
            long newlp0 = (ll0 + pl0) % mod;
            long newlp1 = (al1 + ll1 + pl1) % mod;
            long newpl0 = (pp0 + lp0) % mod;
            long newpl1 = (pp1 + ap1 + lp1) % mod;
            long newal1 = (pa1 + la1) % mod;
            long newla1 = (ll0 + pl0) % mod;
            long newll0 = pl0 % mod;
            long newll1 = (al1 + pl1) % mod;

            pp0 = newpp0;
            pp1 = newpp1;
            ap1 = newap1;
            pa1 = newpa1;
            lp0 = newlp0;
            lp1 = newlp1;
            pl0 = newpl0;
            pl1 = newpl1;
            al1 = newal1;
            la1 = newla1;
            ll0 = newll0;
            ll1 = newll1;
        }

        int res = (int)((pp0 + pp1 + ap1 + pa1 + lp0 + lp1 + pl0 + pl1 + al1 + la1 + ll0 + ll1) % mod);
        return res;
    }


    public int checkRecord(int n) {
        if(n == 1) return 3;
        if(n == 2) return 8;
        int mod = 1000000000 + 7;

        long[] dp = {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0};

        for(int i = 3; i <= n; i++){
            long[] aux = new long[12];
            aux[0] = (dp[0] + dp[4]) % mod;
            aux[1] = (dp[1] + dp[2] + dp[5]) % mod;
            aux[2] = (dp[3] + dp[9]) % mod;
            aux[3] = (dp[0] + dp[4]) % mod;
            aux[4] = (dp[6] + dp[10]) % mod;
            aux[5] = (dp[7] + dp[8] + dp[11]) % mod;
            aux[6] = (dp[0] + dp[4]) % mod;
            aux[7] = (dp[1] + dp[2] + dp[5]) % mod;
            aux[8] = (dp[3] + dp[9]) % mod;
            aux[9] = (dp[6] + dp[10]) % mod;
            aux[10] = dp[6];
            aux[11] = (dp[7] + dp[8]) % mod;
            
            dp = aux;
        }

        long res = 0;
        for(int i = 0; i < dp.length; i++){
            res += dp[i];
        }

        return (int)(res % mod);
    }

    public static void main(String[] args) {
        StudentAttendanceRecordII test = new StudentAttendanceRecordII();
        System.out.println(test.checkRecord(4));
    }

}