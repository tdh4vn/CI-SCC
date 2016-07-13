package gameobject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hungtran on 7/13/16.
 */
public class Animation {
    private ArrayList<BufferedImage> frames = new ArrayList<>();
    private int index = 0;
    private int countTime = 0;
    private int time;
    public Animation(String imageRS,int w, int h,int time){
        this.time = time;
        try {
            BufferedImage image = ImageIO.read(new File(imageRS));
            for (int i = 0; i < image.getWidth()/w; i++){
                for (int j = 0; j < image.getHeight()/h; j++){
                    BufferedImage subImage = image.getSubimage(i * w, j * h, w, h);
                    frames.add(subImage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        countTime += 17;
        if (countTime > this.time) {
            countTime = 0;
            if (index == frames.size() - 1) {
                index = 0;
            } else {
                index++;
            }
        }
    }

    public void draw(Graphics g, int posX, int posY){
        g.drawImage(frames.get(index), posX, posY , null);
    }
}
