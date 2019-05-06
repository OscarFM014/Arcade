
import java.awt.*;

public class WSmartEnemy extends WGameObject {
	
	private WHandler handler;
	private WGameObject player;

	public WSmartEnemy(int x, int y, ID id, WHandler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
		}
		
		velY = 5;
		velX = 5; 
		
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,16,16); 
	}
	
	

	public void tick() {
		x += velX;
		y += velY;
		
		
		float diffX = x - player.getX() - 16;
		float diffY = y - player.getY() - 16;
		float distance = (float) Math.sqrt ( (x-player.getX()) * (x-player.getX()) + (y-player.getY()) * (y-player.getY()) );
		
		
		velX = ((-1/distance) * diffX);
		velY = ((-1/distance) * diffY);
		
		//if(y <= 0 || y >= Game.HEIGHT - 38) velY *= -1;
		//if(x <= 0 || x >= Game.WIDTH - 61) velX *= -1;
		
		
		handler.addObject(new WTrail((int)x, (int)y,ID.Trail, Color.green, 16, 16, 0.02f, handler ));
		
	}


	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}
