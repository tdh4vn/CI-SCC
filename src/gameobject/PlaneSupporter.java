package gameobject;

import intef.Attacker;
import intef.QPressListener;
import intef.Supporter;

/**
 * Created by Hungtdh4vn on 7/11/2016.
 */
public class PlaneSupporter extends Plane implements Supporter, Attacker, QPressListener{
    public PlaneSupporter(int i, int i1, int type2) {
        super(i, i1, type2);
    }

    @Override
    public void shot() {
        System.out.println("Ban");
    }

    @Override
    public void buffHP() {
        System.out.println("buff mau");
    }

    @Override
    public void qPess(String msg) {
        System.out.println(msg);
    }
}
