

public class Main {
    public static void main(String[] args) {
        Image image = new Image(1000, 1000);

        // Required shapes from usage spec
        Rectangle rectangle = new Rectangle(new Point(50, 50), new Point(300, 200));
        rectangle.draw(image);

        Triangle triangle = new Triangle(new Point(100, 100), new Point(900, 900), new Point(100, 900));
        triangle.draw(image);

        for (int i = 0; i < 10; i++) {
            Circle circle = Circle.random(image.getWidth(), image.getHeight());
            circle.draw(image);
        }


        for (int i = 0; i < 30; i++) {
            Pentagon pentagon = Pentagon.random(image.getWidth(), image.getHeight());
            pentagon.draw(image);
        }

        // // Bonus shapes
        // Line.random(image.getWidth(), image.getHeight()).draw(image);
        // Point.random(image.getWidth(), image.getHeight()).draw(image);
        // Cube.random(image.getWidth(), image.getHeight()).draw(image);
        // Pentagon.random(image.getWidth(), image.getHeight()).draw(image);

        image.save("image.png");
    }
}
