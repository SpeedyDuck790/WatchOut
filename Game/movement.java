package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class movement implements KeyListener {

    public static boolean up, down, left, right;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            up = true;
        }
        if (e.getKeyChar() == 's') {
            down = true;
        }
        if (e.getKeyChar() == 'a') {
            left = true;
        }
        if (e.getKeyChar() == 'd') {
            right = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            up = false;
        }
        if (e.getKeyChar() == 's') {
            down = false;
        }
        if (e.getKeyChar() == 'a') {
            left = false;
        }
        if (e.getKeyChar() == 'd') {
            right = false;
        }

    }
}
