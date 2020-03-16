public class PrimePalindrome{

    public int primePalindrome(int N) {
        int n = N;
        int len = 0;
        while(n > 0){
            len++;
            n = n / 10;
        }

        for(int i = len; i <= 9; i++){
            int h = (i+1)/2;
            int start, end;
            if(i == len){
                n = N;
                for(int j = 0; j < len-h; j++) n = n / 10;
                start = n;
            }else{
                start = 1;
                for(int j = 0; j < h-1; j++) start = start * 10;
            }

            end = 9;
            for(int j = 0; j < h-1; j++){
                end = end * 10;
                end += 9;
            }

            for(int j = start; j <= end; j++){
                n = j;
                int aux = j;
                if(i % 2 == 1) aux = j / 10;
                while(aux > 0){
                    n *= 10;
                    n += aux % 10;
                    aux = aux / 10;
                }

                if(n >= N && isPrime(n)) {
                    return n;
                }
            }
        }

        return -1;
    }

    

    private boolean isPrime(int num) {
        if(num < 2) return false;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		return true;
    }
    
    public static void main(String[] args) {
        PrimePalindrome test = new PrimePalindrome();
        System.out.print(test.primePalindrome(85709140));
    }

}