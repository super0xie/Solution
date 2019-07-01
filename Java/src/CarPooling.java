public class CarPooling{

    public boolean carPooling(int[][] trips, int capacity) {
        int[] start = new int[1001];
        int[] end = new int[1001];

        for(int[] trip : trips){
            start[trip[1]] += trip[0];
            end[trip[2]] += trip[0];
        }

        for(int i = 0; i <= 1000; i++){
            capacity += end[i];
            capacity -= start[i];
            if(capacity < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,5,7}};
        CarPooling test = new CarPooling();
        System.out.println(test.carPooling(trips, 3));
    }

}