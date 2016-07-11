import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Hungtdh4vn on 7/11/2016.
 */
public class Plane {
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    private static final String PLANE_1_RS = "Resource/Char/PLANE 1 N.png";

    private ArrayList<Bullet> listBullet;
    BufferedImage sprite;
    private int positionX;
    private int positionY;
    private int speedX = 0;
    private int speedY = 0;
    public Plane(){

    }

    public Plane(int posX, int posY, int type){
        listBullet = new ArrayList<>();
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
                break;
            default: break;
        }
    }

    public void shot(){
        listBullet.add(new Bullet(positionX, positionY));
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

        Iterator<Bullet> iterator = listBullet.iterator();
        while (iterator.hasNext()){
            Bullet bullet = iterator.next();
            bullet.update();
        }
    }

    public void draw(Graphics g){
        g.drawImage(sprite, positionX, positionY, null);
        Iterator<Bullet> iterator = listBullet.iterator();
        while (iterator.hasNext()){
            Bullet bullet = iterator.next();
            bullet.draw(g);
        }
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
