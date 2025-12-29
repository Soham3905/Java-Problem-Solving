public class SearchinString {
    public static void main(String[] args) {
        String str = "Soham";
        char target = 'S';
        System.out.println(searchinstring(str,target));
    }
    static boolean searchinstring(String str,char target){
        if(str.length() == 0){
            return false;
        }
        for(char i = 0; i < str.length(); i++){
           if(str.trim().charAt(i)==target){
            return true;
           }
        }
        return false;
    }
}
