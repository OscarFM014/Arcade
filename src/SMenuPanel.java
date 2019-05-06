
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




class SMenuPanel extends JPanel implements ActionListener  {


	private JButton btnPlay,
					btnIns,
					btnExit;
	
	
	
	private Image fondo;

	
	public SMenuPanel(){
		super();
		
		//this.setPreferredSize(new Dimension (1280,  850));
		this.fondo = new ImageIcon("imagenes/Snake.jpg").getImage();
	
		
		this.setLayout(null);
		this.btnPlay = new JButton("Play");
		this.btnPlay.setBounds(300, 160,190,40);
		this.btnPlay.addActionListener(this);
		
		this.btnIns = new JButton("Settings");
		this.btnIns.setBounds(300, 220, 190, 40);
		this.btnIns.addActionListener(this);
		
		this.btnExit = new JButton("Exit");
		this.btnExit.setBounds(300, 280, 190, 40);
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
	
	

	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == btnPlay) {
			SMain a = new SMain();
			a.setVisible(true);
			this.setVisible(false);
			
		}else if(e.getSource() == btnIns) {	
			SHelp b = new SHelp();
			b.setVisible(true);
			this.setVisible(false);
		}else if (e.getSource() == this.btnExit){
			AMenuPrincipal c = new AMenuPrincipal();
			c.setVisible(true);
			this.setVisible(false);
		}
		
	}
}




class SHelp extends JFrame{
	public SHelp (){
		super("Our Snake");
		SHelpPanel help = new SHelpPanel();
		this.setBounds(10, 10, 800,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(help);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		SHelp amp = new SHelp();
	}
}

class SHelpPanel extends JPanel implements ActionListener{
	
	private JButton btnexit;
	private Image fondo;
	
	public SHelpPanel(){
		this.fondo = new ImageIcon("imagenes/Snake.jpg").getImage();
		this.setLayout(null);
		this.btnexit = new JButton("Return");
		this.btnexit.setBounds(270, 390, 200,  64);
		this.btnexit.addActionListener(this);
		this.add(this.btnexit);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), this);
		Font fnt = new Font("Impact", 1, 50);
		Font fnt2 = new Font("Impact", 1, 30);
		
		g.setColor(Color.WHITE);
		g.setFont(fnt);
		g.drawString("Help", 250, 70);
		
		g.setFont(fnt2);
		g.drawString("Controls: Left Arrow, Rigth Arrow,", 100, 140);
		g.drawString(" 			Up Arrow, Down Arrow", 180, 240);
		g.drawString("ESC: Space", 100,  340);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnexit){
			SMenuFrame a = new SMenuFrame();
			a.setVisible(true);
			this.setVisible(false); 
		}
		
	}
}