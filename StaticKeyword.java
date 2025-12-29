
public class StaticKeyword {

    public static void main(String[] args) {
        Human soham = new Human(18, 500000, false, "Soham");
        Human kunal = new Human(19, 500000, false, "Kunal");
        Human.message();
        // soham.message(); //same...........
        System.out.println(soham.name);
        System.out.println(kunal.name);
        System.out.println(soham.age);
        System.out.println(soham.salary);
        System.out.println(soham.married);
        // System.out.println(soham.population);
        System.out.println(Human.population);
        // System.out.println(soham.population);  same....
        // System.out.println(kunal.population);  same....
        fun();
        // fun2(); ------->>>>>>> error
        StaticKeyword obj1 = new StaticKeyword();
        obj1.fun2();
        // in order to run non static methos we have to create an object and run that methods via objects...
    }

    // this is not dependent on the objects...
    static void fun() {
        // greeting();  // you cant use this because it requires an instance
        // but the function you are using it in does not depend on instances

        // you cannot access non static stuff without referencing their instances in
        // a static context
        StaticKeyword obj = new StaticKeyword();
        obj.greeting();
    }

    //  we know that something which is not static, belongs to an object
    // this is dependent on the objects...
    void greeting() {
        // fun();   works---->>>
        System.out.println("Hello");
    }

    void fun2() {
        greeting();
    }

}

class Human {

    int age;
    int salary;
    boolean married;
    String name;
    static long population;

    static void message() {
        System.out.println("Hello world");
//        System.out.println(this.age); // cant use this over here
    }

    public Human(int age, int salary, boolean married, String name) {
        this.age = age;
        this.salary = salary;
        this.married = married;
        this.name = name;
        Human.population += 1;  // ----->>>>>
        // this.population += 1;  same....
    }

}
