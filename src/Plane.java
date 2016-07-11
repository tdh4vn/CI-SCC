import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Hungtdh4vn on 7/11/2016.
 */
public class Plane {
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    BufferedImage sprite;
    int positionX;
    int positionY;
    int speedX = 0;
    int speedY = 0;

    public Plane(){

    }

    public Plane(int posX, int posY, int type){
        positionX = posX;
        positionY = posY;
        loadSpriteByType(type);
    }

    public void loadSpriteByType(int type){
        switch (type){
            case TYPE_1:
                try {
                    sprite = ImageIO.read(new File("Resource/Char/PLANE 1 N.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case TYPE_2:
                try {
                    sprite = ImageIO.read(new File("Resource/Char/PLANE 2 N.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default: break;
        }
    }

    public void shot(){

    }

    public void move(int x, int y){
        positionX = x;
        positionY = y;
    }

    public void moveByVector(int x, int y){
        speedX = x;
        speedY = y;
    }

    public void update(){
        positionX += speedX;
        positionY += speedY;
    }

    public void draw(Graphics g){
        g.drawImage(sprite, positionX, positionY, null);
    }
}
