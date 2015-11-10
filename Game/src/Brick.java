import javax.swing.*;

public class Brick extends Sprite {

    private boolean destroyed;

    public Brick(int x, int y) {

        this.x = x;
        this.y = y;

        ImageIcon ii = new ImageIcon("Game/Files/Brick.png");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);

        destroyed = false;
    }

    public boolean isDestroyed() {
        Board.pointsAdd();
        return destroyed;
    }

    public void setDestroyed(boolean val) {

        destroyed = val;
    }
}