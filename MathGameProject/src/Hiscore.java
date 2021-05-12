import java.util.*;
import java.util.Map.Entry;

public class Hiscore {
	
	//method to store a player's high score with their name.
	//if a name is the same but score is higher, it updates the score, if score is lower, just returns the map with no changes
	public static TreeMap<Integer, List<String>> storeScore (String name, int score, TreeMap<Integer, List<String>> hiscores)
	{
		List<String> names = new ArrayList<>();
		names.add(name);
		for(Entry<Integer, List<String>> entry: hiscores.entrySet())
		{
				if (entry.getKey().equals(score))
				{
					List<String> values = entry.getValue();
					for (int i = 0; i < values.size(); i++)
					{
						if (values.contains(name))
						{
							values.remove(i);
							values.add(name);
							names = values;
							break;
						}
						else
						{
							values.add(name);
							names = values;
						}
				}
			}
		}
		hiscores.put(score, names);
		return hiscores;
	}
	
	//displays the high scores, stops after 5 iterations
	public static String display (TreeMap<Integer, List<String>> hiscores)
	{
		int count = 0;
		String msg = "Name      |Score      <br/>";
		
		for (Entry<Integer, List<String>> entry : hiscores.entrySet()) 
		{
			List<String> printable = entry.getValue();
			for (int i = printable.size() - 1; i >= 0; i--)
			{
				msg += printable.get(i) + "      |" + entry.getKey() + "<br/>";
				count++;
				if (count == 5)
					break;
			}
			if (count == 5)
				break;
		}
		return msg;
	}
}