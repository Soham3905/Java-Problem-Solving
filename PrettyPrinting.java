
import java.util.ArrayList;
import java.util.Arrays;

public class PrettyPrinting {
    public static void main(String[] args) {
        float a = 453.1234f;
        float b = 453.1274f;
        float c = 453.125f;
       System.out.printf("Formatted number is %.2f", a);
       System.out.println();
       System.out.printf("Formatted number is %.2f", b);
       System.out.println();
       System.out.printf("Formatted number is %.2f", c);
       System.out.println();
       System.out.println(Math.PI);
       System.out.println(Math.TAU);
       System.out.println(Math.E);
       System.out.printf("Pie : %.3f",Math.PI);
       System.out.println();
       System.out.printf("Hello, My name is %s and I am %s","Soham","cool");
       System.out.println();

//        There are many format specifiers we can use. Here are some common ones:

// %c - Character
// %d - Decimal number (base 10)
// %e - Exponential floating-point number
// %f - Floating-point number
// %i - Integer (base 10)
// %o - Octal number (base 8)
// %s - String
// %u - Unsigned decimal (integer) number
// %x - Hexadecimal number (base 16)
// %t - Date/time
// %n - Newline

        System.out.println('e' + 'f');
        System.out.println("e" + "f");
        System.out.println('e' + 3);
        System.out.println((char)('e' + 3));
        System.out.println("e"+1);
        // this is same as after a few steps: "e" + "1"
        // integer will be converted to Integer that will call toString()
        System.out.println("Soham " + new ArrayList<>());

        
        for(int i = 0; i < 26 ; i++){
            System.out.println((char)('a'+i));
        }

        String series = "";
        for(int i = 0; i < 26 ; i++){
            char ch = (char)('a' + i);
            series += ch;
            // here new object is created each time.....this means 26 new objects are created ...like a,ab,abc,abcd,abcde,abcde,......abcdeffghijkl..z....therefor huge loss of memory....
        // System.out.println(series);  ...run this to see how memory is losing..
    } 
    System.out.println(series);


    // String Builder Class
    // append method to avoid this memory loss..
    // no new object is created...changes are made in the same object..
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < 26 ; i++){
        char ch = (char)('a' + i);
        builder.append(ch);
    }
    System.out.println(builder);
    System.out.println(builder.reverse());


    String name = "Soham Dhakate";
    System.out.println(Arrays.toString(name.toCharArray()));
    System.out.println(name.toLowerCase());
    System.out.println(name.toUpperCase());
    System.out.println(name.indexOf('o'));
    System.out.println("    Soham    ".strip());
    String naam = "Soham Dhakate Hello World";
    System.out.println(Arrays.toString(name.split(" ")));
    System.out.println(Arrays.toString(naam.split(" ")));
}
}
