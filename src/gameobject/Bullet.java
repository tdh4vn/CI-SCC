package gameobject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Hungtdh4vn on 7/11/2016.
 */
public class Bullet {

    private static final String BULLET_RS = "Resource/Char/B 2.png";

    private BufferedImage sprite;
    private int x;
    private int y;
    private int speed;

    public Bullet(int x, int y) {
        speed = 10;
        this.x = x;
        this.y = y;
        try {
            sprite = ImageIO.read(new File(BULLET_RS));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        move();
    }

    private void move() {
        this.y -= speed;
    }


    public void draw(Graphics g){
        g.drawImage(sprite, x, y, null);
    }
}
