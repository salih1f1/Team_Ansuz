import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartScreen extends JFrame {
    public StartScreen(){
        startScreen();
    }
    private void startScreen(){
        JFrame startScreenFrame = new JFrame("Hello");
        JPanel panel = new JPanel(new GridLayout(1,1));
        startScreenFrame.setResizable(false);
        startScreenFrame.setVisible(true);

        System.out.println(startScreenFrame.getSize());
        startScreenFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            BufferedImage img = ImageIO.read(new File("Game/Files/Logo.jpg"));
            ImageIcon icon = new ImageIcon(img);
            JLabel label = new JLabel(icon);
            label.setIcon(icon);
            add(label);
            label.setLayout(new FlowLayout());
        }catch (IOException ex){
            System.out.println(ex);
        }

        JButton startButton = new JButton("Start");
        JButton quitButton = new JButton("Exit");
        JButton resultsButton = new JButton("Results");

        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);

        quitButton.setOpaque(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setBorderPainted(false);

        resultsButton.setOpaque(false);
        resultsButton.setContentAreaFilled(false);
        resultsButton.setBorderPainted(false);

        panel.add(startButton);
        panel.add(quitButton);
        panel.add(resultsButton);
        startScreenFrame.setContentPane(panel);

        startScreenFrame.setBounds(350,150,800,500);
        startScreenFrame.setVisible(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Breakout game = new Breakout();
                        game.setVisible(true);
                        startScreenFrame.setVisible(false);
                    }
                });
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        resultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultsShow.showResults();
            }
        });
    }
}
