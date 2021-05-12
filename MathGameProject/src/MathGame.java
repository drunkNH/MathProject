import java.util.*;
//import java.util.Map.Entry;
//import java.util.Comparator;

import javax.swing.*;
import javax.swing.ImageIcon;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;


public class MathGame 
{
	//Hiscore scorekeeper;
	final int min = 1;
	int max = 50, counter = 0;
	int number1, number2, answer, operation, score;
	char operator = '?';
	int choice = 0;
	String name;
	boolean decision = false;
	//boolean playMusic = false;
	
	Random rand = new Random();
	Hiscore hiscore = new Hiscore();
	
	//ADDS IMAGES
	ImageIcon welcome = new ImageIcon("welcome.png");
	ImageIcon askName = new ImageIcon("name.png");
	
	//SETS FONT
	Font light = new Font("Helvetica Light", Font.PLAIN, 18);
	Font bold1 = new Font("Helvetica Bold", Font.BOLD, 18);
	Font bold2 = new Font("Helvetica Bold", Font.PLAIN, 30);
	
	//FOR START MENU
	JFrame frame = new JFrame("Math Game"); //creating instance of JFrame  
	JButton startButton = new JButton("START"); //creating instance of JButton for submit
	JButton exitButton = new JButton("EXIT"); //creating instance of JButton for exit
	//JLabel label1 = new JLabel("WELCOME TO OUR MATH GAME!"); //creating instance of Jlabel for prompt
	JLabel pic1 = new JLabel(welcome);
		
	//TODO: LABEL ASKS WHAT IS YOUR NAME AND ACCEPTS IT INTO NAME 
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel("SCORE: " + score);
	JLabel pic2 = new JLabel(askName);
	//JLabel label4 = new JLabel("Starting in...");
	JTextField textbox = new JTextField(null, 20);
	JButton enterButton = new JButton("ENTER");
	JButton mathEnterButton = new JButton("ENTER");
	
	public static TreeMap<Integer, List<String>> makeLeaders()
	{
		TreeMap<Integer, List<String>> defaultScores = new TreeMap<Integer, List<String>>(Collections.reverseOrder());
		List<String> arr1 = new ArrayList<>();
		List<String> arr2 = new ArrayList<>();
		List<String> arr3 = new ArrayList<>();
		List<String> arr4 = new ArrayList<>();
		List<String> arr5 = new ArrayList<>();
		arr1.add("Tim");
		arr2.add("Alan");
		arr3.add("Gerry");
		arr4.add("Gabe");
		arr5.add("Cale");
		defaultScores.put(4, arr1); 
		defaultScores.put(5, arr2); 
		defaultScores.put(6, arr3); 
		defaultScores.put(7, arr4); 
		defaultScores.put(8, arr5); 

		
		return defaultScores;
	}
	
	TreeMap<Integer, List<String>> leaderboard = new TreeMap<Integer, List<String>>();
	
	//STARTS GAME
	public void startGame()
	{
		leaderboard = makeLeaders();
		
		//SETS FRAME SIZE & CENTERS WINDOW
		frame.setSize(800,600); //sets size of frame
		frame.setLocationRelativeTo(null); //centers window
		
		//SETS BACKGROUND COLOR
		Color color = new Color(160,210,230);
		frame.getContentPane().setBackground(color);
		frame.setLayout(null); //using no layout managers  
		frame.setVisible(true); //making the frame visible
		
		//PUTS IMAGE
		frame.add(pic1);
		
		//FIRST SCREEN COMPONENTS (start)
		frame.add(startButton); //adding button in JFrame 
		frame.add(exitButton); //adding button in JFrame 
		//frame.add(label1); //adding label in JFrame 
		
		//SECOND SCREEN COMPONENTS (name)
		frame.add(label2);
		frame.add(textbox);
		frame.add(enterButton);
		
		//THIRD SCREEN COMPONENTS (math)
		frame.add(mathEnterButton);
		frame.add(label3); //add label2 for score
		
		//SETS FONTS
		startButton.setFont(bold1);
		exitButton.setFont(light);
		//label1.setFont(light);
		label2.setFont(bold1);
		textbox.setFont(light);
		enterButton.setFont(light);
		mathEnterButton.setFont(light);
		label3.setFont(light);
		
		//FOURTH SCREEN COMPONENTS (scores)
		pic1.setBounds(185,100,400,140);
		startButton.setBounds(290,300,200,40); //x axis, y axis, width, height 
		exitButton.setBounds(290,350,200,40); //x axis, y axis, width, height 
		//label1.setBounds(275,40,400,100); //x axis, y axis, width, height  
		
		startButton.addActionListener(new startActionListener()); //adding action listener to start button
		exitButton.addActionListener(new exitActionListener()); //adding action listener to exit button
		enterButton.addActionListener(new nameActionListener()); //adding action listener for name
		mathEnterButton.addActionListener(new mathActionListener()); //adding action listener for name
	} //end of startGame()
	
