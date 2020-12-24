import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
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
}
public void draw(Graphics g) {
	Rocketship r =new Rocketship(250,750,50,50);
	r.draw(g);
	for(Alien a:aliens) {
		a.draw(g);
	}
	for(Projectile p:projectiles) {
	p.draw(g);	
	}
}
public void purgeObjects() {
for (int i = 0; i < aliens.size(); i++) {
	if(aliens.get(i).isActive==false) {
	aliens.remove(i);
}	
}
for (int i = 0; i < aliens.size(); i++) {
if(projectiles.get(i).isActive==false) {
	projectiles.remove(i);
}
}
}
}

