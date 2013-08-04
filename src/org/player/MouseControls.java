package testing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

public class Testing extends JFrame implements MouseMotionListener{
    
    int my;
    int mx;
    
    @Override
    public void mouseDragged(MouseEvent e) {
       mx = e.getX();
       my = e.getY();
        mouseDragged = true;
        
        
        e.consume();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       mx = e.getX();
       my = e.getY();
        mouseDragged = false;
       
       
       e.consume();
    }




