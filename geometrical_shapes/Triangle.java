import java.awt.Color;
import java.util.Random;

public class Triangle implements Drawable {
    private final Point p1;
    private final Point p2;
    private final Point p3;
    private final Color color;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.color = Color.WHITE;
    }

    public Triangle(Point p1, Point p2, Point p3, Color color) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.color = color;
    }

    public static Triangle random(int width, int height) {
        Random rng = new Random();
        Color color = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
        return new Triangle(
            Point.random(width, height),
            Point.random(width, height),
            Point.random(width, height),
            color
        );
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void draw(Displayable displayable) {
        new Line(p1, p2, color).draw(displayable);
        new Line(p2, p3, color).draw(displayable);
        new Line(p3, p1, color).draw(displayable);
    }
}
