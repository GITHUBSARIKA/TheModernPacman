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
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
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

	public static BufferedImage rainbowblockImg;

	public static BufferedImage pacman222Img;

	public static BufferedImage golddImg;

	public static BufferedImage smudgeartImg;

	int currentLevel = 1;

	boolean nodying = true;
	
	long nodyingtimer=0;

	ArrayList<Gold> goldz = new ArrayList<Gold>();
	ArrayList<ObstacleBlocks> block = new ArrayList<ObstacleBlocks>();

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		titlefont = new Font("Arial", titlefont.PLAIN, 40);
		initializeGame();
		try {

			rainbowblockImg = ImageIO.read(this.getClass().getResourceAsStream("rainbowblock.png"));

			golddImg = ImageIO.read(this.getClass().getResourceAsStream(".png.png"));

			pacman222Img = ImageIO.read(this.getClass().getResourceAsStream("pacman222.png"));

			smudgeartImg = ImageIO.read(this.getClass().getResourceAsStream("smudgeart.png"));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	void initializeGame() {
		goldz = new ArrayList<Gold>();
		block = new ArrayList<ObstacleBlocks>();
		for (int i = 0; i < 30; i++) {
			Random random = new Random();
			int x = random.nextInt(Modern.width);
			int y = random.nextInt(Modern.height);
			goldz.add(new Gold(x, y, 20, 20));

		}
		for (int j = 0; j < currentLevel * 3; j++) {
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
		if (System.currentTimeMillis()-nodyingtimer<5000) {
			nodying=true;
		}else {
			nodying=false;
		}

	}

	void startGame() {
		timer.start();
		nodyingtimer=System.currentTimeMillis();
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
				pacman = new PacMan(300, 300, 50, 50);
				initializeGame();
				nodyingtimer=System.currentTimeMillis();

			}

		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			JOptionPane.showMessageDialog(null,
					"Welcome to the game, Modern Pacman.\n The goal of this game is to get all the gold pieces that are yellow and orange and scattered around on the game screen.\n There are also obstacle blocks that are rainbow colors and get in your way because if you bump into them you lose.\n You can drag your mouse to get your pacman around.\n This game will also take you through a series of levels.\n The first five seconds of your will be your time to rest, nothing can kill you, but after that, the real game starts.\n Have Fun:) ");

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
		for (int j = 0; j < block.size(); j++) {
			if (pacman.collisionBox.intersects(block.get(j).collisionBox)) {

				currentState = END_STATE;
				

			}
		}

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
		g.drawImage(GamePanel.smudgeartImg, 0, 0, Modern.width, Modern.height, null);
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
		// g.drawString("You suck at this game", 40, 100);
		g.setColor(Color.BLACK);
		g.setFont(subtitlefont);
		// g.drawString("You lose", 40, 300);
		g.setColor(Color.BLACK);
		g.setFont(subsubtitlefont);
		g.drawString("Press enter to play again", 10, 500);
		if (goldz.isEmpty()) {
			g.drawString("You win", 40, 300);
		}else {
			g.drawString("You Lose", 40, 300);
		}
		
		if (pacman.isAlive) {
			g.drawString("You are amazing at this game", 40, 100);
		} else {
			g.drawString("You suck at this game so you have to try again.", 40, 100);
		}

	}

	void checkCollision() {
System.out.println(pacman.isAlive);
		for (Gold a : goldz) {

			if (pacman.collisionBox.intersects(a.collisionBox)) {

				a.isAlive = false;

			}
		}
		if (!nodying) {
          System.out.println("what");
			for (ObstacleBlocks b : block) {

				if (pacman.collisionBox.intersects(b.collisionBox)) {
               
					pacman.isAlive = false;

				}

			}
		}

	}

	void purgeObject() {
		for (int i = 0; i < goldz.size(); i++) {
			if (pacman.collisionBox.intersects(goldz.get(i).collisionBox)) {

				goldz.remove(i);

			}
		}
		
			if (!pacman.isAlive) {

				currentState = END_STATE;

			}
		
		System.out.println(goldz.size());
		if (goldz.isEmpty()) {

			currentState = END_STATE;

		}

	}
}
