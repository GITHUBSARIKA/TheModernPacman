import java.awt.Color;
import java.awt.Graphics;

public class Gold extends GameObject {
	public Gold(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	void update() {
      super.update();
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawRect(x, y, width, height);

	}
}
