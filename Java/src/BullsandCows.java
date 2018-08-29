
public class BullsandCows {
    
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        
        int [] count = new int[10];
        
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) bulls++;
            else count[secret.charAt(i) - '0']++;
        }
        
        for(int i = 0; i < secret.length(); i++) {
            
            if(secret.charAt(i) != guess.charAt(i)) {
                if(count[guess.charAt(i) - '0'] > 0) {
                    cows++;
                    count[guess.charAt(i) - '0']--;
                }
            }
            
        }
        String result = "" + bulls + "A" + cows + "B";
        return result;
    }
    
}
