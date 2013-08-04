package org.player;

public class Controls{
 
 public boolean mouseActive = false;
 
 public mousing(Display f, Images i){
  f.addKeyListener(new KeyAdapter()
  public void KeyPressed(KeyEvent e){
   if(e.getKeyCode() == KeyEvent.VK_M)
    mousActive = true;
  });
  
  
 }
 
 
 
 
 
 
 
 
 
 
 
 
}
