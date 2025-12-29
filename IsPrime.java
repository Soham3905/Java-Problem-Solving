public class IsPrime {
    public static void main(String[] args) {
        // System.out.println(isprime(2));
        for(int i = 0 ; i <= 10 ; i++){
            if(isprime(i)==true){
                System.out.print(i + " ");
            }
        }  
    }
    static boolean isprime(int num){
        if(num<=1){
            return false;
        }
        for(int i=2; i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}