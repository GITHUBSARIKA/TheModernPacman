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
		 g.drawImage(GamePanel.golddImg, x, y, width, height, null);

	}
}
