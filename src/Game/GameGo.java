package Game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameGo {
    public static void main(String[] args) {
        Display play = new Display();
        JFrame windowFrame = new JFrame();
        ImageIcon img = new ImageIcon("mickidle.png");

        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setResizable(false);
        windowFrame.setTitle("WatchOUT");
        windowFrame.setVisible(true);

        windowFrame.add(play);
        windowFrame.pack();

        play.startGthread();
        windowFrame.setLocationRelativeTo(null);
        windowFrame.setIconImage(img.getImage());

    }
}
