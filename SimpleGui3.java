import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

final public class SimpleGui3 
{
 JFrame frame;
 DrawPanel drawPanel;
 private double a = 0;
 public static void main (String[] args)
 {
  
  new SimpleGui3().go();
 }
 
 public void go() 
 {
  
  frame = new JFrame("SimpleGui3");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  drawPanel = new DrawPanel();
  frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
  frame.setSize(2000,1250);
  frame.setVisible(true);
  moveIt();
 }

class DrawPanel extends JPanel 
{ 
private static final long serialVersionUID = 1L;

public void paintComponent(Graphics g)
 { 
  double xn,yn;
  double xn1, yn1;
  double orb;
  int x,y;
  int scale = 200;
  int posx = 700, posy = 400;
  //double b = Math.random();
  double i;
  super.paintComponent(g);
  this.setBackground(Color.WHITE); 
  g.setColor(Color.BLUE);   
  for(i=-3; i<=3; i=i+0.02)
  {
   xn=i;
   yn=i;
   for(orb=1; orb<=5000; orb++)
   {
    xn1 = xn * (Math.cos(a)) - (yn - (Math.pow(xn,2))) * (Math.sin(a));
    yn1 = xn * (Math.sin(a)) + (yn - (Math.pow(xn,2))) * (Math.cos(a));
    xn=xn1;
    yn=yn1;
    if(xn<-10 || xn>10 || yn<-10 || yn>10)
    {
     yn=0;
    }
    x = (int)(xn*scale);
    y = (int)(yn*scale);
    g.drawLine(x + posx,y + posy,x + posx,y + posy);
   }   
  }
 }
}
 private void moveIt() 
 {
 while(a < 2*3.1415926535 )
{
 a = a + 0.000872664625;
         try
            {
                Thread.sleep(10);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
 frame.repaint();
 }
}
}
