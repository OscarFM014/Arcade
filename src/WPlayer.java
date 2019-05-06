import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class WPlayer extends WGameObject {
	
	Random r = new Random();
	WHandler handler;

	public WPlayer(int x, int y, ID id, WHandler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int) x,(int)y,32,32); 
	}

	public void tick() {
		x += velX;
		y += velY;
		
		
		x = WGame.clamp((int)x, 0, WGame.WIDTH - 38);
		y = WGame.clamp((int)y, 0, WGame.HEIGHT - 61);
		
		handler.addObject(new WTrail((int)x, (int)y,ID.Trail, Color.white, 32, 32, 0.05f, handler ));
		
		collision();
	}
	
	private void collision(){
		//PASS OVER THE OBJECTS
		for (int i = 0; i < handler.object.size(); i ++){
			WGameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy){//JUST A BASIC ENEMY
				//COLLISION CODE
				if(getBounds().intersects(tempObject.getBounds())){
					WHUD.HEALTH -= 2;
				}
			}
		}
	}

	
	 public void render(Graphics g) {
		g.setColor(Color.RED);	
		g.drawRect((int)x,(int)y,32,32);
		//else if (id == ID.Player2)g.setColor(Color.PINK);
	}

}
