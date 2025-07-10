package demo2;


public class Test {
    public static void drawShapes(){
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();

        Shape[] shapes = {cycle,rect,cycle,rect,flower};

        for(Shape shape : shapes){
            shape.draw();
        }
    }
    public static void draw(Shape shape){
        shape.draw();
    }

    public static void main(String[] args) {
        drawShapes();
//        draw(new Cycle());
//        draw(new Rect());
//        draw(new Flower());
//        draw(new Shape());
    }
}
