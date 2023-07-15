package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.*;
import map.tile;

public class Player extends EntityObj {
    Display ds;
    movement mv;

    public Player(Display ds, movement mv) {
        this.ds = ds;
        this.mv = mv;
        SetDefault();
    }

    public int scale = 2;

    public void SetDefault() {
        getplayerimg();
        x = 2 * (16 * 8);
        y = 2 * (16 * 8);
        collision = false;
        Direction = "up";
        name = "mick";
        width = scale * 16;
        height = scale * 16;
        hitbox = new Rectangle(x + 2, y, width - 4, height);
    }

    int testtick = 0;

    public void update() {

        int px = 0, py = 0;
        if (movement.up == true) {
            Direction = "up";
            py = -5;

        }
        if (movement.down == true) {
            Direction = "down";
            py = 5;
        }
        if (movement.left == true) {
            Direction = "left";
            px = -5;
        }
        if (movement.right == true) {
            Direction = "right";
            px = 5;

        }

        // testtick++;// timer

        if (ds.stop) {
            // Set hit status and position
            collision = true;
        } else {
            // Reset hit status and message
            collision = false;
        }
        if (!collision) {
            // Update player's position if there is no collision with wall
            x += px;
            y += py;
            hitbox.y += py;
            hitbox.x += px;
        }
        // Check for collision with water rectangle

        mapcollisionchecker();

    }

    public void mapcollisionchecker() {
        if (x < 50) {
            x = 50;
            hitbox.x = 50;
        }
        if (x > (ds.getWidth() - width) - 50) {
            x = (ds.getWidth() - width) - 50;
            hitbox.x = (ds.getWidth() - width) - 50;
        }
        if (y < 0) {
            y = 0;
            hitbox.y = 0;
        }
        if (y > (ds.getHeight() - height)) {
            y = ds.getHeight() - height;
            hitbox.y = ds.getHeight() - height;
        }

    }

    public void getplayerimg() {
        try {
            up = ImageIO.read(new File("mickup.png"));
            down = ImageIO.read(new File("mickidle.png"));
            left = ImageIO.read(new File("mickleft.png"));
            right = ImageIO.read(new File("mickright.png"));
            idle = ImageIO.read(new File("mickidle.png"));

        } catch (IOException e) {
            System.out.println("Error in loading image");
        }

    }

    public void drawPlayer(Graphics2D guy) {
        BufferedImage image = null;

        switch (Direction) {
            case "up":
                image = up;
                break;
            case "down":
                image = idle;
                break;
            case "left":
                image = left;
                break;
            case "right":
                image = right;
                break;
            default:
                image = idle;
                break;
        }
        guy.fill(hitbox);
        guy.drawImage(image, x, y, width, height, null);
    }
}
