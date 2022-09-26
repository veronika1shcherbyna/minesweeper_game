import javax.swing.*;
import java.awt.*;

public class JavaSweeper extends JFrame {
    private static final int COLS = 15;
    private static final int ROWS = 1;
    private static final int IMAGE_SIZE = 50;
    private JPanel panel;

    private JavaSweeper() {
        initPanel();
        initFrame();
    }

    private void initFrame() {
        //JFrame methods
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //your app will be closed in the IDE when you click on the cross
        setTitle("MineSweeper");
        setLocationRelativeTo(null); //location is in a screen center
        setResizable(false); //you can't change size of an app-window
        setVisible(true);
    }

    private void initPanel() {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(
                COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE)); //setting size of an app-window
        add(panel); //JFrame method
    }

    public static void main(String[] args) {
        new JavaSweeper();
    }
}
