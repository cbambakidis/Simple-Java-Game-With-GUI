package bambakidis_project2;



import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 *
 * @author Costa Bambakidis
 */
public class button extends JButton {

    private final Color thisColor;

    public button(final Color x) {
        super.setBackground(x);
        this.setOpaque(true);
        this.setBackground(x);
        thisColor = x;
    }

    //Controls score and acts as game restart button.
    public void instantinate(final scroller x) {
        this.addActionListener(e -> {
            if (thisColor == x.getColor()) {
                x.addPoint();
            }
            if (x.isGameOver() == true) {
  
                }
            }
            
        );
    }

    public Color getColor() {
        return thisColor;
    }

//panel of buttons with colots. in gridlayout. each button will have an actionlisetener, that will return a color to be compared with inut textfiedl
    //actionlistener for enter. clears textfield and sets next word. 
}
