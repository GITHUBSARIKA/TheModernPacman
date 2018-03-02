import java.awt.Graphics;

public class GameObject {
	 int x;

     int y;

     int width;

     int height;
public GameObject(int x, int y, int width, int height) {
	
}
void update() {
x++;	
}
void draw(Graphics g) {
	g.fillOval(x, y, 100, 100);
}
}
