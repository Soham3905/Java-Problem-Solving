
public class FinalKeyword {

    public static void main(String[] args) {
        // final int a;                 error.....always initialize while declaring
        final int a = 10;
        // you cannot change or modify value when it is primitive data type....
        System.out.println(a);
        final Student soham = new Student("Soham Dhakate");
        System.out.println(soham.name);
        soham.name = "Kunal";
        System.out.println(soham.name);
        // soham = new Student("Kunal");          error ----->>>>
    }
}

class Student {

    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

}
