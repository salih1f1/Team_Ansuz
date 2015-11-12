import javazoom.jl.player.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class StartScreen extends JFrame {

    private BufferedImage img;
    private ImageIcon icon;
    private JButton startButton = new JButton("Start Game");
    private JButton quitButton = new JButton("Exit");

    public StartScreen(){
        startScreen();
    }

    private void startScreen(){
        String musicPath = "Game/Files/music.mp3";
        setTitle("Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        try {
            img = ImageIO.read(new File("Game/Files/Logo.jpg"));
            icon = new ImageIcon(img);

        }catch (IOException ex){
        }
        setLayout(new BorderLayout());
        JLabel background = new JLabel(icon);
        add(background);
        startButton.setFont(new Font("Arial",Font.PLAIN, 40));
        quitButton.setFont(new Font("Arial", Font.PLAIN, 40));
        background.setLayout(new FlowLayout());
        background.add(startButton);
        background.add(quitButton);
        setSize(800,500);
        setResizable(false);
        setLocationRelativeTo(null);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Breakout game = new Breakout();
                        game.setVisible(true);
                        setVisible(false);
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
        try{

            FileInputStream fis = new FileInputStream(musicPath);
            Player playMP3 = new Player(fis);

            playMP3.play();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
