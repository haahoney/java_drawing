 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JToolBar;
 
public class GToolBar extends JToolBar {
 
 private GDrawingPanel drawingPanel;
 private JButton rectangleButton, ellipseButton, lineButton;
 
 private JButton red, yellow, blue, black, white;
 
 public GToolBar() {
  ActionHandler action = new ActionHandler();
  
  this.rectangleButton = new JButton( "네모" );
  this.rectangleButton.addActionListener(action);
  this.add(this.rectangleButton);
  
  this.ellipseButton = new JButton( "원" );
  this.ellipseButton.addActionListener(action);
  this.add(this.ellipseButton);
  
  this.lineButton = new JButton( "선" );
  this.lineButton.addActionListener(action);
  this.add(this.lineButton);
  
  ColorHandler color = new ColorHandler();
  
  this.red = new JButton("빨강");
  this.red.setBackground(Color.red);
  this.red.addActionListener(color);
  this.add(this.red);
  
  this.yellow = new JButton("노랑");
  this.yellow.setBackground(Color.yellow);
  this.yellow.addActionListener(color);
  this.add(this.yellow);
  
  this.blue = new JButton("파랑");
  this.blue.setBackground(Color.blue);
  this.blue.addActionListener(color);
  this.add(this.blue);
  
  this.black = new JButton("검정");
  this.black.setBackground(Color.black);
  this.black.addActionListener(color);
  this.add(black);
  
  this.white = new JButton("하양");
  this.white.setBackground(Color.white);
  this.white.addActionListener(color);
  this.add(this.white);
  
 }
 
 public void setAssociation( GDrawingPanel drawingPanel ) {
  this.drawingPanel = drawingPanel;
 }
 
 class ActionHandler implements ActionListener{
  @Override
  public void actionPerformed(ActionEvent e) {
   drawingPanel.setCurrentTool(e.getActionCommand());
  }
 }
 
 class ColorHandler implements ActionListener{
  @Override
  public void actionPerformed(ActionEvent e) {
   drawingPanel.setCurrentColor(e.getActionCommand());
  }
 }
}