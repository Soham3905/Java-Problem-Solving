
import java.util.Arrays;

public class OOPSIntro {

    public static void main(String[] args) {
        Student[] students = new Student[10];
        Student student1 = new Student();
        Student student2;
        student2 = new Student();
        System.out.println(Arrays.toString(students));
        student1.rollNo = 44;
        student1.name = "Soham";
        student1.marks = (float) 97.40;
        System.out.println(student1.rollNo);
        System.out.println(student1.name);
        System.out.println(student1.marks);
        System.out.println(student2);
        System.out.println(student2.name);
        System.out.println(student2.rollNo);
        System.out.println(student2.marks);
        student1.greeting();
        student2.greeting();
        student1.changeName("Patri");
        student1.greeting();
        Student student3 = new Student(46, "Sahil", 89.78f);
        System.out.println(student3.name);
        Student student4 = new Student(student3);
        System.out.println(student4.name);
        System.out.println(student4.rollNo);
        System.out.println(student4.marks);
        Student student5 = new Student();
        System.out.println(student5.name);
        System.out.println(student5.rollNo);
        System.out.println(student5.marks);
        Student student6 = new Student();
        Student student7 = student6;
        student6.name = "Sujal";
        System.out.println(student7.name);
    }

    // create a class
    // for every single student
}

class Student {

    int rollNo;
    String name;
    float marks = 90f;
    // we need a way to add the values of the above
    // properties object by object

    // we need one word to access every object
    Student() {
        // this.rollNo = 45;
        // this.name = "Kunal";
        // this.marks = 87.56f;

        // this is how you call a constructor from another constructor
        // internally: new Student (48, "Harsh", 78.90f);
        this(48, "Harsh", 78.90f);
    }

    void greeting() {
        System.out.println("Hello, My name is " + name);
        System.out.println("Hello, My name is " + this.name);
    }

    void changeName(String name) {
        this.name = name;
    }

    Student(int rollNo, String name, float marks) {
        this.rollNo = rollNo;
        this.marks = marks;
        this.name = name;
    }

    Student(Student other) {
        this.rollNo = other.rollNo;
        this.name = other.name;
        this.marks = other.marks;
    }

}
