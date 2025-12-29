public class BasicRecurrsion {
    public static void main(String[] args) {
        ntoone(5);
        onetoN(5);
    }
    static void ntoone(int num){
       if(num==0){
        return;
       }
       System.out.print(num + " ");
        ntoone(num-1);
    }

    static void onetoN(int num){
        if(num==0){
            return;
        }
        onetoN(num-1);
        System.out.print(num + " ");
    }
}
