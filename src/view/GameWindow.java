package view;

import gameobject.Plane;
import gameobject.PlaneAttacker;
import gameobject.PlaneEnemy;
import gameobject.PlaneSupporter;
import intef.Attacker;
import intef.QPressListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by hungtran on 7/9/16.
 */
public class GameWindow extends Frame implements Runnable{
    BufferedImage background;
    //BufferedImage plane;
    BufferedImage bufferImage;
    int planeX,planeY;
    int planeSpeed = 3;
    Plane playerAttacker;
    Plane playerSupporter;
    ArrayList<PlaneEnemy> enemies;


    public GameWindow(){
        initWindow();
        loadImage();
        initPlane();
        initEnemies();
        repaint();
        System.out.println("abcd");
    }

    void initEnemies(){
        enemies = new ArrayList<>();
        enemies.add(new PlaneEnemy(50, 50, 3));
        enemies.add(new PlaneEnemy(100, 50, 3));
        enemies.add(new PlaneEnemy(50, 199, 3));
        for (QPressListener q : enemies){
            ((PlaneAttacker)playerAttacker).addQPressListener(q);
        }
    }

    void initPlane(){
        playerAttacker = new PlaneAttacker(100, 200, Plane.TYPE_1);

        playerSupporter = new PlaneSupporter(50, 100, Plane.TYPE_2);
        ((PlaneAttacker)playerAttacker).addQPressListener((QPressListener) playerSupporter);
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
        this.setSize(600, 800);
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
        playerAttacker.moveByVector(0, 0);
    }

    void gameUpdate(){
        playerAttacker.update();
        playerSupporter.update();
        for (PlaneEnemy e : enemies){
            e.update();
        }
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
                //player1.moveByVector(-3, 0);
                break;
            case 'w':
               //player1.moveByVector(0, -3);

                break;
            case 's':
               // player1.moveByVector(0, 3);

                break;
            case 'd':
               // player1.moveByVector(3, 0);
                break;
            case 'q':
                ((PlaneAttacker)playerAttacker).notifyAll("abdcewew");
            case ' ':
                ((Attacker)playerSupporter).shot();
                break;
            case 'j':
                ((Attacker)playerAttacker).shot();
            default: break;
        }
    }

    @Override
    public void update(Graphics g) {
        if(bufferImage == null){
            bufferImage = new BufferedImage(600, 800, 1);
        }
        Graphics bufferGraphics = bufferImage.getGraphics();
        bufferGraphics.drawImage(background, 0, 0, null);

        playerAttacker.draw(bufferGraphics);
        playerSupporter.draw(bufferGraphics);
        for (PlaneEnemy e : enemies){
            e.draw(bufferGraphics);
        }

        g.drawImage(bufferImage, 0, 0, null);
    }

    @Override
    public void run() {
        gameLoop();
    }
}
