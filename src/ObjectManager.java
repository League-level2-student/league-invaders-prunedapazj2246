import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	int score =0;
Rocketship ship2;

ArrayList<Projectile> projectiles= new ArrayList<Projectile>();
ArrayList<Alien>aliens=new ArrayList<Alien>();

Random random = new Random();



public ObjectManager(Rocketship ship2) {
	this.ship2=ship2;
}

public void addProjectile(Projectile p){
projectiles.add(p);
}
public void addAlien() {
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
		
	
}public void update() {
	for(Alien a:aliens) {
		a.update();
		if(a.y>LeagueInvaders.HEIGHT) {
			a.isActive=false;
		}
	}
	for(Projectile p : projectiles) {
		p.update();
		if(p.y<0) {
			p.isActive=false;
		}
	}
	checkCollision();
	purgeObjects();
}


public void draw(Graphics g) {
	
	ship2.draw(g);
	for(Alien a:aliens) {
		a.draw(g);
	}
	for(Projectile p:projectiles) {
	p.draw(g);	
	}
}
public void purgeObjects() {
for (int i = 0; i < aliens.size(); i++) {
	if(!aliens.get(i).isActive) {
	aliens.remove(i);
}	
}
for (int i = 0; i < projectiles.size(); i++) {
if(!projectiles.get(i).isActive) {
	projectiles.remove(i);
}
}
}
public void checkCollision() {
	for (int i = 0; i < aliens.size(); i++) {
		if(ship2.collisionBox.intersects(aliens.get(i).collisionBox)) {
			aliens.get(i).isActive=false;
			ship2.isActive=false;
			break;
			}
		for (int j = 0; j < projectiles.size(); j++) {
			
		
		
		
		 if(projectiles.get(j).collisionBox.intersects(aliens.get(i).collisionBox)) {
			projectiles.get(j).isActive=false;
		 aliens.get(i).isActive=false;
		 score+=1;
		}
	}
		
	}
	
//	for (Alien alien : aliens) {
//		if (alien.collisionBox) {}
//		for (Projectile p : projectiles) {
//			if (p.collisionBox)
//		}
//	}
	
	
	
}

public int getScore() {
	return this.score;
}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	//System.out.println(arg0.getSource());
	addAlien();
}
}

