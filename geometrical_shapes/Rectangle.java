import java.awt.Color;
import java.util.Random;

public class Rectangle implements Drawable {
    private final Point p1;
    private final Point p2;
    private final Color color;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = Color.WHITE;
    }

    public Rectangle(Point p1, Point p2, Color color) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = color;
    }

    public static Rectangle random(int width, int height) {
        Random rng = new Random();
        Color color = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
        return new Rectangle(Point.random(width, height), Point.random(width, height), color);
    }

    public Point getP1() { return p1; }
    public Point getP2() { return p2; }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void draw(Displayable displayable) {
        // Top edge
        new Line(new Point(p1.x, p1.y), new Point(p2.x, p1.y), color).draw(displayable);
        // Right edge
        new Line(new Point(p2.x, p1.y), new Point(p2.x, p2.y), color).draw(displayable);
        // Bottom edge
        new Line(new Point(p2.x, p2.y), new Point(p1.x, p2.y), color).draw(displayable);
        // Left edge
        new Line(new Point(p1.x, p2.y), new Point(p1.x, p1.y), color).draw(displayable);
    }
}
