import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int D) {
        int l = 1;
        int r = 25000000;

        while(l < r){
            int mid = l + (r-l)/2;
            if(valid(weights, D, mid)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }

        return l;
    }

    private boolean valid(int[] weights, int D, int cap){
        int sum = 0;

        for(int i = 0; i < weights.length; i++) {
            if(weights[i] > cap) return false;
            if(sum + weights[i] > cap) {
                if(D == 1) return false;
                sum = weights[i];
                D--;
            } else {
                sum += weights[i];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays test = new CapacityToShipPackagesWithinDDays();
        // int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int[] weights = new int[50000];
        Arrays.fill(weights, 500);
        System.out.println(test.shipWithinDays(weights, 1));
    }

}