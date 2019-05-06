import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class PMenuPanel extends JPanel implements ActionListener  {


	private JButton btnPlay,
					btnIns,
					btnExit;
	
	private Image fondo;

	
	public PMenuPanel(){
		super();
		
		//this.setPreferredSize(new Dimension (1280,  850));
		this.fondo = new ImageIcon("imagenes/portadaPong.png").getImage();
	
		
		this.setLayout(null);
		this.btnPlay = new JButton("Play");
		this.btnPlay.setBounds(300, 100,190,40);
		this.btnPlay.addActionListener(this);
		
		this.btnIns = new JButton("Settings");
		this.btnIns.setBounds(300, 160, 190, 40);
		this.btnIns.addActionListener(this);
		
		this.btnExit = new JButton("Exit");
		this.btnExit.setBounds(300, 220, 190, 40);
		this.btnExit.addActionListener(this);
		
		//ADD
		this.add(this.btnPlay);
	    this.add(this.btnIns);
	    this.add(this.btnExit);
	    
		
		

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), this);	
	}
	
	

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnPlay) {
			PVentana a = new PVentana();
			a.setVisible(true);
			this.setVisible(false);
			
		}else if(e.getSource() == btnIns) {
		}
		
	}


	
}