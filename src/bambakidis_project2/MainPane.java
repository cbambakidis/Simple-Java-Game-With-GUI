/*
 *  @author Constantine Bambakidis
 *  CS1181, Fall 2020, Wright State University
 *  Lab/Project x
 */
package bambakidis_project2;

import java.awt.*;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Splash screen. Generates game components. consists of a new scroller and a
 * jtextfield.
 */
public class MainPane extends JFrame {
    private static final long serialVersionUID = 1L;

    // ADD TIMER FOR GAMEPANEL HERE?
    public MainPane() throws IOException {
        super("The Best Game Ever Made");
        final JPanel splashPanel = new JPanel();
        //Add Title. Below is a sprite I made but I can't figure out how to path it correctly outside my PC.
        splashPanel.add(new JLabel(new ImageIcon("C:/Users/Costa Bambakidis/Downloads/splashy (7) (2).png")));
        // final JLabel title = new JLabel("Reflex");
        // title.setHorizontalAlignment(JLabel.CENTER);
        // title.setForeground(Color.BLACK);
        // title.setFont(new Font("Serif", Font.ITALIC, 40));
        //Add instructions. 
        final JLabel instructions = new JLabel("Instructions: Click the color, not the word!");
        instructions.setForeground(Color.BLACK);
        instructions.setFont(new Font("Serif", Font.BOLD, 20));
        //Add start button. I had another custom sprite here but can't figure out how to path it.
        final JButton start = new JButton();
        JLabel startIcon = (new JLabel(new ImageIcon("C:/Users/Costa Bambakidis/Downloads/startbutton.png")));
        start.setBorder(BorderFactory.createEmptyBorder(50, 50, 40, 20));
        start.setHorizontalAlignment(JButton.CENTER);

        start.add(startIcon);
        start.setHorizontalAlignment(JButton.CENTER);
        start.setBackground(new Color(135, 130, 130));
        //Add it all to a panel and format it.
        splashPanel.setBackground(new Color(135, 130, 130));
        splashPanel.setLayout(new GridLayout(3, 0));
        // splashPanel.add(title);
        splashPanel.add(instructions);
        splashPanel.add(start);
        Splash(splashPanel);
        //Start button actionlistener.
        start.addActionListener(e -> {
            try {
                startGame();
            } catch (final IOException e1) {
                e1.printStackTrace();
            } catch (final InterruptedException ex) {
                System.err.println("Start button failed.");
            }
        });
    }

    //Starts a new game. Triggered by startbutton actionlistener.
    public void startGame() throws IOException, InterruptedException {
        this.getContentPane().removeAll();
        this.getContentPane().add(new gamePanel());
        this.getContentPane().revalidate();
    }

    // Adds the splash screen to the content pane.
    private void Splash(final JPanel x) throws IOException {
        this.getContentPane().add(x);
        this.getContentPane().setSize(400, 400);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) throws IOException {
    SwingUtilities.invokeLater(new Runnable() {
            public void run() { 
                try {
                    new MainPane();
                } catch (IOException ex) {
                    System.err.println("Failed to generate splash screen");
                }
            }
        });
    
    }
    
}
