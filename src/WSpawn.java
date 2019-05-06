
import java.util.Random;

public class WSpawn {

	private WHandler handler;
	private WHUD hud;
	private WGame game;
	private int scoreKeep = 0;
	private Random r = new Random();
	
	public WSpawn(WHandler handler, WHUD hud, WGame game){
		this.handler = handler;
		this.hud = hud;
		this.game = game;
		
	}
	
	public void tick(){
		scoreKeep ++;
		
		if (scoreKeep >= 100){
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if (game.diff == 0){
				if(hud.getLevel() == 2){
					handler.addObject(new WBasicEnemy(r.nextInt(WGame.WIDTH - 50), r.nextInt(WGame.HEIGHT- 50), ID.BasicEnemy, handler));
				}else if(hud.getLevel() == 3){
					handler.addObject(new WBasicEnemy(r.nextInt(WGame.WIDTH - 50), r.nextInt(WGame.HEIGHT- 50), ID.BasicEnemy, handler));
				}else if(hud.getLevel() == 4){
					handler.addObject(new WSmartEnemy(r.nextInt(WGame.WIDTH), r.nextInt(WGame.HEIGHT), ID.SmartEnemy, handler));
				}else if(hud.getLevel() == 5){
					handler.addObject(new WSmartEnemy(r.nextInt(WGame.WIDTH), r.nextInt(WGame.HEIGHT), ID.SmartEnemy, handler));
				}else if(hud.getLevel() == 6){
					handler.addObject(new WFastEnemy(r.nextInt(WGame.WIDTH), r.nextInt(WGame.HEIGHT), ID.FastEnemy, handler));
				}else if(hud.getLevel() == 7){
					handler.addObject(new WFastEnemy(r.nextInt(WGame.WIDTH), r.nextInt(WGame.HEIGHT), ID.FastEnemy, handler));
				}else if(hud.getLevel() == 8){
					handler.addObject(new WFastEnemy(r.nextInt(WGame.WIDTH), r.nextInt(WGame.HEIGHT), ID.FastEnemy, handler));
				}else if(hud.getLevel() == 9){
					handler.addObject(new WFastEnemy(r.nextInt(WGame.WIDTH), r.nextInt(WGame.HEIGHT), ID.FastEnemy, handler));
				}else if(hud.getLevel() == 10){
					handler.clearEnemys();
					handler.addObject(new WEnemyBoss((WGame.WIDTH)/2 - 48, -120, ID.EnemyBoss, handler));
				}
			}else if(hud.getLevel() == 1){
					handler.addObject(new WHardEnemy(r.nextInt(WGame.WIDTH - 50), r.nextInt(WGame.HEIGHT- 50), ID.BasicEnemy, handler));
				}else if(hud.getLevel() == 3){
					handler.addObject(new WHardEnemy (r.nextInt(WGame.WIDTH - 50), r.nextInt(WGame.HEIGHT- 50), ID.BasicEnemy, handler));
				}else if(hud.getLevel() == 4){
					handler.addObject(new WSmartEnemy(r.nextInt(WGame.WIDTH), r.nextInt(WGame.HEIGHT), ID.SmartEnemy, handler));
				}else if(hud.getLevel() == 5){
					handler.addObject(new WSmartEnemy(r.nextInt(WGame.WIDTH), r.nextInt(WGame.HEIGHT), ID.SmartEnemy, handler));
				}else if(hud.getLevel() == 6){
					handler.addObject(new WFastEnemy(r.nextInt(WGame.WIDTH), r.nextInt(WGame.HEIGHT), ID.FastEnemy, handler));
				}else if(hud.getLevel() == 7){
					handler.addObject(new WFastEnemy(r.nextInt(WGame.WIDTH), r.nextInt(WGame.HEIGHT), ID.FastEnemy, handler));
				}else if(hud.getLevel() == 8){
					handler.addObject(new WFastEnemy(r.nextInt(WGame.WIDTH), r.nextInt(WGame.HEIGHT), ID.FastEnemy, handler));
				}else if(hud.getLevel() == 9){
					handler.addObject(new WFastEnemy(r.nextInt(WGame.WIDTH), r.nextInt(WGame.HEIGHT), ID.FastEnemy, handler));
				}else if(hud.getLevel() == 10){
					handler.clearEnemys();
					handler.addObject(new WEnemyBoss((WGame.WIDTH)/2 - 48, -120, ID.EnemyBoss, handler));
				}
			
			
		}
	}
}
