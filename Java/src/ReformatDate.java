import java.util.HashMap;

public class ReformatDate {
	private static HashMap<String, String> months;
	private static HashMap<String, String> days;
	
	static {
		
		String[] d = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st"};
		String[] m = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		
		months = new HashMap<>();
		days = new HashMap<>();
		
		for(int i = 0; i < d.length; i++) {
			days.put(d[i], String.format("%02d", i+1));
		}
		
		for(int i = 0; i < m.length; i++) {
			months.put(m[i], String.format("%02d", i+1));
		}
	}
	
	public String reformatDate(String date) {
        String[] strs = date.split(" ");
        return strs[2] + "-" + months.get(strs[1])+ "-" + days.get(strs[0]); 
    }
}
