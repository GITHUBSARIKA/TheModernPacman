import java.awt.Dimension;

import javax.swing.JFrame;

public class Modern {
	JFrame frame;
	final static int width=1000;
	final static int height=1000;
	GamePanel gamepanel=new GamePanel();
	
	public Modern(){
		frame=new JFrame();
		
	}
public static void main(String[] args) {
	Modern modern=new Modern();
	modern.setup();
}
void setup() {
	frame.add(gamepanel);
	frame.addKeyListener(gamepanel);
	frame.addMouseListener(gamepanel);
	frame.addMouseMotionListener(gamepanel);
	frame.getContentPane().setPreferredSize(new Dimension(width, height));

    frame.pack();
gamepanel.startGame();

	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
}
