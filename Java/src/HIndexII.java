public class HIndexII{

    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;

        for(int i = 0; i < citations.length; i++){
            if(citations.length-i <= citations[i]) return citations[i];
        }
        return 0;
    }

}