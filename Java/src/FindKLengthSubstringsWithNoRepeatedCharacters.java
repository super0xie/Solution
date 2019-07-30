public class FindKLengthSubstringsWithNoRepeatedCharacters{

    public int numKLenSubstrNoRepeats(String S, int K) {
        int[] count = new int[26];
        if(S.length() < K) return 0;
        int res = 1;

        for(int i = 0; i < Math.min(S.length(), K); i++){
            count[S.charAt(i)-'a']++;
            if(count[S.charAt(i)-'a'] > 1) res = 0;
        }

        for(int i = K; i < S.length(); i++){
            count[S.charAt(i-K)-'a']--;
            count[S.charAt(i)-'a']++;
            int j = 0;
            for(; j < count.length; j++){
                if(count[j] > 1) break;
            }

            if(j == count.length) res++;
            
        }

        return res;
    }

    public static void main(String[] args) {
        FindKLengthSubstringsWithNoRepeatedCharacters test = new FindKLengthSubstringsWithNoRepeatedCharacters();
        System.out.println(test.numKLenSubstrNoRepeats("havefunonleetcode", 5));
    }

}