
public class FirstBadVersion extends VersionControl {
    
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            boolean badMid = isBadVersion(mid);
            
            if((mid > 1 && badMid && !isBadVersion(mid-1))
                    || mid==1 && badMid) return mid;
            
            else if(badMid) end = mid-1;
            else start = mid+1;
        }
        
        return -1;
    }
    

}
