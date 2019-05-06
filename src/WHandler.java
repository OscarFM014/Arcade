import java.util.LinkedList;
import java.awt.*;


public class WHandler {
	// HANDLE ALL THE OBJECTS (RENDER AND UPDATE)
	
	LinkedList<WGameObject> object = new LinkedList<WGameObject>();
	
	
	//UPDATES THE GAME OBJECTS
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			WGameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			WGameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	//CLEAR
	public void clearEnemys(){
		
		for(int i = 0; i < object.size(); i++){
			WGameObject tempObject = object.get(i);
			if (tempObject.getId() == ID.Player) {
				object.clear();
				if (WGame.gameState != WGame.STATE.End){
					addObject(new WPlayer((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
				}
				
				
			}
		}
	}
	
	//ADD OR REMOVE
	public void addObject(WGameObject object){
		this.object.add(object);
	}
	
	public void removeObject(WGameObject object){
		this.object.remove(object);
	}
	
	
	
	
	

}
