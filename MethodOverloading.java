
public class MethodOverloading {

    public static void main(String[] args) {
        Numbers num = new Numbers();
        num.sum(3, 4);
    }
}

class Numbers {

    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int a, int b, int c) {
        return a + b + c;
    }

    // public int sum(int b , int a){
    //     return a+b;
    // }                                error---------->>>>>>>>>
    public void sum(int a, String b) {

    }

    public void sum(String a, int b) {
    }

    //                                valid---------->>>>>>>>>>>
}
