
import java.awt.*;
import java.awt.image.BufferedImage;

public class WBasicEnemy extends WGameObject {
	
	private WHandler handler;
	
	public WBasicEnemy(int x, int y, ID id, WHandler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velY = 5;
		velX = 5; 
		
		
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,16,16); 
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= WGame.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= WGame.WIDTH - 16) velX *= -1;
		
		
		handler.addObject(new WTrail((int)x, (int)y,ID.Trail, Color.red, 16, 16, 0.02f, handler ));
		
	}


	public void render(Graphics g) {
		g.setColor(Color.RED);	
		g.fillRect((int)x,(int)y,16,16);
	}

}