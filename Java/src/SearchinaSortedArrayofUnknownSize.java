
public class SearchinaSortedArrayofUnknownSize {
    
    interface ArrayReader {
        int get(int i);
    }
    
    public int search(ArrayReader reader, int target) {
        int i = 0;
        int j = Integer.MAX_VALUE;
        while(i <= j) {
            int mid = i + (j-i)/2;
            int v = reader.get(mid);
            if(v == target) return mid;
            if(v < target) i = mid+1;
            else j = mid-1;
        }
        return -1;
    }
}
