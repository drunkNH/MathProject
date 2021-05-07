import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyPanel extends JPanel implements ActionListener{

	final int PANEL_WIDTH = 820;
	final int PANEL_HEIGHT = 560;
	Image enemy;

	Timer timer;
	
	int x = 0;
	int y = 0;
	
	MyPanel(){
		this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
		this.setBackground(Color.black);
		enemy = new ImageIcon("background.jpeg").getImage();	
		
		timer = new Timer(10, this);
		timer.start();
	}

	public void paint(java.awt.Graphics g) {
		
		super.paint(g); // paint background
		
		Graphics2D g2D = (Graphics2D) g;
		
		//g2D.drawImage(backgroundImage, 0, 0, null);
		g2D.drawImage(enemy, x, y, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		//y = y + yVelocity;
		repaint();
	}
}