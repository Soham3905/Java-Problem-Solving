
// public class SingletonExample {
//     public static void main(String[] args) {
//     Singleton obj = Singleton.getInstance();
//     Singleton obj1 = Singleton.getInstance();
//     Singleton obj2 = Singleton.getInstance();
//      // all 3 ref variables are pointing to just one object
//     }
// }
// class Singleton{
//     private Singleton(){

//     }
//    private static Singleton instance;
//    public static Singleton getInstance(){
//     // check whether 1 obj only is created or not
//     if (instance == null) {
//         instance = new Singleton();
//     }
//     return instance;
//    }
// }