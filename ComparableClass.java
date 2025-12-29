
import java.util.Arrays;

public class ComparableClass {

    public static void main(String[] args) {
        Student soham = new Student(44, 87);
        Student kunal = new Student(46, 90);
        Student harsh = new Student(47, 92);
        Student sahil = new Student(48, 93);
        Student darshan = new Student(49, 99);
        Student nickel = new Student(50, 98);
        if (soham.compareTo(kunal) < 0) {
            System.out.println(kunal.compareTo(soham));
            System.out.println("Kunal has more marks..");
        }
        Student[] list = { soham, kunal, harsh, sahil, darshan, nickel };
        Arrays.sort(list); /// compare to necessary hain ..vrna compiler confuse ho jayega ki marks yaa
                           /// roll no. ke basis pe compare krna hain...
        System.out.println(Arrays.toString(list));

        /// either we can do this..
        // Arrays.sort(list,new Comparator<Student>(){
        // @Override
        // public int compare(Student o1, Student o2) {
        // int diff = o1.marks - o2.marks;
        // return diff;
        // };
        // });
        // System.out.println(Arrays.toString(list));

        // we can use lambda expression alsoo...
        // Arrays.sort(list, (Student o1, Student o2) -> {
        // int diff = o1.marks - o2.marks;
        // return diff;
        // });
        // System.out.println(Arrays.toString(list));
    }
}

class Student implements Comparable<Student> {

    int rollNo;
    int marks;

    public Student(int rollNo, int marks) {
        this.marks = marks;
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return rollNo + " " + marks;
    }

    ;

    @Override
    public int compareTo(Student o) {
        System.out.println("comparing");
        int diff = this.marks - o.marks; //// agar this.rollNo raha toh roll no. ke hisab se sort hoga...vrna this.marks
                                         //// raha toh marks ke hisab se sort hoga
        return diff;
    };
}
