public class Concept {
    public static void main(String[] args) {
        fun(5);
    }
    static void fun(int num){
    if(num==0){
        return;
    }
    System.out.println(num);
    // Stack Overflow error---->>
    // fun(num--);
    // num-- vs --num    IMP concept...
    fun(--num);
    }
}
