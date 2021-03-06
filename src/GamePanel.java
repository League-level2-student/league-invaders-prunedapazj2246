import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	
	//Projectile p = new Projectile(x+width/2, y, 10, 10);
	
	
	
	Rocketship ship = new Rocketship(250,750,50,50);
	
 ObjectManager oB=new ObjectManager(ship);
	
 Timer frameDraw = new Timer(1000/60,this);
	Timer alienSpawn= new Timer(1000 ,oB);
 
	Font titleFont = new Font("Arial",Font.PLAIN, 48);
		Font directionFont = new Font("Arial", Font.PLAIN, 25);
   
		final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState=MENU;
    
    public GamePanel() {
    	frameDraw.start();
    	if (needImage) {
    	    loadImage ("space.png");
    	}
    }
    
    public void startGame(){
        
        alienSpawn.start();
    }
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
		oB.update();
		//System.out.println("update");
		if(!ship.isActive) {
			currentState=END;
			alienSpawn.stop();
		}
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
		//g.setColor(Color.BLACK);
		//g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		if (gotImage) {
			g.drawImage(image,0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		oB.draw(g);
	}
	void drawEndState(Graphics g)  {  
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 115, 150);
		g.setFont(directionFont);
		g.setColor(Color.BLACK);
		g.drawString("You killed 0 enemies", 125, 300);
		g.setFont(directionFont);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to restart", 100, 450);
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
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
		//System.out.println("action");
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		
		    if (currentState == END) {
		        currentState = MENU;
		        ship = new Rocketship(250,750,50,50);
		        System.out.println("restart");
		        oB=new ObjectManager(ship);
		        alienSpawn.addActionListener(oB);
		    } else {
		        currentState++;
		    }
			if(currentState==GAME) {
				startGame();
				
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    ship.up();
		    if(ship.y<=0 ) {
		    ship.y=0;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    ship.down();
		   if(ship.y>=750) {
		    ship.y=750;
		   }
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    ship.right();
		    if(ship.x>=450 ) {
			    ship.x=450;
			    }
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    ship.left();
		    if(ship.x<=0 ) {
			    ship.x=0;
			    }
		}
	
		if(currentState==GAME&& e.getKeyCode()==KeyEvent.VK_SPACE) {
			oB.addProjectile(ship.getProjectile());
			
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


