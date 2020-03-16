public class KthSmallestNumberinMultiplicationTable{


    public int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = m * n;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            int count = getLessEqual(m, n, mid);
            if(count < k) lo = mid+1;
            else hi = mid;
        }

        return lo;
    }

    private int getLessEqual(int m, int n, int val) {
        int res = 0;
        int i = m, j = 1;
        while (i >= 1 && j <= n) {
            if (i * j > val) i--;
            else {
                res += i;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        KthSmallestNumberinMultiplicationTable test = new KthSmallestNumberinMultiplicationTable();
        System.out.println(test.findKthNumber(1, 3, 2));
    }

}