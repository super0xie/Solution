import java.util.Arrays;

public class MaximumofAbsoluteValueExpression{

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] aux1 = new int[n];
        int[] aux2 = new int[n];
        int[] aux3 = new int[n];
        int[] aux4 = new int[n];
        int[] aux5 = new int[n];
        int[] aux6 = new int[n];
        int[] aux7 = new int[n];
        int[] aux8 = new int[n];

        for(int i = 0; i < n; i++){
            aux1[i] = arr1[i] + arr2[i] + i;
            aux2[i] = arr1[i] + arr2[i] - i;
            aux3[i] = arr1[i] - arr2[i] + i;
            aux4[i] = arr1[i] - arr2[i] - i;
            aux5[i] = -arr1[i] + arr2[i] + i;
            aux6[i] = -arr1[i] + arr2[i] - i;
            aux7[i] = -arr1[i] - arr2[i] + i;
            aux8[i] = -arr1[i] - arr2[i] - i;
        }

        int res = Integer.MIN_VALUE;

        res = Math.max(res, helper(aux1));
        res = Math.max(res, helper(aux2));
        res = Math.max(res, helper(aux3));
        res = Math.max(res, helper(aux4));
        res = Math.max(res, helper(aux5));
        res = Math.max(res, helper(aux6));
        res = Math.max(res, helper(aux7));
        res = Math.max(res, helper(aux8));


        return res;
    }

    private int helper(int[] aux){
        int max = Arrays.stream(aux).max().getAsInt();
        int min = Arrays.stream(aux).min().getAsInt();
        return max-min;
    }

}