package facebook_GraphicInterface;
import java.awt.*;
import java.awt.event.*;

// Driver class
public class ChangeColor {
  public static void main(String[] args) {
    Frame f = new ChangeColorFrame("Change Color");
    f.setSize(300, 450);
    f.setVisible(true);
  }
}

//Frame class
class ChangeColorFrame extends Frame {
public ChangeColorFrame(String title) {
 // Set title, layout, and background color
 super(title);
 setLayout(new FlowLayout());
 setBackground(Color.white);

 // Add "Change color" button to frame and attach listener
 Button b = new Button("Change color");
 add(b);
 b.addActionListener(new ButtonListener());

 // Attach window listener
 addWindowListener(new WindowCloser());
}
//Listener for button
class ButtonListener implements ActionListener {
 public void actionPerformed(ActionEvent evt) {
   if (getBackground() == Color.white)
     setBackground(Color.black);
   else
     setBackground(Color.white);
 }
}

// Listener for window
class WindowCloser extends WindowAdapter {
 public void windowClosing(WindowEvent evt) {
   System.exit(0);
 }
}
}
