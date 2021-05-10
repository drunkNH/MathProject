import javax.swing.JFrame;
import javax.swing.JLabel;

public class RandomGenerator extends JPanel
{
	//initializes variable
	int number1, number2, answer, operation, score;
	char operator = '?';
	String input;
	String name;
	boolean decision = false;
	boolean playMusic = false;
	//creates Hiscore object
	Hiscore scorekeeper = new Hiscore();
	//creates random number generator
	Random rand = new Random();
		
	//TODO: LABEL ASKS WHAT IS YOUR NAME AND ACCEPTS IT INTO NAME 
	JLabel label1 = new JLabel("What is your name: ");
	JLabel label2 = new JLabel("SCORE: " + score);
	JLabel label3 = new JLabel("Starting in...");
	//TODO: PUT A TEXTBOX
	JTextField textbox = new JTextField("Type in your answer here", 20);
	//enter button
	JButton enterButton = new JButton("Enter");
	
	label1.setBounds(225,30,100,100); //label for asking questions
	label2.setBounds(225,30,100,100); //label for score
	label3.setBounds(225,300,100,100); //label for starting in 3, 2, 1
	
	textbox.setBounds(225,200,50,50);
	enterButton.setBounds(225,250,100,100);
	
			
	public void equation(int min, int max, JFrame frame, TreeMap leaderboard)
	{
		boolean restart = true;
		while(restart == true)
		{
		
			//adds label1 & textbox to JFrame
			frame.add(label1);
			frame.add(textbox);
			frame.add(enterButton);
			//LABEL ASKS WHAT IS YOUR NAME AND ACCEPTS IT INTO NAME
			enterButton.addActionListener(new nameActionListener());

			
				
			//TODO: THEN ASKS DO YOU WANT MUSIC pushes answer into playMusic
			//call music method right here
	      
			frame.removeAll();
			
			//LABEL SAYS STARTING IN, 3, 2,1
			frame.add(label3);
			wait(1000);
			label3.setBounds(275, 250, 50, 50);
			label3.setText("3");
			wait(1000);
			label3.setText("2");
			wait(1000);
			label3.setText("1");
			wait(1000);
			frame.removeAll();
			
			for(int i=0; i<10; i++)
			{
				//CREATING QUESTION HERE
				frame.add(label2); //add label2 for score
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

				int choice = 0;
				
				//PRINTS THE QUESTION ON LABEL1
				label1.setText("QUESTION:  " + number1 + " " + operator + " " + number2 + " = ?");
				enterButton.addActionListener(new mathActionListener());
					
				//IF USER ANSWER IS RIGHT THEN ADD 1 TO SCORE
				if (choice == answer)
					score =+ 1;
					
				//UPDATE THE SCORE LABEL
				label2.setText("SCORE: " + score);
			}//end of question loop 
				
			//TODO: RESETS THE FRAME
			frame.removeAll();
				
			//TODO: Calls the hiscore function passes name, score, and treemap
			leaderboard = scorekeeper.calculateScores(name, score, leaderboard);
			decision = scorekeeper.display(leaderboard, frame);
				
			if (decision == false)
			{
				frame.getContentPane().removeAll();
				restart = false;
			}
		}
	}

	
	class nameActionListener implements ActionListener //this action listener for the clear Button
	{
	      public void actionPerformed(ActionEvent e) 
	      {
	    	  	//stores name value after textbox input
	  			name = textbox.getText();
	      }
	}
	
	class mathActionListener implements ActionListener //this action listener for the clear Button
	{
	      public void actionPerformed(ActionEvent e) 
	      {
	    	  	//stores name value after textbox input
	  			answer = textbox.getText();
	      }
	}
  
	private static void wait(int ms)
	{
		try	
		{
			Thread.sleep(ms);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}
} //end of randomGenerator class
