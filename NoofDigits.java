public class NoofDigits {
    public static void main(String[] args) {
        System.out.println((int)(Math.log10(765)+1));
       int num1 = 66755;
       int base1 = 10;
       int num2 = 10;
       int base2 = 2;
      System.out.println((int)((Math.log(num1)/Math.log(base1))+1));
      System.out.println((int)((Math.log(num2)/Math.log(base2))+1));
    }
}
