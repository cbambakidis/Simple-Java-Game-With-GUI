package bambakidis_project2;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author Costa Bambakidis
 */
public class scroller extends JTextField {

    private static final long serialVersionUID = 1L;
    private Color thisColor;
    private int count = 0;
    private int points = 0;
    private boolean gameIsOver = false;

    //Custom JTextfield object with special methods. 
    public scroller() {
    }

    //When called and passed a color and string, changes the contents to that color and string, and keeps count.
    public void update(final Color x, final String word) {
        this.setForeground(x);
        thisColor = x;
        this.setText(word);
        count++;
    }

    //Called by button objects.
    public void addPoint() {
        points++;
    }

    //Displays score and "Game over".
    public void gameOver() {
        this.setText("Your Score: " + points + "/10. Click any button to restart.");
        this.setForeground(Color.RED);
        gameIsOver = true;
    }

    //Possible use in buttons when restarting game?
    public boolean isGameOver() {
        return gameIsOver;
    }

    public Color getColor() {
        return thisColor;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int x) {
        points = x;
    }

    public int getCount() {
        return count;
    }
}
