package org.thrawn.player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

import org.lwjgl.input.Mouse;

public class MouseControls extends JFrame implements MouseMotionListener{
    
    int my;
    int mx;
    
    Mouse mouse;
    
    @Override
    public void mouseDragged(MouseEvent e) {
       mx = e.getX();
       my = e.getY();
       e.consume();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       mx = e.getX();
       my = e.getY();
       e.consume();
    }
}



