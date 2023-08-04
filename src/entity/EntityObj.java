package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class EntityObj {

    public int x, y, height, width;
    public boolean collision;
    public BufferedImage up, down, left, right, idle;
    public String Direction, name;
    public Rectangle hitbox;
    public int speed = 1;

}
