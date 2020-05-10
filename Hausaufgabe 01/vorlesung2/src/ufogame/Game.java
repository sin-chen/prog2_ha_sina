package ufogame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

//TODO die beiden imports brauchst du nicht
import java.util.concurrent.TimeUnit;
import javax.management.timer.Timer;

import view.GameFrameWork;
import view.IKeyboardListener;
import view.ITickableListener;

//TODO diesen imports brauchst du nicht
//TODO nutze strg + shift + o = organize imports
import view.Rectangle;
import view.Message;

public class Game implements ITickableListener, IKeyboardListener
{
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private ArrayList<Ufo> ufos = new ArrayList<>();
	
	private Ship ship;
	
	private int shots;

	private int screenWidth = 900;
	private int screenHeight = 700;
	private GameFrameWork frameWork = new GameFrameWork();
	
	//TODO du brauchst keinen Timer
	Timer timer = new Timer();
	
	private int score;
	
	//TODO mach die instanzvariablen private
	Message message = new Message("score: " + 0 ,700,60,30, new Color(0,255,0));
	
	Message message2 = new Message("Besiege 20 Ufos! " ,250,60,30, new Color(0,0,255));
	
	Message message3 = new Message("", 700, 600, 30, new Color(255,0,0));
	
	/*Rectangle rectangle = new Rectangle(700,30,150,50, new Color(200,200,200));*/
	
	
	public void init()
	{
		frameWork.addMessage(message);
		frameWork.addMessage(message2);
		frameWork.setSize(900, 700);
		//TODO verwende keine absoluten Pfade, ich habe die Pfade mal angepasst, so dass sie bei mir passen
		frameWork.setBackground(new Background("Hausaufgabe 01\\vorlesung2\\src\\assets\\space.png"));
		frameWork.setBackgroundColor(new Color(0, 0, 0));
		
		
		ship = new Ship((screenWidth / 2) - 30, 4 * screenHeight / 5, screenWidth/20, screenWidth/20, "Hausaufgabe 01\\vorlesung2\\src\\assets\\spaceship.png");
		frameWork.addGameObject(ship);
		
		Ufo ufo = new Ufo(-20, screenHeight/5, screenWidth/10, screenWidth/10, 10, "Hausaufgabe 01\\vorlesung2\\src\\assets\\ufo.png");
		ufos.add(ufo);
		frameWork.addGameObject(ufo);
		
		
        for(int i = 1; i < 30; i++) {
            ufos.add(new Ufo(ufos.get(i-1).getX() - 400, ufos.get(0).getY(), ufos.get(0).getWidth(), 
                    ufos.get(i-1).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
            
            frameWork.addGameObject(ufos.get(i));
        }
            		
		frameWork.addTick(this);
		frameWork.addIKeyInput(this);
	}
	
	public void shoot()
	{
		
		Projectile projectile = new Projectile(ship.getX()+11, ship.getY()+5, ship.getWidth()/2, ship.getWidth()/2, 20, "Hausaufgabe 01\\vorlesung2\\src\\assets\\projectile.png");
		projectiles.add(projectile);
		frameWork.addGameObject(projectile);
		
		
	}

	@Override
	public void tick(long elapsedTime) {

		for(Ufo ufo: ufos) {
			ufo.move();
		}
		
		  if(isCollided()) {
				score+=1;
				message.setMessage("score :" + score);	
		  }
		  
		  
		    if(sieg()) {
	        	message2.setMessage("Gewonnen!");
	        	message.setMessage("");

	        }
		    
		    //TODO verwende keine "magic numbers", erstelle eine Variable oder Konstante für die 5
		    if(shots==5) {
		    	message3.setMessage("");
		    	//TODO du brauchst hier keine for schleife, du greifst immer auf das Element 0 zu. Wenn du das Element entfernen möchtest, willst du des auch aus der ArrayListe entfernen.
		    	//TODO also:
//	    		frameWork.removeGameObject(projectiles.get(0));
//	    		projectiles.remove(0);
	    		
		    	for(Projectile p: projectiles) {
		    		frameWork.removeGameObject(projectiles.get(0));
		    		
		    	}
		    	
		    	shots = 0;
		    }
		  
		 
		  		
		/*if(ufos.size() == 0 ) {
			  Ufo ufo = new Ufo(-20, screenHeight/5, screenWidth/10, screenWidth/10, 10, "Hausaufgabe 01\\vorlesung2\\src\\assets\\ufo.png");
			  ufos.add(ufo);
			  frameWork.addGameObject(ufo);
		}*/
		
		if(ufos.get(0).getX() > screenWidth) {
			frameWork.removeGameObject(ufos.get(0));
			ufos.remove(0);
            ufos.add(new Ufo(ufos.get(ufos.size() - 1).getX() - 400, ufos.get(0).getY(), ufos.get(0).getWidth(), 
                    ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
            //TODO du fügst ufo zur Liste hinzu, die werden aber nicht angezeigt.
//			frameWork.addGameObject(ufos.get(ufos.size()-1));
            
		}
		
		for(Projectile p: projectiles) {
            p.move();
        }
		
		if(projectiles.size()>0 && projectiles.get(0).getY() < 0) {
			frameWork.removeGameObject(projectiles.get(0));
			projectiles.remove(0); 
			
		}
		
		/*if(projectiles.size()>0 && projectiles.get(0).getY() == ufos.get(0).getX()){
			frameWork.removeGameObject(ufos.get(0));
			ufos.remove(0);
			frameWork.removeGameObject(projectiles.get(0));
			projectiles.remove(0);
		}*/
		
		/*for(Ufo ufo: ufos) {
			for(Projectile p: projectiles) {
				if((p.getX() > ufo.getX() && p.getX() < (ufo.getWidth() + ufo.getX()) && ((p.getY() > ufo.getY()) && (p.getY() < (ufo.getHeight() + ufo.getY()))))) {
					frameWork.removeGameObject(p);
					frameWork.removeGameObject(ufo);
					score+=1;
				}
			}
		}*/
		
		//nur kollision wenn dieser y werte beieinander sind, an ufo vorbei tritt zweiter fall in kraft (x nur selten)
		
		
	}
	//für Keyboard Listener
	@Override
	public int[] getKeys() {
		int[] keys = {KeyEvent.VK_SPACE};
		return keys;
	}

	@Override
	public void keyDown(int key) {
		shoot();
		shots+=1;
		
	}
	
	public boolean isCollided() {
		for(Ufo ufo: ufos) {
			for(Projectile p: projectiles) {
				//TODO wenn die rechte kante des Projektils das ufo trifft und die linke kante aber nicht, wird die kollision nicht erkannt.
				if((p.getX() > ufo.getX() && p.getX() < (ufo.getWidth() + ufo.getX()) && ((p.getY() > ufo.getY()) && (p.getY() < (ufo.getHeight() + ufo.getY()))))) {
					
					frameWork.removeGameObject(ufo);
					ufos.remove(ufo);
					
					frameWork.removeGameObject(p);
					projectiles.remove(p);
					
					return true;
				}
			}
	} 
	return false;
	
}
	
	public boolean sieg() {
		//TODO verwende keine magic numbers. Siehe oben.
		if(score >= 20) {
			return true;
		} return false;

}}
