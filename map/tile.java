package map;

import java.awt.image.BufferedImage;

public class tile {
    public BufferedImage tileImg;
    public boolean collision = false;
    int imgtype;

    public tile(int imgtype) {
        this.imgtype = imgtype;
    }

}
