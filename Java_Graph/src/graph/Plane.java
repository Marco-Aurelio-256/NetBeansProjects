package graph;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Marco
 */
public class Plane extends JPanel{
    private double zoomLevel;
    
    public Plane(){
        this.zoomLevel = 5;
        init();
    }
    
    public final void init(){
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.red);
        g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
        g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
        
    }
    
    public void drawMark(Graphics g){
        for(int x=0; x <= 50; x+=zoomLevel){
            g.fillRect(
                    (int)coord_x_zoom(x), 
                    (int)coord_y(0)-3, 
                    1, 
                    8);
            
            g.fillRect(
                    (int)coord_x_zoom(-x), 
                    (int)coord_y(0)-3, 
                    1, 
                    8);
        }    
    }
    
    public void drawFunction(Graphics g){
        int initial_x = 0;
        int initial_y = 0;
        
        int final_x = this.getWidth();
        int final_y = this.getHeight();
        
        double function_x_start = -2-initial_y;
        double function_y_start = -2-initial_x;
        
        double function_x_middle = -2-final_x;
        double function_y_middle = -2-final_y;
        
        g.setColor(Color.green);
        
        g.drawLine(
                (int)coord_x(function_x_start),
                (int)coord_y(function_y_start),
                (int)coord_x(function_x_middle),
                (int)coord_y(function_y_middle)   
        );
        /**
        g.drawLine(
                function_x_start,
                function_y_start,
                function_x_end,
                function_y_end         
        );
        **/
    }
    
    private double coord_x(double x){
        double real_x = (x+this.getWidth()/2);
        return real_x;
    }
    
    private double coord_y(double y){
        double real_y = (-y+this.getHeight()/2);
        return (real_y);
    }
    
    private double coord_x_zoom(double x){
        double real_x = (x+this.getWidth()/2)+zoomLevel;
        return real_x;
    }
    
    private double coord_y_zoom(double y){
        double real_y = (-y+this.getHeight()/2)+zoomLevel;
        return (real_y);
    }

    public double getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLevel(double zoomLevel) {
        this.zoomLevel = zoomLevel;
    }
}
