import java.awt.Color;
import java.util.Random;

public class Line implements Drawable {
    private final Point p1;
    private final Point p2;
    private final Color color;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = Color.WHITE;
    }

    public Line(Point p1, Point p2, Color color) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = color;
    }

    public static Line random(int width, int height) {
        Random rng = new Random();
        Color color = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
        return new Line(Point.random(width, height), Point.random(width, height), color);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void draw(Displayable displayable) {
        int x0 = p1.x, y0 = p1.y;
        int x1 = p2.x, y1 = p2.y;

        int dx = Math.abs(x1 - x0);
        int dy = -Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;
        int error = dx + dy;

        while (true) {
            displayable.display(x0, y0, getColor());
            if (x0 == x1 && y0 == y1) break;

            int e2 = 2 * error;

            if (e2 >= dy) {
                if (x0 == x1) break;
                error += dy;
                x0 += sx;
            }

            if (e2 <= dx) {
                if (y0 == y1) break;
                error += dx;
                y0 += sy;
            }
        }
    }
}
