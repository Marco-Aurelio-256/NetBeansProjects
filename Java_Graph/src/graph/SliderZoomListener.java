/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

import static graph.Main.frame;
import static graph.Main.plane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Marco
 */
public class SliderZoomListener implements ChangeListener{
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        plane.setZoomLevel((int)source.getValue());
        
        
        //Main.plane.drawMark(Main.plane.getGraphics());
        
    }   
}
