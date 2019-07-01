public class FindinMountainArray{

    class MountainArray{
        private int [] arr;
        private int count;

        MountainArray(int[] arr){
            this.arr = arr;
        }

        public int get(int i){
            count++;
            System.out.println("count: " + count);
            return arr[i];
        }

        public int length(){
            return arr.length;
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int i = 0;
        int j = mountainArr.length()-1;

        while(i < j){
            int mid = i + (j-i)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1)) i = mid+1;
            else j = mid;
        }
        
        int top = i;
        i = 0;
        j = top;

        while(i <= j){
            int mid = i + (j-i)/2;
            int val = mountainArr.get(mid);
            if(val == target) return mid;
            else if(val > target) j = mid-1;
            else i = mid + 1;
        }

        i = top;
        j = mountainArr.length()-1;

        while(i <= j){
            int mid = i + (j-i)/2;
            int val = mountainArr.get(mid);
            if(val == target) return mid;
            else if(val > target) i = mid + 1;
            else j = mid - 1;
        }

        return -1;
    }

    public int findInMountainArrayOld(int target, MountainArray mountainArr) {
        for(int i = 0; i < mountainArr.length(); i++){
            if(mountainArr.get(i) == target) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        FindinMountainArray test = new FindinMountainArray();
        int[] arr = {1,2,3,4,5,3,1};
        MountainArray mtn = test.new MountainArray(arr);
        System.out.println(test.findInMountainArray(2, mtn));
        
    }

}