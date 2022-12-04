import java.awt.*;
import java.util.Random;

public class RandomProvider {
    private static final Random Random = new Random();

    public static Point RandomPoint(int containerWidth, int containerHeight, int buttonWidth, int buttonHeight) {
        int x = Random.nextInt(containerWidth - buttonWidth);
        int y = Random.nextInt(containerHeight - buttonHeight);

        return new Point(x, y);
    }
}
