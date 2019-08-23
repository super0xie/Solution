public class FindWordsThatCanBeFormedbyCharacters{






    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for(int i = 0; i < chars.length(); i++) count[chars.charAt(i) - 'a']++;
        int res = 0;
        for(String str : words){
            int[] nums = new int[26];
            for(int i = 0; i < str.length(); i++) nums[str.charAt(i)-'a']++;
            int i = 0;
            for(; i < 26; i++) if(nums[i] > count[i]) break;
            if(i == 26) res+=str.length();
        }
        return res;
    }


    

}