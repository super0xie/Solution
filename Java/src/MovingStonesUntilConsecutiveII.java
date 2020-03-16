import java.util.Arrays;

public class MovingStonesUntilConsecutiveII{

    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;

        int max = Math.max(stones[n-2]-stones[0]-n+2, stones[n-1]-stones[1]-n+2);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < stones.length; i++){
            for(int j = i; j < stones.length; j++){
                if(stones[j]-stones[i]+1 > n) continue;
                if(i == 0 && j == stones.length-2 && stones[j] != stones[stones.length-1] - 1 && cont(stones, i, j)) min = Math.min(min, 2);
                else if(j == stones.length-1 && i == 1 && stones[0] != stones[1]-1 && cont(stones, i, j)) min = Math.min(min, 2);
                else{
                    min = Math.min(min, n-(j-i+1));
                }
            }
        }

        return new int[] {min, max};
    }

    private boolean cont(int[] s, int l, int r){
        for(int i = l; i < r; i++){
            if(s[i] + 1 != s[i+1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MovingStonesUntilConsecutiveII test = new MovingStonesUntilConsecutiveII();
        int[] stones = {872744873,407745415,920265824,78944478,811582493,159387457,73610667,679739704,934249520,484866256,806947986,515330462,635589397,454065412,623990088,702300851,680116257,956576624,627580519,862260761,535974224,610386154,147996010,995188988,697589181,774334991,975600945,349769864,439419437,759685564,468162177,245675630,618666885,534580630,600325762,986524516,161373519,515248771,925900095,557803426,201601082,982652719,295010345,293049701,338675863,649482376,24971924,518429551,298902749,525841475,207922745,786121605,278541349,171822421,3627955,941822192,327185070,282505850,375060226,263830781,375519322,394162353,159428107,698554237,386248496,401174973,713865493,151618885,43008984,135449254,903873357,926871727,700962,415801910,241575747,913603096,921875839,515695485,801132907,210025056,991525254,776633422,319846045,510206317,433255537,964734911,487539862,958994600,267736477,640426157,348772981,813284734,165097998,328011830,107586878,920355296,822257896,74535996,508877402,55905987,912504311,238858217,101604373,866717345,889976872,236460070,243264031,676579831,222034958,233732642,746488332,719718853,630787678,511639505,672351188,959300625,169663603,191716458,681437267,415179364,252436682,427793128,335408586,585450571,894449031};
        int[] res = test.numMovesStonesII(stones);
        System.out.println(res[0] + ", " + res[1]);
    }

}