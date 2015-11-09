
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class Board extends JPanel implements Commens {

    private Timer time;
    private String mesig = "Game Over";
    private Ball ball;
    private Paddle paddle;
    //  private Brick bricks[];
    private boolean image = true;

    public Board(){
        initBoard();
    }

    public void initBoard(){
        addKeyListener();
        setFocusable(true);

        //bricks = new Brick[N_OF_BRICKS];

    }


}
