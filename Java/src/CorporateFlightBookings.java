public class CorporateFlightBookings{

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        int[] aux = new int[n];

        for(int[] booking : bookings){
            aux[booking[0]-1] += booking[2];
            if(booking[1] != n) aux[booking[1]] -= booking[2];
        }

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += aux[i];
            res[i] = sum;
        }

        return res;
    }

    public static void main(String[] args) {
        CorporateFlightBookings test = new CorporateFlightBookings();
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int[] res = test.corpFlightBookings(bookings, 5);
        for(int i : res) System.out.print(i + ", ");
    }

}