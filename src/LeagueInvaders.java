import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel gP;
	public static final int WIDTH=500;
	public static final int HEIGHT=800;
	Dimension d =new Dimension(WIDTH, HEIGHT);
public static void main(String[] args) {
	LeagueInvaders lI = new LeagueInvaders();
	lI.setup();
}

public LeagueInvaders(){
	this.frame=new JFrame();
this.gP=new GamePanel();

}
public void setup() {
	//gP.setPreferredSize(d);
	frame.add(gP);
	frame.setSize(WIDTH,HEIGHT);
	frame.addKeyListener(gP);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}

