import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphics{

	public static void main(String[] args) {
			
		new MyFrame() {
			class MyFrame extends JFrame{
		}
			
			MyPanel panel;
			
			void MyFrame(){
				
				panel = new MyPanel();
				
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.add(panel);
				this.pack();
				this.setLocationRelativeTo(null);
				this.setVisible(true);
			}  
			
		
	
	};
	
	 class MyPanel extends JPanel implements ActionListener{

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
}
}