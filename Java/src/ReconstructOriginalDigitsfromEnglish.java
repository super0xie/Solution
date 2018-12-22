
public class ReconstructOriginalDigitsfromEnglish {
    
    public String originalDigits(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        
        int[] nums = new int[10];
        nums[0] = count['z'-'a'];
        count['e'-'a'] -= nums[0];
        count['r'-'a'] -= nums[0];
        count['o'-'a'] -= nums[0];
        
        nums[6] = count['x'-'a'];
        count['s'-'a'] -= nums[6];
        count['i'-'a'] -= nums[6];
        
        nums[2] = count['w'-'a'];
        count['t'-'a'] -= nums[2];
        count['o'-'a'] -= nums[2];
        
        nums[4] = count['u'-'a'];
        count['f'-'a'] -= nums[4];
        count['o'-'a'] -= nums[4];
        count['r'-'a'] -= nums[4];
        
        nums[3] = count['r'-'a'];
        count['t'-'a'] -= nums[3];
        count['h'-'a'] -= nums[3];
        count['e'-'a'] -= nums[3];
        count['e'-'a'] -= nums[3];
        
        nums[1] = count['o'-'a'];
        count['n'-'a'] -= nums[1];
        count['e'-'a'] -= nums[1];
        
        nums[5] = count['f'-'a'];
        count['i'-'a'] -= nums[5];
        count['v'-'a'] -= nums[5];
        count['e'-'a'] -= nums[5];
        
        nums[7] = count['s'-'a'];
        count['e'-'a'] -= nums[7];
        count['v'-'a'] -= nums[7];
        count['e'-'a'] -= nums[7];
        count['e'-'a'] -= nums[7];
        
        nums[8] = count['g'-'a'];
        count['e'-'a'] -= nums[8];
        count['i'-'a'] -= nums[8];
        count['h'-'a'] -= nums[8];
        count['t'-'a'] -= nums[8];
        
        nums[9] = count['i'-'a'];
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < nums[i]; j++) {
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        ReconstructOriginalDigitsfromEnglish test = new ReconstructOriginalDigitsfromEnglish();
        System.out.println(test.originalDigits("one"));
    }

}
