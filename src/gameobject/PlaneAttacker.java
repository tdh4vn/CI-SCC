package gameobject;

import intef.Attacker;
import intef.QPressListener;
import intef.QSender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hungtdh4vn on 7/11/2016.
 */
public class PlaneAttacker extends Plane implements Attacker, QSender {

    List<QPressListener> listQPress = new ArrayList<>();

    public PlaneAttacker(int i, int i1, int type1) {
        super(i, i1, type1);
    }

    @Override
    public void shot() {
        System.out.println("Ban Manh");
    }

    @Override
    public void addQPressListener(QPressListener q) {
        listQPress.add(q);
    }

    @Override
    public void notifyAll(String msg) {
        for(QPressListener q : listQPress){
            q.qPess("Tao vua an Q");
        }
    }
}
