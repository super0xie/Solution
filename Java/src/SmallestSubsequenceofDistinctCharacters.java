
public class SmallestSubsequenceofDistinctCharacters {

    public String smallestSubsequence(String text) {
        StringBuilder sb = new StringBuilder();
        boolean[] added = new boolean[26];
        int[] last = new int[26];
        for(int i = 0; i < text.length(); i++) last[text.charAt(i)-'a'] = i;

        for(int i = 0; i < text.length(); i++){
            if(added[text.charAt(i)-'a']) continue;
            int j = i+1;
            if(last[text.charAt(i)-'a'] == i) j = text.length();
            
            for(; j < text.length(); j++){
            	if(added[text.charAt(j)-'a']) continue;
                if(text.charAt(j) < text.charAt(i) && last[text.charAt(i)-'a'] > j) break;
                if(text.charAt(j) > text.charAt(i) && last[text.charAt(j)-'a'] == j) j = text.length()-1;
            }

            if(j == text.length()) {
                sb.append(text.charAt(i));
                added[text.charAt(i)-'a'] = true;
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        SmallestSubsequenceofDistinctCharacters test = new SmallestSubsequenceofDistinctCharacters();
        System.out.println(test.smallestSubsequence("cdadabcc").equals("adbc"));
        System.out.println(test.smallestSubsequence("abcd").equals("abcd"));
        System.out.println(test.smallestSubsequence("ecbacba").equals("eacb"));
        System.out.println(test.smallestSubsequence("leetcode").equals("letcod"));
        System.out.println(test.smallestSubsequence("cbaacabcaaccaacababa").equals("abc"));
    }

}