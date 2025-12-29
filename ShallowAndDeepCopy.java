
import java.util.Arrays;

public class ShallowAndDeepCopy {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Soham";
        s1.rollNo = 44;
        s1.marks[0] = 88;
        s1.marks[1] = 90;
        s1.marks[2] = 99;
        Student s2 = new Student(s1);
        System.out.println(s2.name);
        System.out.println(s2.rollNo);
        System.out.println(Arrays.toString(s2.marks));
        s1.marks[0] = 100;
        System.out.println(Arrays.toString(s2.marks));
        System.out.println(Arrays.toString(s1.marks));
    }
}

class Student {

    String name;
    int rollNo;
    int[] marks;

    public Student() {
        this.marks = new int[3];
    }

    // //Shallow Copy..
    // public Student(Student other) {
    //     this.name = other.name;
    //     this.rollNo = other.rollNo;
    //     this.marks = other.marks;
    // }
    // Deep Copy...
    public Student(Student o) {
        this.marks = new int[3];
        this.name = o.name;
        this.rollNo = o.rollNo;
        System.arraycopy(o.marks, 0, this.marks, 0, marks.length);
        // for (int i = 0; i < marks.length; i++) {
        //     this.marks[i] = o.marks[i];
        // }
    }
}
