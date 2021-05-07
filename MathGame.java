import java.util.*;
import java.util.Map.Entry;
public class MathGame 
{
	Score scorekeeper;
	Music musicObj;
	RandomGenerator questionMaker = new RandomGenerator();
	Scanner sc = new Scanner(System.in);
	static int interval;
	static Timer timer;
	
	int score = 0;
	int number1 = 0; //random number 1-100
	int number2 = 0; //random number 1-100
	int questionType = 0; //random number 1-4, 1:+ 2:- 3:* 4:/
	boolean correct = false;
	
	public TreeMap<String, Integer> makeLeaders()
	{
		TreeMap<String, Integer> test = new TreeMap<String, Integer>();
		test.put("Terry", 10); 
		test.put("Larry", 7); 
		test.put("Tom", 9); 
		test.put("Mick", 8); 
		test.put("Cale", 6); 
		
		return test;
	}
	
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
	}
	
	public void startGame()
	{
		//possible start screen
		//System.out.println("MATH GAME");
		
		TreeMap <String, Integer> leaderboard = new TreeMap<String, Integer>();
		leaderboard = makeLeaders();
		
		for(;;)
		{
			System.out.println("ENTER YOUR NAME.");
			String name = sc.nextLine();
			score = 0;
			//GAME STARTING
			for(int i=0; i<10; i++)
			{
				
				score += questionMaker.equation(1,50);
				System.out.println(score);
				
			}//end of game
			
			//calls function that takes in score and name
			leaderboard = scorekeeper.calculateScores(name, score, leaderboard);
			scorekeeper.display(leaderboard);
		
		
		
			//asks do you want to play again screen
			System.out.println("DO YOU WANT TO PLAY AGAIN Y/N");
			
			if(sc.equals("no"))
				break;
		}
	}//end of startGame()
}
