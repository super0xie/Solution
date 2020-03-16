
public class MaximumScoreWordsFormedbyLetters {
	
	private int res;
	
	public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letter = new int[26];
        for(char c : letters) {
        	letter[c-'a']++;
        }
        
        dfs(0, 0, words, score, letter);
        return res;
    }
	
	private void dfs(int i, int sum, String[] words, int[] score, int[] letter) {
		
		if(i == words.length) {
			res = Math.max(res, sum);
		}else {
			dfs(i+1, sum, words, score, letter);
			
			int j = 0;
			int s = 0;
			for(; j < words[i].length(); j++) {
				if(letter[words[i].charAt(j)-'a'] > 0) {
					s += score[words[i].charAt(j)-'a'];
					letter[words[i].charAt(j)-'a']--;
				}else {
					for(int k = j-1; k >= 0; k--) {
						letter[words[i].charAt(k)-'a']++;
					}
					break;
				}
			}
			
			if(j == words[i].length()) {
				dfs(i+1, sum+s, words, score, letter);
				for(int k = words[i].length()-1; k >= 0; k--) {
					letter[words[i].charAt(k)-'a']++;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		MaximumScoreWordsFormedbyLetters test = new MaximumScoreWordsFormedbyLetters();
		String[] words = {"leetcode"};
		char[] letters = {'l','e','t','c','o','d'};
		int[] score = {0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0};
		
		System.out.println(test.maxScoreWords(words, letters, score));
	}
	
}
