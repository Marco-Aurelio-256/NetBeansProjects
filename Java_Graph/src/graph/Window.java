package graph;

import static graph.Main.frame;
import static graph.Main.plane;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;


/**
 *
 * @author Marco
 */
public class Window extends JFrame implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.removeAll();
        frame.revalidate();
        
        plane.drawMark(plane.getGraphics());
    }

}
