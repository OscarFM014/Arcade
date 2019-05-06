
import java.awt.*;
import java.util.*;

public class WMenuParticle extends WGameObject {
	
	private WHandler handler;
	
	Random r = new Random();
	
	private int red = r.nextInt(255);
	private int blue = r.nextInt(255);
	private int green = r.nextInt(255); 
	private Color color;
	

	public WMenuParticle(int x, int y, ID id, WHandler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(5 - -5) + -5);
		velY = (r.nextInt(5 - -5) + -5);
		
		if(velX == 0) velX = 1;
		if(velX == 0) velX = 1;
		
		
		color = new Color(red, green, blue);
		
		
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,16,16); 
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= WGame.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= WGame.WIDTH - 16) velX *= -1;
		
		
		handler.addObject(new WTrail((int)x, (int)y,ID.Trail, color, 16, 16, 0.05f, handler ));
		
	}


	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}
