
public class Polymorphism {

    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Square square = new Square();
        Triangle triangle = new Triangle();
        shape.area();
        circle.area();
        square.area();
        triangle.area();
        Shapes square1 = new Square();
        square1.area();
    }
}

class Shapes {

    void area() {
        System.out.println("I am in Shapes..");
    }
}

class Circle extends Shapes {
    // this will run when obj of Circle is created
    // hence it is overriding the parent method

    @Override  // this is called annotation
    void area() {
        System.out.println("I am in Circle..");
    }
}

class Square extends Shapes {

    @Override
    void area() {
        System.out.println("I am in Square..");
    }
}

class Triangle extends Shapes {

    @Override
    void area() {
        System.out.println("I am in Triangle..");
    }
}
