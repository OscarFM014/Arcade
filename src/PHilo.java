
import java.util.logging.Level;
import java.util.logging.Logger;


public class PHilo extends Thread {  //Thread =  Se usa en aplicacioes multitarea, porque tendremos varios objetos en movimiento
	
	PTableroJuego lamina;
	
	public PHilo(PTableroJuego lamina){
		this.lamina = lamina;
		
	}
	
	public void run() {
		while(!PPelota.finJuego) {
			lamina.repaint();
			try {
				Thread.sleep(6);
			} catch (InterruptedException e) {
				
				//e.printStackTrace();
				//Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, e);
				System.out.println("error in graphics engine: " + e.getMessage());
			}
		}
		
	}
	
}
