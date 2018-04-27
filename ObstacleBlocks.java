import java.awt.Color;
import java.awt.Graphics;

public class ObstacleBlocks extends GameObject {
	int speed;

	public ObstacleBlocks(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	void update() {
		super.update();
       x+=speed;
      if (x>Modern.width) {
		speed=-10;
	}
      if (x<0) {
  		speed=10;
  	}
      
      
	}

	void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
	}
}