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
	g.setColor(new Color(204, 51, 153));
	g.fillOval(x, y,width, height);
	System.out.println("unicorns");
	System.out.println(x);
	System.out.println(y);
}
}
