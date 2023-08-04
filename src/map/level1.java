package map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class level1 {

    public BufferedImage bridge, wall, water;

    int scale = 2;
    int TileSize = 16 * scale;

    public void getlvlImg() {
        try {
            bridge = ImageIO.read(new File("res\\sprites\\BridgeFloor.png"));
            wall = ImageIO.read(new File("res\\sprites\\wall.png"));
            water = ImageIO.read(new File("res\\sprites\\water.png"));

        } catch (IOException e) {
            System.out.println("Error in loading image");
        }

    }

    int[][] map = { { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2 } };

    public void Draw(Graphics2D g) {
        // 2d array of tiles
        getlvlImg();
        // for loop to draw tiles
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {

                if (map[i][j] == 0) {
                    // draw grass tile
                    g.drawImage(bridge, TileSize * j, TileSize * i, TileSize, TileSize, null);
                    // System.out.print("B");

                }
                if (map[i][j] == 1) {
                    g.drawImage(wall, TileSize * j, TileSize * i, TileSize, TileSize, null);
                    // System.out.print("W");

                }
                if (map[i][j] == 2) {
                    g.drawImage(water, TileSize * j, TileSize * i, TileSize, TileSize, null);
                    // System.out.print("w");
                }

            }
            // System.out.println(" ");
        }

    }

    public void Update() {

    }
}
