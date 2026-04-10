import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image implements Displayable {
    private final BufferedImage buffer;
    private final int width;
    private final int height;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Fill background black
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                buffer.setRGB(x, y, Color.BLACK.getRGB());
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void display(int x, int y, Color color) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            buffer.setRGB(x, y, color.getRGB());
        }
    }

    @Override
    public void save(String filename) {
        try {
            File output = new File(filename);
            ImageIO.write(buffer, "png", output);
            System.out.println("Image saved to " + output.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save image: " + e.getMessage());
        }
    }
}
