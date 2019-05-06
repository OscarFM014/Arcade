
import java.awt.*;
import java.util.Random;

public class WEnemyBoss extends WGameObject {
	
	private WHandler handler;
	
	Random r = new Random();
	
	private int timer = 80;
	private int timer2 = 50;

	public WEnemyBoss(int x, int y, ID id, WHandler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 0; 
		velY = 2;
		
		
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,96,96 ); 
	}

	public void tick() {
		x += velX;
		y += velY;
		
		//STOP THE BOSS
		if( timer <= 0){
			velY = 0;
		}else{
			timer--;
		}
		
		if (timer <= 0){
			timer2 --;
		}
		
		if (timer2 <= 0){
			
			if (velX == 0 ){
				velX = 2;
			}
			
			if(velX > 0) velX += 0.005f;
			else if(velX < 0) velX -= 0.005f;
			
			velX = WGame.clamp(velX, -10, 10);
			
			int spawn = r.nextInt(10);
			if (spawn == 0){
				handler.addObject(new WEnemyBossBullet((int)x + 48, (int)y + 48, ID.BasicEnemy, handler));
			}
		}
		
		
		
		//if(y <= 0 || y >= Game.HEIGHT - 38) velY *= -1;
		if(x <= 0 || x >= WGame.WIDTH - 96) velX *= -1;
		
		
		handler.addObject(new WTrail((int)x, (int)y,ID.Trail, Color.red, 96, 96, 0.008f, handler ));
		
	}


	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)x, (int)y, 96, 96);
		
	}

}
