import java.awt.Color;
import java.util.Random;

public class Cube implements Drawable {
    private final Rectangle front;
    private final Rectangle back;

    public Cube(Rectangle front, Rectangle back) {
        this.front = front;
        this.back = back;
    }

    public static Cube random(int width, int height) {
        Random rng = new Random();
        Color color = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));

        Point p1 = Point.random(width, height);
        Point p2 = Point.random(width, height);
        Rectangle front = new Rectangle(p1, p2, color);

        int offset = 50;
        Rectangle back = new Rectangle(
            new Point(p1.x + offset, p1.y + offset),
            new Point(p2.x + offset, p2.y + offset),
            color
        );

        return new Cube(front, back);
    }

    @Override
    public Color getColor() {
        return front.getColor();
    }

    @Override
    public void draw(Displayable displayable) {
        front.draw(displayable);
        back.draw(displayable);

        Color color = getColor();
        Point fp1 = front.getP1();
        Point fp2 = front.getP2();
        Point bp1 = back.getP1();
        Point bp2 = back.getP2();

        // Connect the four corner pairs
        new Line(new Point(fp1.x, fp1.y), new Point(bp1.x, bp1.y), color).draw(displayable);
        new Line(new Point(fp2.x, fp1.y), new Point(bp2.x, bp1.y), color).draw(displayable);
        new Line(new Point(fp1.x, fp2.y), new Point(bp1.x, bp2.y), color).draw(displayable);
        new Line(new Point(fp2.x, fp2.y), new Point(bp2.x, bp2.y), color).draw(displayable);
    }
}
