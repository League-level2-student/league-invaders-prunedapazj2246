import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	Timer frameDraw
	frameDraw = new Timer(1000/60,this);
	frameDraw.start();
		Font titleFont = new Font("Arial",Font.PLAIN, 48);
		Font directionFont = new Font("Arial", Font.PLAIN, 25);
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState=MENU;
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	void updateMenuState() {
		
	}
	void updateGameState(){
		
	}
	void updateEndState() {
		
	}
	void drawMenuState(Graphics g) {  
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 50, 150);
		g.setFont(directionFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start", 125, 300);
		g.setFont(directionFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE for instructions", 75, 450);
	}
	void drawGameState(Graphics g) {  
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}
	void drawEndState(Graphics g)  {  
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 50, 150);
		g.setFont(directionFont);
		g.setColor(Color.BLACK);
		g.drawString("You killed 0 enemies", 125, 300);
		g.setFont(directionFont);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to restart", 75, 450);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}	
	}
}

