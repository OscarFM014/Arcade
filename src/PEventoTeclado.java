import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;


	 
public class PEventoTeclado extends PTableroJuego implements KeyListener  {

		static boolean a, z, k, m, enter;
		public PPelota pelota;

		@Override
		public void keyPressed(KeyEvent e) {
			int id = e.getKeyCode();
			
			if(id == KeyEvent.VK_A) {
				a = true;
			}
			
			if(id == KeyEvent.VK_Z) {
				z = true;
			}
			
			if(id == KeyEvent.VK_K) {
				k = true;
			}
			
			if(id == KeyEvent.VK_M) {
				m = true;
			}
			
			if(id == KeyEvent.VK_ENTER) {
				if (PPelota.finJuego){
					PMenuFrame a = new PMenuFrame();
					a.setVisible(true);
					this.setVisible(false); 
				}
			}
			
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			int id = e.getKeyCode();
			
			if(id == KeyEvent.VK_A) {
				a = false;
			}
			
			if(id == KeyEvent.VK_Z) {
				z = false;
			}
			
			if(id == KeyEvent.VK_K) {
				k = false;
			}
			
			if(id == KeyEvent.VK_M) {
				m = false;
			}
			
			if(id == KeyEvent.VK_ENTER) {

			}
			
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
			
		} 
		
}
	



	
