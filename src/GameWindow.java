import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by hungtran on 7/9/16.
 */
public class GameWindow extends Frame implements Runnable{
    BufferedImage background;
    //BufferedImage plane;
    BufferedImage bufferImage;
    int planeX,planeY;
    int planeSpeed = 3;
    Plane player1;

    public GameWindow(){
        initWindow();
        loadImage();
        initPlane();
        repaint();
        System.out.println("abcd");
    }

    void initPlane(){
        player1 = new Plane(100, 200, Plane.TYPE_1);
    }

    void loadImage() {
        try {
           // plane = ImageIO.read(new File("Resource/Char/PLANE 1 N.png"));
            background = ImageIO.read(new File("Resource/Background/airPlanesBackground.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void initWindow(){
        this.setTitle("TechKids");
        this.setSize(480, 800);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                eventKeyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                eventKeyReleased(e);
            }
        });
    }

    private void eventKeyReleased(KeyEvent e) {
        player1.moveByVector(0, 0);
    }

    void gameUpdate(){
        player1.update();
    }

    void gameLoop(){
        while (true){
            try {
                gameUpdate();
                repaint();
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void eventKeyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
        switch (e.getKeyChar()){
            case 'a':
                System.out.println("AAAA");
                player1.moveByVector(-3, 0);
                break;
            case 'w':
                player1.moveByVector(0, -3);

                break;
            case 's':
                player1.moveByVector(0, 3);

                break;
            case 'd':
                player1.moveByVector(3, 0);
                break;
            default: break;
        }
    }

    @Override
    public void update(Graphics g) {
        if(bufferImage == null){
            bufferImage = new BufferedImage(480, 800, 1);
        }
        Graphics bufferGraphics = bufferImage.getGraphics();
        bufferGraphics.drawImage(background, 0, 0, null);

        player1.draw(bufferGraphics);

        g.drawImage(bufferImage, 0, 0, null);
    }

    @Override
    public void run() {
        gameLoop();
    }
}
