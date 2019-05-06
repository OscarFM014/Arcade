
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WKeyInput extends KeyAdapter{
	
	private WHandler handler;
	private boolean[] keyDown = new boolean[4];
	WGame game;
	
	
	//WE CHECK WHAT KEY IS PRESS 
	public WKeyInput(WHandler handler, WGame game){
		this.handler = handler; 
		this.game = game; 
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		
	}
	
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		//CHECK THE ID FOR MOVE THE OBJECT
		for (int i = 0; i < handler.object.size(); i ++){
			WGameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				if (key == KeyEvent.VK_W) { tempObject.setVelY(-5); keyDown[0] = true;}
				if (key == KeyEvent.VK_S) { tempObject.setVelY(5); keyDown[1] = true;}
				if (key == KeyEvent.VK_D) { tempObject.setVelX(5); keyDown[2] = true;}
				if (key == KeyEvent.VK_A) { tempObject.setVelX(-5); keyDown[3] = true;}
				
			}
			
			
			//PAUSED
			if (key == KeyEvent.VK_P){
				if(game.gameState == WGame.STATE.Game){
					if (WGame.paused) WGame. paused = false;
					else WGame.paused = true; 
				}
			} 
			if (key == KeyEvent.VK_ESCAPE) System.exit(1);
			
		}
		 
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i ++){
			WGameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				if (key == KeyEvent.VK_W) keyDown[0] = false;//tempObject.setVelY(0);
				if (key == KeyEvent.VK_S) keyDown[1] = false;//tempObject.setVelY(0);
				if (key == KeyEvent.VK_D) keyDown[2] = false; //tempObject.setVelX(0);
				if (key == KeyEvent.VK_A) keyDown[3] = false;//tempObject.setVelX(0);
				
				
				//VERTICAL
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				//HORIZONTAL
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
		}
		 
	}
 }
}
