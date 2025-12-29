public class FibonacciNumber {
    public static void main(String[] args) {
       int ans = fibonacciNumber(7);
       System.out.println(ans);
    }
    static int fibonacciNumber(int n){
        if(n<2){
            return n;
        }
        return fibonacciNumber(n-1) + fibonacciNumber(n-2);
    }
}
