import javax.swing.JOptionPane;
import java.util.Random;

public class RandomGenerator {
	
	//initializes variable
	int number1, number2, answer;
	char operator = '?';
	String input;
	int value;
	boolean isValid = false;
	
	Random rand = new Random();
	
	public void equation(int min, int max)
	{
		number1 = rand.nextInt(max) + min; //random number betw 1 & 20
		number2 = rand.nextInt(max) + min; 
		answer = 0;
	
		switch(rand.nextInt(4))
		{
			case 1:
				operator = '+';
				answer = number1 + number2;
				break;
			case 2:
				operator = '-';
				answer = number1 - number2;
				break;
			case 3:
				operator = '*';
				answer = number1 * number2;
				break;
			case 4:
				operator = '/';
				answer = number1 / number2;
				break;
		}
		
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
		} //end of while
	} //end of equation method

	public static void main(String[] args) {
		
		RandomGenerator gen = new RandomGenerator();
		
		//loops 10 times
		for (int x = 0; x < 10; x++)
		{
			gen.equation(1,50);
		}
	}
} //end of class