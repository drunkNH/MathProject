import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
				msg += printable.get(i) + "\t" + entry.getKey() + "<br/>";
				count++;
				if (count == 5)
					break;
			}
			if (count == 5)
				break;
		}
		return msg;
	}
	
	public void writeScore(String name, int score) throws IOException 
	{
		File log = new File("scores.txt");
		PrintWriter out = new PrintWriter(new FileWriter(log, true));
		out.write(name + ":" + score + "\n");
		out.flush();
		out.close();
	}
	
	public static TreeMap<Integer, List<String>> readScores() throws IOException 
	{
		TreeMap<Integer, List<String>> readScore = new TreeMap<Integer, List<String>>(Collections.reverseOrder());
		String name;
		int score;
		String line;
		BufferedReader input = new BufferedReader(new FileReader("scores.txt"));
		line = input.readLine();
		while (line != null) 
		{
			name = line.substring(0, line.indexOf(":"));
			score = Integer.parseInt(line.substring(line.indexOf(":") + 1));
			readScore = storeScore(name, score, readScore);
			line = input.readLine();
		}
		input.close();
		return readScore;
	}
}