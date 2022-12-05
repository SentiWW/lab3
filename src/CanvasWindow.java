import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class CanvasWindow  extends JFrame implements MouseMotionListener, MouseInputListener, KeyListener {
    private static CanvasWindow currentFrame;
    private static JPanel canvas;
    private JLabel cursorLabel;
    private final ArrayList<Figure> figures = new ArrayList<Figure>();
    private Point currentFigureStart;
    private Point currentFigureEnd;
    private Shape shape = Shape.Rectangle;
    private AppColor color = AppColor.Red;

    public CanvasWindow() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Constants.MainWindowWidth, Constants.MainWindowHeight);
        setResizable(false);

        canvas = new JPanel();
        canvas.setBounds(0, 0, Constants.MainWindowWidth, Constants.MainWindowHeight);
        addMouseMotionListener(this);
        addMouseListener(this);
        addKeyListener(this);
        canvas.setLayout(null);
        setLayout(null);
        setContentPane(canvas);

        var label = new JLabel("<html>R - Prostokąt,<br/>C - Owal,<br/>1 - Czerwony,<br/>2 - Zielony,<br/>3 - Niebieski");
        label.setBounds(5, 5, 100, 100);
        canvas.add(label);

        cursorLabel = new JLabel();
        cursorLabel.setBounds(105, 5, 100, 20);
        canvas.add(cursorLabel);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

        if (currentFigureStart != null && currentFigureEnd != null) {
            var x = Math.min(currentFigureStart.x, currentFigureEnd.x);
            var y = Math.min(currentFigureStart.y, currentFigureEnd.y);
            var width = Math.abs(currentFigureStart.x - currentFigureEnd.x);
            var height = Math.abs(currentFigureStart.y - currentFigureEnd.y);

            switch (color) {
                case Red:
                    g.setColor(new Color(255, 0, 0));
                    break;
                case Green:
                    g.setColor(new Color(0, 255, 0));
                    break;
                case Blue:
                    g.setColor(new Color(0, 0, 255));
                    break;
            }

            switch (shape) {
                case Rectangle:
                    g.fillRect(x, y, width, height);
                    break;
                case Circle:
                    g.fillOval(x, y, width, height);
                    break;
            }
        }

        for (var figure : figures) {
            switch (figure.color) {
                case Red:
                    g.setColor(new Color(255, 0, 0));
                    break;
                case Green:
                    g.setColor(new Color(0, 255, 0));
                    break;
                case Blue:
                    g.setColor(new Color(0, 0, 255));
                    break;
            }
            switch (figure.shape) {
                case Rectangle:
                    g.fillRect(figure.x, figure.y, figure.width, figure.height);
                    break;
                case Circle:
                    g.fillOval(figure.x, figure.y, figure.width, figure.height);
                    break;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        currentFigureEnd = new Point(e.getPoint());
        paintComponents(getGraphics());
        cursorLabel.setText("(x: " + e.getX() + ", y: " + e.getY() + ")");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cursorLabel.setText("(x: " + e.getX() + ", y: " + e.getY() + ")");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        var cursor = e.getPoint();
        currentFigureStart = new Point(cursor);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (currentFigureStart != null && currentFigureEnd != null) {
            var x = Math.min(currentFigureStart.x, currentFigureEnd.x);
            var y = Math.min(currentFigureStart.y, currentFigureEnd.y);
            var width = Math.abs(currentFigureStart.x - currentFigureEnd.x);
            var height = Math.abs(currentFigureStart.y - currentFigureEnd.y);

            figures.add(new Figure(x, y, width, height, shape, color));
        }

        currentFigureStart = null;
        currentFigureEnd = null;
        this.paintComponents(getGraphics());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case '1':
                color = AppColor.Red;
                break;
            case '2':
                color = AppColor.Green;
                break;
            case '3':
                color = AppColor.Blue;
                break;
            case 'c':
            case 'C':
                shape = Shape.Circle;
                break;
            case 'r':
            case 'R':
                shape = Shape.Rectangle;
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
