import java.awt.Color;
import java.util.Random;

public class Circle implements Drawable {
    private final Point center;
    private final int radius;
    private final Color color;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
        this.color = Color.WHITE;
    }

    public Circle(Point center, int radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    public static Circle random(int width, int height) {
        Random rng = new Random();
        Point center = Point.random(width, height);
        Point edge   = Point.random(width, height);
        int dx = edge.x - center.x;
        int dy = edge.y - center.y;
        int radius = (int) Math.sqrt(dx * dx + dy * dy);
        Color color = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
        return new Circle(center, radius, color);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
public void draw(Displayable displayable) {
    for (int x = center.x - radius; x <= center.x + radius; x++) {

        int dx = x - center.x;

        int y1 = center.y + (int) Math.sqrt(radius * radius - dx * dx);
        int y2 = center.y - (int) Math.sqrt(radius * radius - dx * dx);

        displayable.display(x, y1, getColor());
        displayable.display(x, y2, getColor());
    }
}

}