	class exitActionListener implements ActionListener //this action listener for the clear Button
	{
	      public void actionPerformed(ActionEvent e) 
	      {
	    	  System.exit(0); //exiting the window
	      }
	} //end of exitActionListener
	
	class startActionListener implements ActionListener //this action listener for the clear Button
	{
	      public void actionPerformed(ActionEvent e) 
	      {
		    	//clears the frame
		    	pic1.setBounds(0,0,0,0);
		    	startButton.setBounds(0,0,0,0);
		    	exitButton.setBounds(0,0,0,0);
		    	//label1.setBounds(0,0,0,0);
		    	
		    	//adds image
		    	frame.add(pic2);
		    	  
		    	//resets to new game if played again
		    	textbox.setText(null);
		    	//label2.setText("Enter your name: ");
		    	score = 0;
		    	  
		    	//shows new components
		    	pic2.setBounds(40,40,700,500);
		    	//label2.setBounds(325,150,400,100);
		    	textbox.setBounds(190,300,400,30);
		    	enterButton.setBounds(290,350,200,40);
	    	  
		  		//label2.setFont(bold1);
				textbox.setFont(light);
				enterButton.setFont(light);
	      }
	} //end of startActionListener
	
	class nameActionListener implements ActionListener //this action listener for the clear Button
	{
	      public void actionPerformed(ActionEvent e) 
	      {
	    	  	counter = 0;
	    	  	name = textbox.getText();
	    	  	pic2.setBounds(0,0,0,0);
	    	  	label2.setBounds(0,0,0,0);
	    	  	enterButton.setBounds(0,0,0,0);
	    	  	
	    	  	textbox.setText(null);
	    	  	
	    	  	mathEnterButton.setBounds(290,350,200,40);
				label3.setBounds(600,0,100,100); //label for score
				label2.setBounds(250,100,400,100);
				label2.setFont(bold2); //sets font for question
					
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
					operator = '+';
					answer = number1 + number2;
			
				if (operation == 2)
					operator = '-';
					answer = number1 - number2;
					
				if (operation == 3)
					operator = '*';
					answer = number1 * number2;
					
				//PRINTS THE QUESTION ON LABEL1
				label2.setText("QUESTION:  " + number1 + " " + operator + " " + number2 + " = ?");
						
				//IF USER ANSWER IS RIGHT THEN ADD 1 TO SCORE
	      }
	} //end of nameActionListener
	
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
	    	  		
	    	  		label2.setBounds(350,0,300,300); //CHANGE THE BOUNDS TO FIT WHOLE HIGH SCORES
	    	  		label2.setText("<html>TOP 5 SCORES<br/>" + hiscore.display(leaderboard) + "<html>");
	    	  		label2.setFont(light);
	    	  		
	    	  		startButton.setText("PLAY AGAIN");
	    	  		startButton.setBounds(290,300,200,40);
	    	  		startButton.setFont(bold1);
	    	  		
	    	  		exitButton.setText("EXIT");
	    			exitButton.setBounds(290,300,200,40);
	    			exitButton.setFont(light);
	    	  	}
	      }  	
	} //end of mathActionListener
} //end of MathGame