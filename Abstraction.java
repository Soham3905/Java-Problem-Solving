public class Abstraction {

    public static void main(String[] args) {
        Son son = new Son(25);
        son.career();
        son.partner();
        Parent daughter = new Daughter(18); // -------------->>>>>>>>>>
        daughter.partner();
        daughter.career();
        // Parent mom = new Parent(45); error------------>>>>>> cannot create object of
        // the Abstract Classes...
        Parent.hello();
        son.normal();
        System.out.println(son.age);
        System.out.println(son.value);
    }
}

abstract class Parent {

    int age = 18;
    final int value;

    abstract void career();

    abstract void partner();

    static void hello() {
        System.out.println("Hello");
    }

    void normal() {
        System.out.println("This is a Normal Method.");
    }

    Parent(int age) {
        this.age = age;
        this.value = 4309867;
    }
}

class Son extends Parent {

    public Son(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("I am going to be a Doctor");
    }

    @Override
    void partner() {
        System.out.println("I love Thor");
    }

}

class Daughter extends Parent {

    public Daughter(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("I am going to be a Coder");
    }

    @Override
    void partner() {
        System.out.println("I love Iron Man");
    }

}
