import java.awt.Color;
import java.util.Random;

public class Point implements Drawable {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point random(int width, int height) {
        Random rng = new Random();
        return new Point(rng.nextInt(width), rng.nextInt(height));
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    @Override
    public void draw(Displayable displayable) {
        displayable.display(x, y, getColor());
    }
}
