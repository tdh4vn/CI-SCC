/**
 * Created by hungtran on 7/9/16.
 */
public class Main {
    public static void main(String[] delacaigicungdc){
        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();
    }
}
