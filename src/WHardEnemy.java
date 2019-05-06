
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class WHardEnemy extends WGameObject {
	
	private WHandler handler;

	private Random r = new Random();
	
	public WHardEnemy(int x, int y, ID id, WHandler handler) {
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
		
		if(y <= 0 || y >= WGame.HEIGHT - 32){
			if (velY < 0){
				velY = -(r.nextInt(7)+1)*-1;
			}else{
				velY = (r.nextInt(7)+1)*-1;
			}
		}
		if(x <= 0 || x >= WGame.WIDTH - 16){
			if (velX < 0){
				velX = -(r.nextInt(7)+1)*-1;
			}else{
				velX = (r.nextInt(7)+1)*-1;
			}
		}
		
		handler.addObject(new WTrail((int)x, (int)y,ID.Trail, Color.BLUE, 16, 16, 0.02f, handler ));
		
	}

	public void render(Graphics g) {
		g.setColor(Color.BLUE);	
		g.fillRect((int)x,(int)y,16,16);
		
	}

}
