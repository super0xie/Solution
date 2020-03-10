
public class IncreasingDecreasingString {
    public String sortString(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        boolean cont = true;
        while(cont){
            cont = false;
            for(int i = 0; i < 26; i++){
                if(count[i] > 0){
                    sb.append((char)('a' + i));
                    count[i]--;
                    cont = true;
                }
            }

            for(int i = 25; i >= 0; i--){
                if(count[i] > 0){
                    sb.append((char)('a' + i));
                    count[i]--;
                    cont = true;
                }
            }
        }

        return sb.toString();
    }
}
