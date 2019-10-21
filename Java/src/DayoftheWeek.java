
public class DayoftheWeek {
	
	static private String[] d = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	static private int [] days = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public String dayOfTheWeek(int day, int month, int year) {
        int offset = 4;
        for(int i = 1971; i < year; i++) {
        	boolean leap = (i % 100 == 0 && i % 400 == 0) || (i % 100 != 0 && i % 4 == 0);
        	offset += leap ? 366 : 365;
        }
        
        offset += dayOfYear(day, month, year);
        offset = offset % 7;
        
        return d[offset];
    }
	
	
	private int dayOfYear(int day, int mon, int year) {
        boolean leap = (year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
        if(leap) days[1] = 29;
        else days[1] = 28;
        
        int res = 0;
        for(int i = 0; i < mon-1; i++)
            res += days[i];

        res += day;
        return res;
    }
	
	public static void main(String[] args) {
		DayoftheWeek test = new DayoftheWeek();
		System.out.println(test.dayOfTheWeek(15, 8, 1993));
	}

}
