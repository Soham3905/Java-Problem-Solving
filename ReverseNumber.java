public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse1(12345));
        System.out.println(reverse2(0,12345));
    }
    static int reverse1(int num){
        int result = 0;
        while(num>0){
            int rem = num % 10;
            result = result*10 + rem;
            num = num/10;
        }
        return result;
    }
    
    static int reverse2(int result,int num){
        if(num < 1){
          return result;
        }
        return reverse2(result*10+(num%10),num/10);
    }
}
