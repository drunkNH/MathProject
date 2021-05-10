import java.util.*;
import java.util.Map.Entry;
import javax.swing.*;
import java.awt.event.*;
import java.util.Comparator;

public class MathGame 
{
	//Hiscore scorekeeper;
	int max = 50;
	int min = 1;
	int number1, number2, answer, operation, score;
	int counter = 0;
	char operator = '?';
	int choice = 0;
	String name;
	boolean decision = false;
	//boolean playMusic = false;
	
	Random rand = new Random();
	Hiscore hiscore = new Hiscore();
	
	//FOR START MENU
	JFrame frame = new JFrame();//creating instance of JFrame  
	JButton startButton = new JButton("START");//creating instance of JButton for submit
	JButton exitButton = new JButton("Exit");//creating instance of JButton for exit
	JLabel label1 = new JLabel("WELCOME TO OUR MATH GAME!"); //creating instance of Jlabel for prompt	
		
	//TODO: LABEL ASKS WHAT IS YOUR NAME AND ACCEPTS IT INTO NAME 
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel("SCORE: " + score);
	//JLabel label4 = new JLabel("Starting in...");
	JTextField textbox = new JTextField(null, 20);
	JButton enterButton = new JButton("Enter");
	JButton mathEnterButton = new JButton("Enter");
	
	public static TreeMap <String, Integer> makeLeaders()
	{
		TreeMap<String, Integer> defaultScores = new TreeMap<String, Integer>();
		defaultScores.put("Terry", 10); 
		defaultScores.put("Larry", 7); 
		defaultScores.put("Tom", 9); 
		defaultScores.put("Mick", 8); 
		defaultScores.put("Cale", 6); 
		
		return defaultScores;
	}
	
	TreeMap<String, Integer> leaderboard = new TreeMap<String, Integer>();
	
	
	public void startGame()
	{
		leaderboard = makeLeaders();
		
		//possible start screen
		frame.setSize(700,500);// 700 width and 500 height  
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible  
		
		//FIRST SCREEN COMPONENTS (start)
		frame.add(startButton);//adding button in JFrame 
		frame.add(exitButton);//adding button in JFrame 
		frame.add(label1);//adding label in JFrame 
		
		//SECOND SCREEN COMPONENTS (name)
		frame.add(label2);
		frame.add(textbox);
		frame.add(enterButton);
		
		//THIRD SCREEN COMPONENTS (math)
		frame.add(mathEnterButton);
		frame.add(label3); //add label2 for score
		
		//FOURTH SCREEN COMPONENTS (scores)
		
		startButton.setBounds(240,200,200,80);//x axis, y axis, width, height 
		exitButton.setBounds(240,280,200,80);//x axis, y axis, width, height 
		label1.setBounds(240,40,400,100);//x axis, y axis, width, height  
		
		startButton.addActionListener(new startActionListener());//adding action listener to start button
		exitButton.addActionListener(new exitActionListener());//adding action listener to exit button
		enterButton.addActionListener(new nameActionListener());//adding action listener for name
		mathEnterButton.addActionListener(new mathActionListener());//adding action listener for name
	}//end of startGame()
	
	class exitActionListener implements ActionListener //this action listener for the clear Button
	{
	      public void actionPerformed(ActionEvent e) 
	      {
	    	  System.exit(0); //exiting the window
	      }
	}
	
	class startActionListener implements ActionListener //this action listener for the clear Button
	{
	      public void actionPerformed(ActionEvent e) 
	      {
	    	  //clears the frame
	    	  startButton.setBounds(0,0,0,0);
	    	  exitButton.setBounds(0,0,0,0);
	    	  label1.setBounds(0,0,0,0);
	    	  //resets to new game if played again
	    	  textbox.setText(null);
	    	  label2.setText("What is your name: ");
	    	  score = 0;
	    	  //shows new components
	    	  label2.setBounds(240,40,400,100);
	    	  textbox.setBounds(225,200,500,50);
	    	  enterButton.setBounds(225,250,100,100);
	      }
	}//end of startActionListen
	
