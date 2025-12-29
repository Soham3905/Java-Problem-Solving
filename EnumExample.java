
public class EnumExample {

    public static void main(String[] args) {
        Week week;
        week = Week.Monday;
        System.out.println(week);
        System.out.println(week.ordinal());
        System.out.println(Week.valueOf("Monday"));
        for (Week day : Week.values()) {
            System.out.println(day);
        }
        week.Hello();
    }

    enum Week implements A {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;

        // these are enum constants..
        // every single one here is public, static and final...
        // since its final you can't create child enums...
        // The type is where they are declared i.e type is Week..
        private Week() {
            System.out.println("Constructor is called.." + this);
        }
        // This Constructor is not public or protected ... it is only private or default..
        // Why?? because we do not want to create new objects
        // this is not enum concepts that's why..
        // internally : public static final Week Monday = new Week();

        @Override
        public void Hello() {
            System.out.println("hellaaa");
        }
    ;
}

}
interface A {

    void Hello();
}
