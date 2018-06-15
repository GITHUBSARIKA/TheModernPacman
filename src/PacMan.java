import java.awt.Color;
import java.awt.Graphics;

public class PacMan extends GameObject {
	int speed;
public PacMan(int x, int y, int width, int height) {
	super(x, y, width, height);
	speed=5;
}
void update() {
	super.update();
}
void draw(Graphics g) {
	//super.draw(g);
g.drawImage(GamePanel.pacman222Img, x, y, width, height, null);
}
}
