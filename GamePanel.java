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
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
	Timer timer;
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;

	int currentState = MENU_STATE;

	Font titlefont;

	Font subtitlefont;

	Font subsubtitlefont;

	PacMan pacman = new PacMan(300, 300, 50, 50);

	ObjectManager objectmanager = new ObjectManager(pacman);

	ArrayList<Gold> goldz = new ArrayList<Gold>();
	ArrayList<ObstacleBlocks> block = new ArrayList<ObstacleBlocks>();

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		titlefont = new Font("Arial", titlefont.PLAIN, 40);
		initializeGame();
	}

	void initializeGame(){
		goldz= new ArrayList<Gold>();
		block=new ArrayList<ObstacleBlocks>();
		for (int i = 0; i < 60; i++) {
			Random random = new Random();
			int x = random.nextInt(Modern.width);
			int y = random.nextInt(Modern.height);
			goldz.add(new Gold(x, y, 20, 20));

		}
		for (int j = 0; j < 1; j++) {
			Random random2 = new Random();
			int X = random2.nextInt(Modern.width);
			int Y = random2.nextInt(Modern.height);
			block.add(new ObstacleBlocks(X, Y, 20, 75));

		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}

	}

	void startGame() {
		timer.start();
	}

	@Override

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {

				currentState = MENU_STATE;
				  pacman= new PacMan( 300,  300,  50,  50);
				  initializeGame();

			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	
		pacman.x = e.getX();
		pacman.y = e.getY();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	void updateMenuState() {
		
	}

	void updateGameState() {
		pacman.update();
	

		for (int i = 0; i < block.size(); i++) {
			ObstacleBlocks ob = block.get(i);
			ob.update();
		}	
		checkCollision();

		purgeObject();

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
		pacman.draw(g);
		System.out.println(goldz.size());
		for (int i = 0; i < goldz.size(); i++) {
			Gold s = goldz.get(i);

			s.draw(g);
		}
		for (int j = 0; j < block.size(); j++) {
			ObstacleBlocks ob = block.get(j);
			ob.draw(g);
		}

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

	}

	void checkCollision() {

		for (Gold a : goldz) {

			if (pacman.collisionBox.intersects(a.collisionBox)) {

				a.isAlive = false;

			}
		}
		for (ObstacleBlocks b : block) {

			if (pacman.collisionBox.intersects(b.collisionBox)) {

				pacman.isAlive = false;

			}
			
		}

	}

	void purgeObject() {
		for (int i = 0; i < goldz.size(); i++) {
			if (pacman.collisionBox.intersects(goldz.get(i).collisionBox)) {

				goldz.remove(i);

			}
		}
		for (int j = 0; j < block.size(); j++) {
			if (pacman.collisionBox.intersects(block.get(j).collisionBox)) {

				currentState = END_STATE;

			}
		}
		System.out.println(goldz.size());
			if (goldz.isEmpty()) {

				currentState = END_STATE;
				

			}
		

	}
}