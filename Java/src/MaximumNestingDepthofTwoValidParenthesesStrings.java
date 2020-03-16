public class MaximumNestingDepthofTwoValidParenthesesStrings{

    public int[] maxDepthAfterSplit(String seq) {
        int counta = 0;
        int countb = 0;
        int[] res = new int[seq.length()];
        for(int i = 0; i < seq.length(); i++){
            if(seq.charAt(i) == '('){
                if(counta <= countb) {
                    counta++;
                    res[i] = 0;
                } else {
                    countb++;
                    res[i] = 1;
                }
            }else{
                if(counta >= countb){
                    res[i] = 0;
                    counta--;
                }else{
                    res[i] = 1;
                    countb--;
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        MaximumNestingDepthofTwoValidParenthesesStrings test = new MaximumNestingDepthofTwoValidParenthesesStrings();
        int[] res = test.maxDepthAfterSplit("()(())()");
        for(int i : res) System.out.print(i + ", ");
    }

}