import javax.swing.*;
import java.awt.*;
import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

public class JavaSweeper extends JFrame {
    private static final int COLS = 9;
    private static final int ROWS = 9;
    private static final int IMAGE_SIZE = 50;
    private JPanel panel;
    private Game game;

    private JavaSweeper() {
        game = new Game(COLS, ROWS);
        setImages();
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
        setIconImage(getImage("icon"));
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord : Ranges.getAllCoords()) {
                    g.drawImage((Image) game.getBox(coord).image,
                            coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE, this);
                }
                //Anonymous class for creating and adding images
            }
        };
        panel.setPreferredSize(new Dimension(
                Ranges.getSize().x * IMAGE_SIZE,
                Ranges.getSize().y * IMAGE_SIZE)); //setting size of an app-window
        add(panel); //JFrame method
    }

    private Image getImage(String name) {
        String fileName = "img/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();
    }

    private void setImages() {
        for (Box box : Box.values()) {
            box.image = getImage(box.name().toLowerCase());
        }
    }

    public static void main(String[] args) {
        new JavaSweeper();
    }
}
