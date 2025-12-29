public class SumofNnaturalnumbers{
    public static void main(String[] args) {
       System.out.println(sum(100));
    }
    static int sum(int num){
        int ans=0;
        for (int i = 1; i<= num ; i++){
            ans = ans + i;
        }
        return ans;
    }
}