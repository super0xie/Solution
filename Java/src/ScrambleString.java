public class ScrambleString{
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        return helper(s1, 0, s1.length()-1, s2, 0, s2.length()-1);
    }

    private boolean helper(String s1, int l1, int r1, String s2, int l2, int r2){
        if(l1 == r1){
            if(s1.charAt(l1) == s2.charAt(l2)) return true;
            else return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = l1; i <= r1; i++){
            count1[s1.charAt(i)-'a']++;
        }
        for(int i = l2; i <= r2; i++){
            count2[s2.charAt(i)-'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(count1[i] != count2[i]) return false;
        }

        for(int i = 0; i < r1-l1; i++){
            if(helper(s1, l1, l1+i, s2, l2, l2+i) && helper(s1, l1+i+1, r1, s2, l2+i+1, r2)) return true;
            if(helper(s1, l1, l1+i, s2, r2-i, r2) && helper(s1, l1+i+1, r1, s2, l2, r2-i-1)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        ScrambleString test = new ScrambleString();
        System.out.println(test.isScramble("abcde", "caebd"));
    }
}