import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.*;
import java.awt.EventQueue;

public class Breakout extends JFrame {
    public Breakout(){
        initUI();
    }

    private void initUI(){
        add(new Board());
        setTitle("Breakout");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(PolicyUtils.Commons.WIDTH, Commons.HEIGTH);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Breakout game = new Breakout();
                game.setVisible(true);
            }
        });
    }
}
