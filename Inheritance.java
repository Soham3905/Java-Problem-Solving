
public class Inheritance {

    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box(box1);
        System.out.println(box1.l + box1.h + box1.w);
        System.out.println(box2.l + box2.h + box2.w);
        BoxWeight box3 = new BoxWeight();
        System.out.println(box3.h + " " + box3.weight);
        BoxWeight box4 = new BoxWeight();
        System.out.println(box4.h + " " + box4.weight + " " + box4.l + " " + box4.w);
        // Box box5 = new Box();
        // System.out.println(box5.weight);  error------------->>>>>>
        Box box6 = new BoxWeight(2, 3, 4, 5);
        System.out.println(box6.w);
        // System.out.println(box6.weight);  error------------>>>>>>>>>>
        // there are many variables in both parent and child classes
        // you are given access to variables that are in the ref type i.e. BoxWeight
        // hence, you should have access to weight variable
        // parent class has no iead about weight variable
        // this also means, that the ones you are trying to access should be initialised
        // but here, when the obj itself is of type parent class, how will you call the constructor of child class
        // how will you call/initialize weight variable from parent class....as parent class has no iead about weight variable
        // this is why error
        // BoxWeight box7 = new Box();  error------------>>>>>>>>>>
        BoxPrice box10 = new BoxPrice();
        System.out.println(box10.cost);
        BoxPrice box8 = new BoxPrice(3, 4, 5, 6, 78);
        System.out.println(box8.h + " " + box8.weight + " " + box8.l + " " + box8.w + " " + box8.cost);
        BoxPrice box9 = new BoxPrice(box8);
        System.out.println(box9.h + " " + box9.weight + " " + box9.l + " " + box9.w + " " + box9.cost);
    }
}

class Box {

    double l;
    double w;
    double h;

    public Box() {
        this.l = -1;
        this.w = -1;
        this.h = -1;
    }

    //cube
    public Box(double side) {
        super(); // it will call the constructor of object class........
        this.l = side;
        this.w = side;
        this.h = side;
    }

    public Box(double l, double w, double h) {
        this.l = l;
        this.w = w;
        this.h = h;
    }

    public Box(Box old) {
        this.l = old.l;
        this.w = old.w;
        this.h = old.h;
    }
}

class BoxWeight extends Box {

    double weight;

    public BoxWeight() {
        this.weight = -1;
    }

    public BoxWeight(double weight) {
        this.weight = weight;
    }

    public BoxWeight(BoxWeight other) {
        super(other);
        this.weight = other.weight;
    }

    public BoxWeight(double weight, double l, double w, double h) {
        // used to initialise values present in parent class
        super(l, w, h);  // what is this? call the parent class constructor

        this.weight = weight;
        // super(l, w, h);   error------------------>>>>>>>> child class cares about parent class thats why he is like parent class you initialize first...
    }
}

class BoxPrice extends BoxWeight {

    double cost;

    BoxPrice() {
        super();
        this.cost = -1;
    }

    BoxPrice(BoxPrice other) {
        super(other);
        this.cost = other.cost;
    }

    public BoxPrice(double l, double h, double w, double weight, double cost) {
        super(l, h, w, weight);
        this.cost = cost;
    }

    // public BoxPrice(double side, double weight, double cost) {
    //     super(side, weight);
    //     this.cost = cost;
    // }
}
