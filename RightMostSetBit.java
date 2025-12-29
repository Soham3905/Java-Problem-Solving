public class RightMostSetBit {
    public static void main(String[] args) {
        System.out.println(setBits(4));
    }
    static int setBits(int num){
        int count = 1;
        while(num>0){
            int rem = num & 1;
            if(rem==1){
                break;
            }
            count++;
            num = num >> 1;
        }
        return count;
    }
}
