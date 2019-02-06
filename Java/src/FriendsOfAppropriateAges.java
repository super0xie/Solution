import java.util.Arrays;

public class FriendsOfAppropriateAges {
    
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        for(int i = 0; i < ages.length; i++) {
            int lb = 0;
            double limit = ages[i]*0.5+7;
            if(limit == Math.ceil(limit)) {
                lb = (int) (limit+1);
            }else {
                lb = (int) Math.ceil(limit);
            }
            
            if(lb > ages[i]) continue;
            
            int startIdx = bs(ages, lb);
            int num = i - startIdx;
            
            int j = i;
            while(j < ages.length && ages[j] == ages[i]) j++;
            int count = j-i;
            i = j-1;
            
            
            res += num * count + count * (count-1);
        }
        
        return res;
    }
    
    private int bs(int[] a, int t) {
        int i = 0;
        int j = a.length-1;
        while(i < j) {
            int mid = i + (j-i)/2;
            if(a[mid] < t) i = mid+1;
            else if(a[mid] >= t) j = mid;
        }
        return i;
    }
    
    public static void main(String[] args) {
        int[] ages = {101,56,69,48,30};
        FriendsOfAppropriateAges test = new FriendsOfAppropriateAges();
        System.out.println(test.numFriendRequests(ages));
    }
    
}
