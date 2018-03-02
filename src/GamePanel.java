import java.awt.Color;
import java.awt.Font;
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
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;
	
	int currentState=MENU_STATE;
	
	Font titlefont;
	
	Font subtitlefont;
	
	Font subsubtitlefont;


public GamePanel () {
	timer=new Timer(1000  /60, this);
	titlefont=new Font("Arial",titlefont.PLAIN,40);
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	repaint();
	if(currentState == MENU_STATE){

        updateMenuState();

}else if(currentState == GAME_STATE){

        updateGameState();

}else if(currentState == END_STATE){

        updateEndState();

}


	  
}
void startGame() {
	timer.start();
}

@Override

public void paintComponent(Graphics g){
	if(currentState == MENU_STATE){

        drawMenuState(g);

}else if(currentState == GAME_STATE){

        drawGameState(g);

}else if(currentState == END_STATE){

        drawEndState(g);

}


               

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
	if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		currentState++;
		if(currentState > END_STATE){

        currentState = MENU_STATE;
        

}

	}
	


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
	

void updateMenuState() {
	
}
void updateGameState() {
	
}
void updateEndState() {
	
}
void drawMenuState(Graphics g) {
	g.setColor(Color.CYAN);
	g.fillRect(0, 0, Modern.width, Modern.height);
	g.setColor(Color.BLACK);
	g.setFont(titlefont);
	g.drawString("The Modern Pacman", 40, 100);
	g.setColor(Color.BLACK);
	g.setFont(subtitlefont);
	g.drawString("Press Enter to Start", 40, 300);
	g.setColor(Color.BLACK);
	g.setFont(subsubtitlefont);
	g.drawString("Press Space for instructions", 10, 500);
	
	
}
void drawGameState(Graphics g) {
	g.setColor(Color.PINK);
	g.fillRect(0, 0, Modern.width, Modern.height);
}
void drawEndState(Graphics g) {
	g.setColor(Color.GREEN);
	g.fillRect(0, 0, Modern.width, Modern.height);	
	g.setColor(Color.BLACK);
	g.setFont(titlefont);
	g.drawString("You suck at this game", 40, 100);
	g.setColor(Color.BLACK);
	g.setFont(subtitlefont);
	g.drawString("You lose", 40, 300);
	g.setColor(Color.BLACK);
	g.setFont(subsubtitlefont);
	g.drawString("Press enter to play again", 10, 500);
	
}}

