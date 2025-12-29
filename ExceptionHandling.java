
public class ExceptionHandling {

    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        // try {
        // int c=a/b;
        // System.out.println(c);
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // }finally{
        // System.out.println("This will always execute..");
        // }
        try {
            divide(a, b);
            System.out.println(divide(a, b));
            String name = "Soham";
            if (name.equals("Soham")) {
                throw new MyExceptioon("Write another name..");
            }
        } catch (MyExceptioon | ArithmeticException e) {
            System.out.println(e.getMessage());
        } // }catch(Exception e){
        //     System.out.println("Normal Exception..");  // we can use nested try-catch block alsooo....
        finally {
            System.out.println("This will always execute..");
        }
    }

    static int divide(int a, int b) throws ArithmeticException {   // throw keyword ka use krne pr yaha throws keyword ka bhi use krna necessary hain..
        if (b == 0) {
            throw new ArithmeticException("Please do not divide by 0");  // throw means you are throwing an exception...throws is basically use to declare exceptions...
        }
        return a / b;
    }
}

class MyExceptioon extends Exception {

    public MyExceptioon(String message) {
        super(message);
    }

}
