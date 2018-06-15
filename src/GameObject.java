import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GameObject {
	 int x;

     int y;

     int width;

     int height;
     
     boolean isAlive=true;
     
     Rectangle collisionBox;
public GameObject(int x, int y, int width, int height) {
	collisionBox=new Rectangle(x, y, width, height);
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
}
void update() {
	
	 collisionBox.setBounds(x, y, width, height);
	 
}
void draw(Graphics g) {
	Graphics2D g2 = (Graphics2D) g;
	g2.setColor(Color.CYAN);
	g2.draw(collisionBox);
}
}
