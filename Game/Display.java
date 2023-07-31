package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Bullet;
import entity.Player;
import map.level1;

public class Display extends JPanel implements Runnable {

    movement keyValue = new movement();
    Thread Gthread;
    public Player player = new Player(this, keyValue);
    final int screenwidth = (player.scale * 16) * 16;
    final int screenheight = (player.scale * 16) * 16;
    int FPS = 60;
    Bullet bullet = new Bullet(this, keyValue, (int) (Math.random() * 400), screenheight);
    Bullet bullet2 = new Bullet(this, keyValue, (int) (Math.random() * 400), screenheight);
    Bullet bullet3 = new Bullet(this, keyValue, (int) (Math.random() * 400), screenheight);
    Bullet bullet4 = new Bullet(this, keyValue, (int) (Math.random() * 400), screenheight);
    Bullet bullet5 = new Bullet(this, keyValue, (int) (Math.random() * 400), screenheight);

    level1 level = new level1();
    public boolean stop;
    public double time;
    public boolean win = false;

    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    Display() {
        System.out.println("Displaymade");
        this.setPreferredSize(new Dimension(screenwidth, screenheight));
        this.setBackground(new Color(21, 21, 21));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyValue);
        this.setFocusable(true);
    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // start method
    public void startGthread() {
        Gthread = new Thread(this);
        Gthread.start();
    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void run() {
        double actionInterval = 1000000000.0 / FPS;
        double nextAction = System.nanoTime() + actionInterval;
        while (Gthread != null) {

            update();
            repaint();

            try {
                double wait = nextAction - System.nanoTime();
                wait = wait / 1000000;
                if (wait < 0) {
                    wait = 0;
                }
                Thread.sleep((long) wait);
                nextAction += actionInterval;
            } catch (Exception e) {
                System.out.println("Error in game loop");
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    int i;
    int round = 0;

    public void update() {
        player.update();
        bullet.update();
        bullet2.update();
        bullet3.update();
        bullet4.update();
        bullet5.update();
        bullet.collisonchk(player.hitbox);
        bullet2.collisonchk(player.hitbox);
        bullet3.collisonchk(player.hitbox);
        bullet4.collisonchk(player.hitbox);
        bullet5.collisonchk(player.hitbox);
        if (bullet.getcollison() == true || bullet2.getcollison() == true || bullet3.getcollison() == true
                || bullet4.getcollison() == true || bullet5.getcollison() == true) {
            stop = true;

        } else {
            stop = false;
        }
        if (stop == false) {
            i++;
        }
        if (i == 15) {
            time += 0.15;
            i = 0;
        }
        if (bullet.y < 0) {
            bullet.y = screenheight;
            bullet.x = (int) (Math.random() * 400);
            bullet.SetDefault();
            bullet2.y = screenheight;
            bullet2.x = (int) (Math.random() * 400);
            bullet2.SetDefault();
            bullet3.y = screenheight;
            bullet3.x = (int) (Math.random() * 400);
            bullet3.SetDefault();
            bullet4.y = screenheight;
            bullet4.x = (int) (Math.random() * 400);
            bullet4.SetDefault();
            bullet5.y = screenheight;
            bullet5.x = (int) (Math.random() * 400);
            bullet5.SetDefault();
            round++;
            bullet.speed += round;
            bullet2.speed += round;
            bullet3.speed += round;
            bullet4.speed += round;
            bullet5.speed += round;
        }
        System.out.println(time + " " + round);

        if (round == 10) {
            win = true;
        }

    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D Bullet = (Graphics2D) g;
        Graphics2D guy = (Graphics2D) g;
        Graphics2D map = (Graphics2D) g;
        Graphics2D end = (Graphics2D) g;

        if (stop == true) {
            // level.Draw(map);
            player.drawPlayer(guy);
            bullet.Draw(Bullet);
            bullet2.Draw(Bullet);
            bullet3.Draw(Bullet);
            bullet4.Draw(Bullet);
            bullet5.Draw(Bullet);
            endscene(end);
            Gthread = null;

        } else if (win == true) {
            Winscene(end);
            Gthread = null;
        } else {

            level.Draw(map);
            player.drawPlayer(guy);
            bullet.Draw(Bullet);
            bullet2.Draw(Bullet);
            bullet3.Draw(Bullet);
            bullet4.Draw(Bullet);
            bullet5.Draw(Bullet);
        }
    }

    public static final DecimalFormat df1 = new DecimalFormat("0.00s");

    public void endscene(Graphics2D g) {
        System.out.println("end");
        g.setColor(Color.BLACK);
        g.fillRect(screenwidth / 3, screenheight / 3, screenwidth / 3, screenheight / 3);
        g.setColor(Color.WHITE);
        g.drawString("Game Over", (screenwidth / 2) - 32, screenheight / 2);
        g.drawString("Time: " + df1.format(time), (screenwidth / 2) - 32, (screenheight / 2) + 16);

    }

    public void Winscene(Graphics2D g) {
        System.out.println("end");
        g.setColor(Color.GREEN);
        g.fillRect(screenwidth / 4, screenheight / 3, screenwidth / 2, screenheight / 3);
        g.setColor(Color.BLACK);
        g.fillRect((screenwidth / 4) + 4, (screenheight / 3) + 4, (screenwidth / 2) - 8, (screenheight / 3) - 8);
        g.setColor(Color.WHITE);
        g.drawString("You Have Survived all the Bullets", (screenwidth / 2) - 100, screenheight / 2);
        g.drawString("you survivied for Time: " + df1.format(time), (screenwidth / 2) - 60, (screenheight / 2) + 16);

    }
    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}