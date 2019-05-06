import java.awt.*;
import java.util.Random;

public class WEnemyBossBullet extends WGameObject {
	
	private WHandler handler;
	Random r = new Random();

	public WEnemyBossBullet(int x, int y, ID id, WHandler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(5 - -5) + -5); //RANDOM (-5,5) 
		velY = 5; 
		
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,16,16); 
	}

	public void tick() {
		x += velX;
		y += velY;
		
		//if(y <= 0 || y >= Game.HEIGHT - 38) velY *= -1;
		//if(x <= 0 || x >= Game.WIDTH - 61) velX *= -1;
		
		if (y >= WGame.HEIGHT){
			handler.removeObject(this);
		}
		
		
		handler.addObject(new WTrail((int)x, (int)y,ID.Trail, Color.cyan, 16, 16, 0.02f, handler ));
		
	}


	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}
