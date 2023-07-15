package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Game.Display;
import Game.movement;

public class Bullet extends EntityObj {
    Display ds;
    movement mv;

    public Bullet(Display ds, movement mv, int x, int y) {
        this.ds = ds;
        this.mv = mv;
        this.x = x;
        this.y = y;
        SetDefault();
    }

    int scale = 2;

    public void SetDefault() {
        getBulletimg();
        // y = (scale * 16) * 16;
        // x = 100;
        collision = false;
        Direction = "up";
        name = "Bully";
        width = scale * 16;
        height = scale * 16;
        hitbox = new Rectangle(x + 2, y, width - 4, height);
    }

    public void getBulletimg() {
        try {
            up = ImageIO.read(new File("bullet.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public boolean getcollison() {

        return collision;

    }

    public void collisonchk(Rectangle Phitbox) {
        if (Phitbox.intersects(hitbox)) {
            collision = true;
        }
        // else {
        // collision = false;
        // }

    }

    public void update() {
        y -= 1;
        hitbox.y = y;
    }

    public void Draw(Graphics2D g) {
        g.fill(hitbox);
        g.drawImage(up, x, y, width, height, null);

    }
}
