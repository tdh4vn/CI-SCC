package gameobject;

import intef.QPressListener;

/**
 * Created by hungtran on 7/12/16.
 */
public class PlaneEnemy extends Plane implements QPressListener{
    public PlaneEnemy(int x, int y, int type){
        super(x,y,type);
    }

    @Override
    public void qPess(String msg) {
        System.out.println(msg);
    }
}
