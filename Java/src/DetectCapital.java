public class DetectCapital {
	public boolean detectCapitalUse(String word) {
		boolean allCap = true;
		int count = 0;
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if(c >= 'a' && c <= 'z'){
				allCap = false;
				if(count > 1) return false;
			}else{
				if(!allCap) return false;
				count++;
			}
		}
		return true;
    }
}
