
// import java.text.DecimalFormat;
// import java.util.Arrays;
// import java.util.Random;

// public class StringBufferExample {
//     public static void main(String[] args) {
        
//         // constructor 1:
//         StringBuffer sb = new StringBuffer();
//         System.out.println(sb.capacity());

//         // constructor 2:
//         StringBuffer sb2 = new StringBuffer("Soham Dhakate");

//         // constructor 3:
//         // To increase capacity...
//         StringBuffer sb3 = new StringBuffer(30);
//         System.out.println(sb3.capacity());


//         sb.append("IronMan");
//         sb.append(" is Nice!!!");

//         sb.insert(4, " Steel ");
//         sb.replace(5, 10, "Zinc");
//         sb.delete(5, 9);
//         String str = sb.toString();
//         System.out.println(str);

//         Random random = new Random();
//         System.out.println(random.nextFloat());
//         System.out.println(random.nextBoolean());

//         int n = 20;
//         String name = RandomString.generate(n);
//         System.out.println(name);

//         // remove whitespaces

//         String sentence = "Hi h   hjh  hjkso  siowi     w ";
//         System.out.println(sentence);
//         System.out.println(sentence.replaceAll("\\s", ""));

//          // split

//     String arr = "Kunal,Apoorv,Rahul,Snehal";
//     String[] names = arr.split(",");
//     System.out.println(Arrays.toString(names));

//     // rounding off
//     DecimalFormat df = new DecimalFormat("00.0000");
//     System.out.println(df.format(7.29));


//     }
// }

// class RandomString{
//     static String generate(int size){
//        StringBuffer sb = new StringBuffer(size);
//        Random random = new Random();
//        for (int i = 0; i < size; i++) {
//            int randomchar = 97 + (int)(random.nextFloat() * 26);
//            sb.append((char)randomchar);
//        }
//        return sb.toString();
//     }
// }