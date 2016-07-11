/**
 * Created by Hungtdh4vn on 7/11/2016.
 */
public class PlaneAttacker extends Plane implements Attacker {
    public PlaneAttacker(int i, int i1, int type1) {
        super(i, i1, type1);
    }

    @Override
    public void shot() {
        System.out.println("Ban Manh");
    }
}
