package graph;

import javax.swing.*;
import java.awt.*;



/**
 *
 * @author Marco
 */
public class Main {
    static final int ZOOM_MIN = 1;
    static final int ZOOM_MAX = 100;
    static final int ZOOM_INIT = 1;
 
    public static Plane plane;
    public static Window frame;
    
    public static void main(String[] args){
        frame = new Window();
        frame.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 600, 600);
        frame.setLayout(new BorderLayout());
        plane = new Plane();
        
        JButton start = new JButton("Iniciar");
        start.addActionListener(frame);
        start.setText("Iniciar");
        
        SliderZoomListener sliderZoomListener = new SliderZoomListener();
        JSlider sliderZoom = new JSlider(
                JSlider.HORIZONTAL,
                ZOOM_MIN,
                ZOOM_MAX,
                ZOOM_INIT
        );
        
        sliderZoom.addChangeListener(sliderZoomListener);
        sliderZoom.setMajorTickSpacing(10);
        sliderZoom.setMinorTickSpacing(1);
        sliderZoom.setPaintTicks(true);
        sliderZoom.setPaintLabels(true);

        frame.add( plane, BorderLayout.CENTER);
        frame.add(start, BorderLayout.SOUTH);
        frame.add(sliderZoom, BorderLayout.NORTH);
        frame.setVisible( true );

    }
}
