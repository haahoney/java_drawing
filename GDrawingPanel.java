	
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
 
import javax.swing.JPanel;
 
 
public class GDrawingPanel extends JPanel {
 private String currentTool;
 private Color color;
 
 private MouseHandler mouseHandler;
 
 public GDrawingPanel(){
  this.currentTool = "네모";
  this.color = Color.white;
 
  this.mouseHandler = new MouseHandler();
  this.addMouseListener( this.mouseHandler );
  this.addMouseMotionListener( this.mouseHandler );
 }
 
 public void setCurrentTool(String currentTool){
  this.currentTool = currentTool;
 }
 
 public void setCurrentColor(String colorname) {
  if (colorname.equals("빨강") ) color = Color.red;
  else if (colorname.equals("노랑") ) color = Color.yellow;
  else if (colorname.equals("파랑") ) color = Color.blue;
  else if (colorname.equals("검정") ) color = Color.black;
  else if (colorname.equals("하양") ) color = Color.white;
 }
 
 public void draw( int x, int y, int width, int height) {
  Graphics g = getGraphics();
  
  g.setXORMode(getBackground());
  g.setColor(color);
  
  if ( currentTool.equals("네모") ) {
   g.fillRect(x, y, width, height);
  }
  else if ( currentTool.equals("원") ) {
   g.fillOval(x, y, width, height);
  }
  else if ( currentTool.equals("선")) {
   g.drawLine(x, y, x + width, y + width);
  }
 }
 
 class MouseHandler implements MouseMotionListener, MouseListener{
 
  private int x1, y1, w, h;
  
  @Override
  public void mouseDragged(MouseEvent e) {
   draw( x1, y1, w, h);
   
   int x2 = e.getX();
   int y2 = e.getY();
   
   w = x2 - x1;
   h = y2 - y1;
   
   draw( x1, y1, w, h);
  }
 
  @Override
  public void mouseMoved(MouseEvent e) {}
  @Override
  public void mouseClicked(MouseEvent e) {}
 
  @Override
  public void mousePressed(MouseEvent e) {
   this.x1 = e.getX();
   this.y1 = e.getY();
   
   w = 0;
   h = 0;
  }
 
  @Override
  public void mouseReleased(MouseEvent e) {}
  @Override
  public void mouseEntered(MouseEvent e) {}
  @Override
  public void mouseExited(MouseEvent e) {}
 }
}