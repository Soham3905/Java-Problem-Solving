class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int product = 1;
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            product *= rem;
            sum += rem;
            num /= 10;
        }
        if(n%(product+sum)==0){
            return true;
        }else{
            return false;
        }
    }
}