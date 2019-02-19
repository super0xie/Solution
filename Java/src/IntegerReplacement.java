import java.util.LinkedList;

public class IntegerReplacement {

    public int integerReplacementOld(int n) {
        int step = 0;
        while(n % 2 == 0 && n >= 2){
            n = n / 2;
            step++;
        }
        if(n == 1) return step;
        LinkedList<Long> l = new LinkedList<>();
        l.add((long)n);
        step++;
        while(!l.isEmpty()){
            LinkedList<Long> aux = new LinkedList<>();
            while(!l.isEmpty()){
                long p = l.poll();
                if(p % 2 == 0){
                    long res = p / 2;
                    if(res == 1) return step;
                    else {
                        aux.add(res);
                    }
                }else{
                    long res = p + 1;
                    if(res > 1) aux.add(res);
                    res = p-1;
                    if(res == 1) return step;
                    else if (res > 1) aux.add(res);
                }
            }

            l = aux;
            step++;
        }

        return -1;
    }

    public int integerReplacement(int n) {
        int step = 0;
        long num = n;
        while(num > 3){
            if(num % 2 == 0){
                num = num / 2;
            }else{
                if((num & 2) == 0) num--;
                else num++;
            }
            step++;
        }

        if(num == 3) return step+2;
        if(num == 2) return step+1;
        return step;
    }

    public static void main(String[] args) {
        IntegerReplacement test = new IntegerReplacement();
        System.out.print(test.integerReplacement(7));
    }
}