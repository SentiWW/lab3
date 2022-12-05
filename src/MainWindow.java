import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MainWindow extends JFrame implements MouseMotionListener {
    private static MainWindow currentFrame;
    private static JButton clickMe;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    currentFrame = new MainWindow();
                    currentFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    public MainWindow() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Constants.MainWindowWidth, Constants.MainWindowHeight);
        setResizable(false);

        JPanel content = new JPanel();
        content.setBounds(0, 0, Constants.MainWindowWidth, Constants.MainWindowHeight);
        addMouseMotionListener(this);
        content.setLayout(null);
        setLayout(null);
        setContentPane(content);

        clickMe = new JButton("Click me!");
        var randomStartingPoint = RandomProvider.RandomPoint(Constants.MainWindowWidth,
                Constants.MainWindowHeight, Constants.ClickMeButtonWidth, Constants.ClickMeButtonHeight);
        clickMe.setBounds(randomStartingPoint.x, randomStartingPoint.y, Constants.ClickMeButtonWidth,
                Constants.ClickMeButtonHeight);
        clickMe.addActionListener(event -> {
            new CanvasWindow().setVisible(true);
        });

        content.add(clickMe);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        handleButtonMovement(e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        handleButtonMovement(e.getPoint());
    }

    public void handleButtonMovement(Point cursor) {
        cursor = new Point(cursor.x - 8, cursor.y - 32);
        var bounds = clickMe.getBounds();
        var topLeftBound = new Rectangle(bounds.x - Constants.SafeZone, bounds.y - Constants.SafeZone,
                Constants.SafeZone, Constants.SafeZone);
        var topCenterBound = new Rectangle(bounds.x, bounds.y - Constants.SafeZone,
                bounds.width, Constants.SafeZone);
        var topRightBound = new Rectangle(bounds.x + bounds.width, bounds.y - Constants.SafeZone,
                Constants.SafeZone, Constants.SafeZone);
        var centerLeftBound = new Rectangle(bounds.x - Constants.SafeZone, bounds.y,
                Constants.SafeZone, bounds.height);
        var centerRightBound = new Rectangle(bounds.x + bounds.width, bounds.y,
                Constants.SafeZone, bounds.height);
        var bottomLeftBound = new Rectangle(bounds.x - Constants.SafeZone, bounds.y + bounds.height,
                Constants.SafeZone, Constants.SafeZone);
        var bottomCenterBound = new Rectangle(bounds.x, bounds.y + bounds.height,
                bounds.width, Constants.SafeZone);
        var bottomRightBound = new Rectangle(bounds.x + bounds.width, bounds.y + bounds.height,
                Constants.SafeZone, Constants.SafeZone);

        System.out.println(cursor);
        // Top left
        if (topLeftBound.contains(cursor)) {
            System.out.println("Top left");

            clickMe.setBounds(bounds.x + Constants.SafeZone, bounds.y + Constants.SafeZone,
                    Constants.ClickMeButtonWidth, Constants.ClickMeButtonHeight);
        }

        // Top center
        if (topCenterBound.contains(cursor)) {
            System.out.println("Top center");
            clickMe.setBounds(bounds.x, bounds.y + Constants.SafeZone,
                    Constants.ClickMeButtonWidth, Constants.ClickMeButtonHeight);
        }

        // Top right
        if (topRightBound.contains(cursor)) {
            System.out.println("Top right");
            clickMe.setBounds(bounds.x - Constants.SafeZone, bounds.y + Constants.SafeZone,
                    Constants.ClickMeButtonWidth, Constants.ClickMeButtonHeight);
        }

        // Center left
        if (centerLeftBound.contains(cursor)) {
            System.out.println("Center left");
            clickMe.setBounds(bounds.x + Constants.SafeZone, bounds.y,
                    Constants.ClickMeButtonWidth, Constants.ClickMeButtonHeight);
        }

        // Center right
        // if (centerRightBound.contains(cursor)) {
        //     System.out.println("Center right");
        //     clickMe.setBounds(bounds.x - Constants.SafeZone, bounds.y,
        //             Constants.ClickMeButtonWidth, Constants.ClickMeButtonHeight);
        // }

        // Bottom left
        if (bottomLeftBound.contains(cursor)) {
            System.out.println("Bottom left");
            clickMe.setBounds(bounds.x + Constants.SafeZone, bounds.y - Constants.SafeZone,
                    Constants.ClickMeButtonWidth, Constants.ClickMeButtonHeight);
        }

        // Bottom center
        if (bottomCenterBound.contains(cursor)) {
            System.out.println("Bottom center");
            clickMe.setBounds(bounds.x, bounds.y - Constants.SafeZone,
                    Constants.ClickMeButtonWidth, Constants.ClickMeButtonHeight);
        }

        // Bottom center
        if (bottomRightBound.contains(cursor)) {
            System.out.println("Bottom right");
            clickMe.setBounds(bounds.x - Constants.SafeZone, bounds.y - Constants.SafeZone,
                    Constants.ClickMeButtonWidth, Constants.ClickMeButtonHeight);
        }
    }
}
