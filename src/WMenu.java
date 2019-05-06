import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class WMenu extends MouseAdapter {
	
	//JUEGO
	private WGame game;
	
	//HANDLER
	private WHandler handler;
	
	//RANDOM
	private Random r = new Random();
	
	//HUD
	private WHUD hud;
	
	public WMenu(WGame game, WHandler handler, WHUD hud ){
		this.game = game ;
		this.hud = hud;
		this.handler = handler ;
	}
	public void mousePressed(MouseEvent e){}
	
	public void mouseReleased(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
	//MENU
		
		if (game.gameState == WGame.STATE.Menu){
			//PLAY BUTTON 
			if (mouseOver(mx, my, 210, 150, 200, 64 )){
				game.gameState = WGame.STATE.Select;
				return;
			}
			
			//HELP
			if (mouseOver(mx, my, 210, 250, 200,  64 )){
				game.gameState = WGame.STATE.Help;
			}
			
			//QUIT BUTTON
			if (mouseOver(mx, my, 210, 350, 200, 64 )){
				System.exit(1);
			}
			
			
		}
		
		
	//SELECT
		if (game.gameState == WGame.STATE.Select){
			//NORMAL BUTTON 
			if (mouseOver(mx, my, 210, 150, 200, 64 )){
				game.gameState = WGame.STATE.Game;
				handler.addObject(new WPlayer((WGame.WIDTH)/2 - 32, (WGame.HEIGHT) / 2 - 32, ID.Player, handler));
				handler.clearEnemys();	
				handler.addObject(new WBasicEnemy(r.nextInt(WGame.WIDTH - 50), r.nextInt(WGame.HEIGHT- 50), ID.BasicEnemy, handler));
				game.diff = 0;
			}
			
			//HARD BUTTON
			if(mouseOver(mx, my, 210, 250, 200, 64)){
				game.gameState = WGame.STATE.Game;
				handler.addObject(new WPlayer((WGame.WIDTH)/2 - 32, (WGame.HEIGHT) / 2 - 32, ID.Player, handler));
				handler.clearEnemys();	
				handler.addObject(new WHardEnemy(r.nextInt(WGame.WIDTH - 50), r.nextInt(WGame.HEIGHT- 50), ID.BasicEnemy, handler));
				game.diff = 1;
			}
			
			
			//BACK BUTTON
			if (mouseOver(mx, my, 210, 350, 200, 64 )){
				if (mouseOver(mx, my, 210, 350, 200, 64 )){
					game.gameState = WGame.STATE.Menu;
					return;
				}
			}
		}
		
		
		//BACK BUTTON IN HELP 	
		if (game.gameState == WGame.STATE.Help){
			if (mouseOver(mx, my, 210, 350, 200, 64 )){
				game.gameState = WGame.STATE.Menu;
				return;
			}
		}
		
		
		//BACK BUTTON IN HELP 	
		if (game.gameState == WGame.STATE.End){
			if (mouseOver(mx, my, 210, 350, 200, 64 )){
					game.gameState = WGame.STATE.Menu;
					hud.setLevel(1);
					hud.setScore(0);
			}
		}
		
		
	}
	
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int heigth){
		if(mx > x && mx < x + width){
			if (my > y && my < y + heigth){
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick(){
		
	}

	public void render(Graphics g){
		Font fnt = new Font("Impact", 1, 50);
		Font fnt2 = new Font("Impact", 1, 30);
		Font fnt3 = new Font("IMPACT", 1, 15);
		if (game.gameState == WGame.STATE.Menu){
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Waves", 240, 70);
			
			g.setFont(fnt2);
			
			g.drawString("Play", 270, 190);
			g.drawRect(210, 150, 200,  64);
			
			g.drawString("Help", 270, 290);
			g.drawRect(210, 250, 200,  64);
			
			g.drawString("Quit", 270, 390);
			g.drawRect(210, 350, 200,  64);
			
		}else if (game.gameState == WGame.STATE.Help){
			g.setColor(Color.WHITE);
			g.setFont(fnt);
			g.drawString("Help", 250, 70);

			g.setFont(fnt2);
			g.drawString("Controls: A, W, D, S", 180, 140);
			g.drawString("P: Pause", 240, 210);
			g.drawString("ESC: Exit", 240, 280);
					
			g.setFont(fnt2);
			g.drawRect(210, 350, 200,  64);
			g.drawString("Back", 270, 390);
			
		}else if (game.gameState == WGame.STATE.End){

			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("GAME OVER!", 180, 70);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200,  64);
			g.drawString("Final Score: " + hud.getScore(), 200 , 200);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200,  64);
			g.drawString("Try Again", 245, 390);
			
		}else if (game.gameState == WGame.STATE.Select){

			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Difficulty", 240, 70);
			
			g.setFont(fnt2);
			
			g.drawString("Normal", 270, 190);
			g.drawRect(210, 150, 200,  64);
			
			g.drawString("Hard", 270, 290);
			g.drawRect(210, 250, 200,  64);
			
			g.drawString("Quit", 270, 390);
			g.drawRect(210, 350, 200,  64);
			
		}
	}  
	
}