	class nameActionListener implements ActionListener //this action listener for the clear Button
	{
	      public void actionPerformed(ActionEvent e) 
	      {

	    	  counter = 0;
	    	  name = textbox.getText();
	    	  label2.setBounds(0,0,0,0);
	    	  enterButton.setBounds(0,0,0,0);
	    	  mathEnterButton.setBounds(225,250,100,100);
	    	  textbox.setText(null);
		    
		    		
					label3.setBounds(500,0,100,100); //label for score
					label2.setBounds(240,40,400,100);
					
					//CREATING QUESTION HERE
					operation = rand.nextInt(3) + min;
						
					if (operation == 3)
						max = 10; //if random generator picks a multiplication problem, makes max 10 to make it easier
						
					number1 = rand.nextInt(max) + min; //random number max and min
					number2 = rand.nextInt(max) + min; 
						
					//if random generator picks a subtraction problem, ensures the final answer of the problem can't be negative by switching the numbers
					if (operation == 2 && number1 < number2)
					{
						int tempNum = number1;
						number1 = number2;
						number2 = tempNum;
					}
				
					answer = 0;
					
					if (operation == 1)
					{
						operator = '+';
						answer = number1 + number2;
					}
					if (operation == 2)
					{
						operator = '-';
						answer = number1 - number2;
					}
					if (operation == 3)
					{
						operator = '*';
						answer = number1 * number2;
					}
					
	
					
					//PRINTS THE QUESTION ON LABEL1
					label2.setText("QUESTION:  " + number1 + " " + operator + " " + number2 + " = ?");
						
					//IF USER ANSWER IS RIGHT THEN ADD 1 TO SCORE
					
		 
		    	
	      }
	}
	
	class mathActionListener implements ActionListener //this action listener for the clear Button
	{
	      public void actionPerformed(ActionEvent e) 
	      {
	    	  	counter += 1;
	    	  	if(counter < 10)
	    	  	{
	    	  	//stores name value after textbox input
	  			choice = Integer.parseInt(textbox.getText());
	  			textbox.setText("");
	  			
	  			if (choice == answer)
					score += 1;
					//UPDATE THE SCORE LABEL
				label3.setText("SCORE: " + score);
				
				textbox.setText(null);
					
				//CREATING QUESTION HERE
				operation = rand.nextInt(3) + min;
						
				if (operation == 3)
				max = 10; //if random generator picks a multiplication problem, makes max 10 to make it easier
						
				number1 = rand.nextInt(max) + min; //random number max and min
				number2 = rand.nextInt(max) + min; 
						
				//if random generator picks a subtraction problem, ensures the final answer of the problem can't be negative by switching the numbers
				if (operation == 2 && number1 < number2)
				{
					int tempNum = number1;
					number1 = number2;
					number2 = tempNum;
				}
				
				answer = 0;
					
				if (operation == 1)
				{
					operator = '+';
					answer = number1 + number2;
				}
				if (operation == 2)
				{
					operator = '-';
					answer = number1 - number2;
				}
				if (operation == 3)
				{
					operator = '*';
					answer = number1 * number2;
				}
					
					//PRINTS THE QUESTION ON LABEL1
					label2.setText("QUESTION:  " + number1 + " " + operator + " " + number2 + " = ?");
		    	}
	    	  	else
	    	  	{
	    	  		//HISCORE PART
	    	  		label3.setBounds(0,0,0,0);
	    	  		textbox.setBounds(0,0,0,0);
	    	  		mathEnterButton.setBounds(0,0,0,0);
	    	  		
	    	  		//CALCULATE THE SCORES HERE 
	    	  		leaderboard = hiscore.storeScore(name, score, leaderboard);
	    	  		
	    	  		//label2.setBounds(0,0,0,0); //CHANGE THE BOUNDS TO FIT WHOLE HIGH SCORES
	    	  		label2.setText("<html>TOP 5 SCORES<br/>" + hiscore.display(leaderboard) + "<html>");
	    	  		
	    	  		
	    	  		
	    	  		startButton.setText("Play Again");
	    	  		startButton.setBounds(200,200,200,80);
	    			exitButton.setBounds(400,200,200,80);
	    	  	}
	    	  	
	      }
	    	  	
	}
}//end of class