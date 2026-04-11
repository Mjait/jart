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
        int steps = (int) (2.0 * Math.PI * radius);
        if (steps < 1) steps = 1;

        for (int i = 0; i < steps; i++) {
            double theta = ((double) i / steps) * 2.0 * Math.PI;
            int x = center.x + (int) (radius * Math.cos(theta));
            int y = center.y + (int) (radius * Math.sin(theta));
            displayable.display(x, y, getColor());
        }
    }
}
