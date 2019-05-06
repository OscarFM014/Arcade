
import java.awt.*;
import java.awt.image.BufferedImage;

public class WFastEnemy extends WGameObject {
	
	private WHandler handler;
	
	public WFastEnemy(int x, int y, ID id, WHandler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velY = 2;
		velX = 9; 
		
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,16,16); 
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= WGame.HEIGHT - 38) velY *= -1;
		if(x <= 0 || x >= WGame.WIDTH - 16) velX *= -1;
		
		
		handler.addObject(new WTrail((int)x, (int)y,ID.Trail, Color.CYAN, 16, 16, 0.02f, handler ));
		
	}


	public void render(Graphics g) {
		g.setColor(Color.CYAN);	
		g.fillRect((int)x,(int)y,16,16);
		
	}

}