import java.util.*;
import java.util.Map.Entry;
import javax.swing.*;
import java.awt.event.*;
//TEST
public class MathGame 
{
	Hiscore scorekeeper;
	Music musicObj;
	RandomGenerator questionMaker = new RandomGenerator();
	Scanner sc = new Scanner(System.in);//scanner
	static int interval;//time
	//static Timer timer; //time
	
	//FOR START MENU
	JFrame frame = new JFrame();//creating instance of JFrame  
	JButton startButton = new JButton("START");//creating instance of JButton for submit
	JButton exitButton = new JButton("Exit");//creating instance of JButton for exit
	JLabel label1 = new JLabel("WELCOME TO OUR MATH GAME!"); //creating instance of Jlabel for prompt
	
	public TreeMap <String, Integer> makeLeaders()
	{
		TreeMap<String, Integer> defaultScores = new TreeMap<String, Integer>();
		test.put("Terry", 10); 
		test.put("Larry", 7); 
		test.put("Tom", 9); 
		test.put("Mick", 8); 
		test.put("Cale", 6); 
		
		return defaultScores;
	}
	
	/* FIX THIS
	public void timing()
	{
	    int secs=10;
	    int delay = 1000;
	    int period = 1000;
	    timer = new Timer();
	    interval = (secs);
	    System.out.println(secs);
	    
	    timer.scheduleAtFixedRate(new TimerTask() 
	    {
	        public void run() 
	        {
	            System.out.println(setInterval());
	        }
	    }, delay, period);
	}
    
	private static final int setInterval() 
	{
	    if (interval == 1)
	        timer.cancel();
	    return --interval;
	
	*/
	
	class startActionListener implements ActionListener //this action listener for the clear Button
	{
	      public void actionPerformed(ActionEvent e) 
	      {
	    	  TreeMap <String, Integer> leaderboard = new TreeMap<String, Integer>();
	    	  leaderboard = makeLeaders();
	  		
	    	//  frame.remove(startButton);
	    	//  frame.remove(exitButton);
	    	//  frame.remove(label1);
	    	  
	    	  frame.removeAll();
	    	  
	    	  questionMaker.equation(1,50,frame,leaderboard);
	    	  
	    	  frame.add(startButton);//adding button in JFrame 
	    	  frame.add(exitButton);//adding button in JFrame 
	    	  frame.add(label1);//adding label in JFrame 
	    	  }
	      }
	}
	
	class exitActionListener implements ActionListener //this action listener for the clear Button
	{
	      public void actionPerformed(ActionEvent e) 
	      {
	    	  System.exit(0); //exiting the window
	      }
	}
	
	public void startGame()
	{
		//possible start screen
		frame.setSize(700,500);// 700 width and 500 height  
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible  
		
		frame.add(startButton);//adding button in JFrame 
		frame.add(exitButton);//adding button in JFrame 
		frame.add(label1);//adding label in JFrame 
		
		
		startButton.setBounds(240,200,200,80);//x axis, y axis, width, height for clear button
		exitButton.setBounds(240,280,200,80);//x axis, y axis, width, height for clear button
		label1.setBounds(240,40,400,100);//x axis, y axis, width, height for clear button
		
		
		startButton.addActionListener(new startActionListener());//adding action listener to clear button
		exitButton.addActionListener(new exitActionListener());//adding action listener to submit button
		
	}//end of startGame()
}