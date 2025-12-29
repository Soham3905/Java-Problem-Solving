public class NoOfSetBits {
    public static void main(String[] args) {
        System.out.println(setBits(7));
    }
    static int setBits(int num){
        int count = 0;
        while(num>0){
            int rem = num & 1;
            if(rem==1){
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
}
