
public class NestedInterfaces {

    public static void main(String[] args) {
        B num = new B();
        System.out.println(num.isOdd(6));
    }
}

class A {

    interface IsOdd {       // this should be public or default only.....

        boolean isOdd(int num);
    }
}

class B implements A.IsOdd {

    @Override
    public boolean isOdd(int num) {
        return (num & 1) != 0;
    }

}
