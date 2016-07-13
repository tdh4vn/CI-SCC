package gameobject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Hungtdh4vn on 7/11/2016.
 */
public abstract class Plane {
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;
    private static final String PLANE_1_RS = "Resource/Char/PLANE 1 N.png";

    BufferedImage sprite;
    private int positionX;
    private int positionY;
    private int speedX = 0;
    private int speedY = 0;
    public Plane(){

    }

    public Plane(int posX, int posY, int type){
        positionX = posX;
        positionY = posY;
        loadSpriteByType(type);
    }

    private void loadSpriteByType(int type){
        switch (type){
            case TYPE_1:
                try {
                    sprite = ImageIO.read(new File(PLANE_1_RS));
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
            case TYPE_3:
                try {
                    sprite = ImageIO.read(new File("Resource/Char/PLANE 8 N.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default: break;
        }
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

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}
