import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class CanvasWindow  extends JFrame implements MouseMotionListener, MouseInputListener, KeyListener {
    private static CanvasWindow currentFrame;
    private static JPanel canvas;
    private ArrayList<Rectangle> figures = new ArrayList<Rectangle>();
    private Point currentFigureStart;
    private Point currentFigureEnd;

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
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

        for (var figure : figures) {
            g.drawRect(figure.x, figure.y, figure.width, figure.height);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (currentFigureStart != null)
        {
            currentFigure.
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        var cursor = e.getPoint();
        currentFigureStart = cursor;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        var cursor = e.getPoint();
        figures.add(new Rectangle(cursor.x, cursor.x, cursor.x, cursor.y));
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

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
