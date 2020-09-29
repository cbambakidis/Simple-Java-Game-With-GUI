package bambakidis_project2;



import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Costa Bambakidis
 */
public class gamePanel extends JPanel implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private final int score = 0;

    public gamePanel() throws IOException, InterruptedException {
        final ArrayList<String> words = new ArrayList();
        words.add("Green");
        words.add("Blue");
        words.add("Red");
        words.add("Yellow");
        final scroller wordDisplayer = new scroller();
        final button b1 = new button(Color.BLUE);
        final button b2 = new button(Color.RED);
        final button b3 = new button(Color.GREEN);
        final button b4 = new button(Color.YELLOW);

        wordDisplayer.setText("Get ready...");
    
        final Timer timer = new Timer(700, new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                wordDisplayer.update(randomColorGenerator(), wordsGetter(words));
                if (wordDisplayer.getCount() >= 10) {
                    ((Timer) evt.getSource()).stop();
                    wordDisplayer.gameOver();
                }
            }
        });
        timer.setRepeats(true);
        timer.setInitialDelay(3000);
        timer.start();
        //Put button actionlisteners here so I can restart the game easier?
        b1.instantinate(wordDisplayer);
        b2.instantinate(wordDisplayer);
        b3.instantinate(wordDisplayer);
        b4.instantinate(wordDisplayer);
        Thread.sleep(100);
        final JPanel buttonPane = new JPanel(new GridLayout(2, 0));
        buttonPane.add(b1);
        buttonPane.add(b2);
        buttonPane.add(b3);
        buttonPane.add(b4);
        this.setLayout(new BorderLayout());
        wordDisplayer.setHorizontalAlignment(JTextField.CENTER);
        wordDisplayer.setBackground(Color.BLACK);
        this.add(wordDisplayer, BorderLayout.NORTH);
        wordDisplayer.setFont(new Font("Comic Sans", Font.PLAIN, 20));
        this.add(buttonPane, BorderLayout.CENTER);

        // create button panel and add it to this. method to shuffle and redisplay
        // buttons on hard mode?
    }

    //Gets a random word for scroller.
    private String wordsGetter(final ArrayList<String> d) {
        Collections.shuffle(d);
        return d.get(1);
    }

    //Returns a random color for the random word generated above.
    private Color randomColorGenerator() {
        final Random x = new Random();
        final int r = x.nextInt((4 - 1) + 1) + 1;
        Color g = Color.BLUE;
        switch (r) {
            case 1:
                g = Color.RED;
                return g;

            case 2:
                g = Color.BLUE;
                return g;

            case 3:
                g = Color.GREEN;
                return g;

            case 4:
                g = Color.YELLOW;
                return g;
            default:

                break;
        }
        return g;
    }

    //Cant get rid of this for some reason
    @Override
    public void actionPerformed(final ActionEvent e) {

    }

}
