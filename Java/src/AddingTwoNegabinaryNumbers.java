import java.util.ArrayList;

public class AddingTwoNegabinaryNumbers{

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length-1;
        int j = arr2.length-1;
        int carry = 0;
        ArrayList<Integer> l = new ArrayList<>();
        while(i >= 0 || j >= 0){
            int res = 0;
            if(i >= 0 && j >= 0) res = arr1[i] + arr2[j] + carry;
            else if(i >= 0) res = arr1[i] + carry;
            else if(j >= 0) res = arr2[j] + carry;
            
            if(res == 0) {
                l.add(0);
                carry = 0;
            }else if(res == 1){
                l.add(1);
                carry = 0;
            }else if(res == 2){
                l.add(0);
                carry = -1;
            }else if(res == -1){
                l.add(1);
                carry = 1;
            }else if(res == 3){
                l.add(1);
                carry = -1;
            }
            i--;
            j--;
        }

        if(carry == -1){
            l.add(1);
            l.add(1);
        }else if(carry == 1){
            l.add(1);
        }

        while(l.get(l.size()-1) == 0 && l.size() > 1) l.remove(l.size()-1);

        int[] res = new int[l.size()];
        for(i = 0; i < l.size(); i++){
            res[l.size()-1-i] = l.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        AddingTwoNegabinaryNumbers test = new AddingTwoNegabinaryNumbers();
        int[] arr1 = {1, 0, 1};
        int[] arr2 = {1, 0, 1};
        int[] res = test.addNegabinary(arr1, arr2);
        for(int i : res){
            System.out.print(i + ", ");
        }
    }

}