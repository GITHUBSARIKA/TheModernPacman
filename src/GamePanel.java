import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener,MouseMotionListener {
	Timer timer;
public GamePanel () {
	timer=new Timer(1000  /60, this);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	repaint();
}
void startGame() {
	timer.start();
}

@Override

public void paintComponent(Graphics g){
g.fillOval(10, 10, 100, 100);
               

       }
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hi");
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hii");
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hiii");
}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hiiii");
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hiiiii");
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hiiiiii");
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hiiiiiii");
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hiiiiiiii");
}
@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hiiiiiiiii");
}
@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hiiiiiiiiii");
}
	
}
