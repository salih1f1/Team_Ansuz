import javax.swing.*;

public class Brick extends Sprite {

    private boolean destroyed;

    public Brick(int x, int y ,Integer number) {

        this.x = x;
        this.y = y;
String imagePath = null;
        switch (number){
            case 0 : imagePath = "Game/Files/brick0.png"; break;
            case 1 : imagePath = "Game/Files/brick1.png"; break;
            case 2: imagePath = "Game/Files/brick2.png"; break;
            case 3 :imagePath = "Game/Files/brick3.png"; break;
            case 4 :imagePath = "Game/Files/brick4.png"; break;
            case 5: imagePath = "Game/Files/brick5.png"; break;

        }

        ImageIcon ii = new ImageIcon(imagePath);
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);

        destroyed = false;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean val) {
        Board.pointsAdd();
        destroyed = val;
    }
}