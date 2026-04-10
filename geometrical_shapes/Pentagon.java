import java.awt.Color;
import java.util.Random;

public class Pentagon implements Drawable {
    private final Point center;
    private final int radius;
    private final Color color;

    public Pentagon(Point center, int radius) {
        this.center = center;
        this.radius = radius;
        this.color = Color.WHITE;
    }

    public Pentagon(Point center, int radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    public static Pentagon random(int width, int height) {
        Random rng = new Random();
        Point center = Point.random(width, height);
        int radius = rng.nextInt(180) + 20; // 20..200
        Color color = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
        return new Pentagon(center, radius, color);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void draw(Displayable displayable) {
        int numSides = 5;
        Point[] points = new Point[numSides];

        for (int i = 0; i < numSides; i++) {
            double angle = i * (2.0 * Math.PI / numSides) - Math.PI / 2.0;
            int x = center.x + (int) (radius * Math.cos(angle));
            int y = center.y + (int) (radius * Math.sin(angle));
            points[i] = new Point(x, y);
        }

        for (int i = 0; i < numSides; i++) {
            new Line(points[i], points[(i + 1) % numSides], color).draw(displayable);
        }
    }
}
