public class DayoftheYear{

    static private int [] days = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        String[] strs = date.split("-");
        int year = Integer.parseInt(strs[0]);
        boolean leap = (year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
        if(leap) days[1] = 29;
        else days[1] = 28;
        int mon = Integer.parseInt(strs[1]);
        int res = 0;
        for(int i = 0; i < mon-1; i++)
            res += days[i];

        int day = Integer.parseInt(strs[2]);
        res += day;

        return res;
    }

}