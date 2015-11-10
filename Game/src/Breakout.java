import javax.swing.*;
public class Breakout extends JFrame {

    public Breakout() {

        initUI();
    }

    private void initUI() {
        add(new Board());
        setTitle("Breakout");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Commons.WIDTH, Commons.HEIGTH);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        StartScreen startScreen = new StartScreen();
    }
}