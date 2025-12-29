public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 100;
        boolean[] primes = new boolean[n+1];
        sieve(n, primes);
        // System.out.println(primes[3]); 
    }
    static void sieve(int n , boolean[] primes){
        for(int i = 2 ; i <= Math.sqrt(n) ; i++){
            if(!primes[i]) // boolean value pahale false ans deta hain...boolean value default false rahati hain..
             for(int j = 2*i ; j <= n ; j+=i){
                primes[j] = true;
             }
        }
        for(int i = 2 ; i <= n ; i++){
            if(primes[i]==false){
                System.out.print(i + " ");
            }
        }
    }
}
