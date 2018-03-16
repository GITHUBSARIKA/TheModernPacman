import java.awt.Graphics;

public class ObjectManager {
	PacMan pacman;
public ObjectManager(PacMan pacman) {
	this.pacman=pacman;
}
void update() {
pacman.update();	
}
void draw(Graphics g) {
	pacman.draw(g);
}
}









