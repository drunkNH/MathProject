import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;
public class QuestionGenerator 
{
	//initializes variable
	int number1, number2, answer;
	char operator = '?';
	int operation;
	String input;
	//int value;
	int score;
	//boolean isValid = false;
	boolean playMusic = false;
	Random rand = new Random();

	public int equation(int min, int max, JFrame frame)
	{
		//TODO: USE frame as the base frame
		//TODO: PUT A TEXTBOX 
		//TODO: ADD LABEL1 FOR QUESTION
		//TODO: ADD LABEL2 FOR SCORE
		
		//TODO: LABEL ASKS WHAT IS YOUR NAME AND ACCEPTS IT INTO NAME
		
		//TODO: THEN ASKS DO YOU WANT MUSIC pushes answer into playMusic
		
		for(int i=0; i<10; i++)
		{
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
			
			//System.out.println("QUESTION:  " + number1 + " " + operator + " " + number2 + " =  ?");
			//TODO: PRINTS THE QUESTION ON LABEL1
			//TODO: choice = textbox
			
			//If user gets it right, they earn 1 point, else they don't earn a point
			if (choice == answer)
				score =+ 1;
			
			//TODO: UPDATE SCORE LABEL
		}//end of question loop 
		
		//TODO: delete the buttons and labels here
		
		//TODO: Calls the hiscore function passes name, score, frame
	}


		/*
		//validates input
		while(!isValid) 
		{
			try 
			{
				input = JOptionPane.showInputDialog("Question: \n" + number1 + " " + operator + " " + number2 + " = ?"); //asking user input
				value = Integer.parseInt(input);
					
				if (value == answer)		
				{
					JOptionPane.showMessageDialog(null, "Answer is correct!");
					break;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Answer is wrong!"); //throw the error message
				}
			} 
			catch (NumberFormatException e) //catches if inputed value is not an integer
			{
				JOptionPane.showMessageDialog(null, "Error! Please enter an integer type data.");
			}
			catch (IllegalArgumentException e) //catches if illegal argument has been passed
			{
				JOptionPane.showMessageDialog(null, "Error! Please enter an integer type data.");
			}
			catch (Exception e) //catches if inputed value is not in range
			{
				JOptionPane.showMessageDialog(null, e);
			}
		*/
		//end of while
} //end of equation method