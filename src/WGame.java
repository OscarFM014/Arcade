
import java.applet.AudioClip;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

public class WGame extends Canvas implements Runnable {
	//THE MAIN CLASS

	private static final long serialVersionUID = -2416785031800065863L;
	//SERIALIZAR:
	//http://java-white-box.blogspot.com/2013/12/serializar-en-java-serialVersionUID.html
	
	
	public static final int WIDTH = 640, 
							HEIGHT = WIDTH/12 * 9;
	
	//HILO
	private Thread thread;
	private boolean running = false;
	
	//HANDLER
	private WHandler handler;
	
	//RANDOM
	private Random r;
	
	//HUD
	private WHUD hud;
	
	//SPAWN
	
	private WSpawn spawner;
	
	//MENU
	
	private WMenu menu;
	
	//PAUSED
	
	public static boolean paused = false;
	
	//DIFFICULT
	
	public int diff = 0; // 0 = normal, 1 = hard 
	
	
	public enum STATE{
		Menu,
		Select,
		Help,
		Game,
		End
	};
	
	
	public static STATE gameState = STATE.Menu;
	
	WAudio audio = new WAudio();
    AudioClip fondo = audio.getAudio("/res/fondo.wav");
	
	//CONSTRUCTOR
	public WGame(){
		
		handler = new WHandler();
		hud = new WHUD();
		menu = new WMenu(this, handler, hud); 
		this.addKeyListener(new WKeyInput(handler, this));
		this.addMouseListener(menu);
		
		new WWindow(WIDTH, HEIGHT, "Our Waves", this);

		spawner = new WSpawn(handler, hud, this);
		
		r = new Random();
		
		if (gameState == STATE.Game){
			handler.addObject(new WPlayer((WIDTH)/2 - 32, (HEIGHT) / 2 - 32, ID.Player, handler));
			handler.addObject(new WBasicEnemy(r.nextInt(WGame.WIDTH - 50), r.nextInt(WGame.HEIGHT - 50), ID.BasicEnemy, handler));
		}else{
			for(int i = 0; i < 20; i++){
				handler.addObject(new WMenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
			}
		}
		
		
	}
	
	//START THREAD
	public synchronized void start(){
		thread = new Thread(this);
		thread.start(); 
		running = true;
		
	}
	
	//STOP THREAD
	public synchronized void stop(){
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// WE NEED A GAME LOOP IN ORDER TO UPDATE THE INFORMATION
	public void run() {
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1){
				tick();
				delta--;
			}
			
			if(running)
				render();
			
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();	
	}
	
	//TICK METHOD 
	private void tick() {
		
		if(gameState == STATE.Game){
			
			if(!paused){
				handler.tick(); 
				hud.tick();
				spawner.tick(); 
				
				if(WHUD.HEALTH <= 0){
					WHUD.HEALTH = 100;
					gameState = STATE.End;
					handler.clearEnemys();
					for(int i = 0; i < 20; i++){
						handler.addObject(new WMenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
					}	
				}
			}
			
		}else if(gameState == STATE.Menu ||  gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select){
			menu.tick();
			handler.tick();
		}
		
		
		
	}
	

	private void render() {
		//BUFFERSTRATEGY: 
		//https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferStrategy.html
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		if(paused){
			g.setColor(Color.white);
			g.drawString("PAUSED", 100, 100);
		}
		

		if(gameState == STATE.Game){
			hud.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select ){
			menu.render(g);
		}
		
	  
		g.dispose();
		bs.show();
		
	}
	
	
	//BOX METHOD
	public static float clamp(float var, float min, float max){
		if (var >= max){
			return var = max;
		}else if( var <= min){
			return var = min;
		}else
			return var;
		
	}

	public static void main(String arg[]){
		new WGame();
		
		
		
	}

	
}
