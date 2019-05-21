
public class StudentAttendanceRecordI {
	public boolean checkRecordOld(String s) {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'A') {
				++count;
				if(count > 1) return false;
			}else if(s.charAt(i) == 'L') {
				if(i > 1 && s.charAt(i-1) == 'L' && s.charAt(i-2) == 'L') return false;
			}
		}
        return true;
	}
	
	public boolean checkRecord(String s) {
		int countA = 0;

		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == 'A') {
				countA++;
				if(countA > 1) return false;
			}else if(s.charAt(i) == 'L' && i > 1 && s.charAt(i-1) == 'L' && s.charAt(i-2) == 'L') return false;
		}
		
        return true;
    }
}
