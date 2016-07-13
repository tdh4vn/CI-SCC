package gameobject;

import intef.QPressListener;

import java.awt.*;

/**
 * Created by hungtran on 7/12/16.
 */
public class PlaneEnemy extends Plane implements QPressListener{
    Animation animation;
    public PlaneEnemy(int x, int y, int type){
        super(x,y,type);
        animation = new Animation("Resource/cat.png",512, 256,31);
    }

    @Override
    public void update() {
        super.update();
        animation.update();
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        animation.draw(g, getPositionX(), getPositionY());
    }

    @Override
    public void qPess(String msg) {
        System.out.println(msg);
    }
}
