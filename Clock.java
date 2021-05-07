import java.util.Timer;
import java.util.TimerTask;
public class Clock 
{
	static int interval;
	static Timer timer;

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
}
