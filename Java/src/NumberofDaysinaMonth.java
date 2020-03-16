public class NumberofDaysinaMonth{

    static private int [] days = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int numberOfDays(int Y, int M) {
        if(M == 2){
            boolean leap = false;
            if((Y % 100 == 0 && Y % 400 == 0) || (Y % 100 != 0 && Y % 4 == 0)) leap = true;
            if(leap) return 29;
            else return 28;
        }else{
            return days[M-1];
        }
    }

    public static void main(String[] args) {
        NumberofDaysinaMonth test = new NumberofDaysinaMonth();
        System.out.println(test.numberOfDays(1900, 2));
    }

}