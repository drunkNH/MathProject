import java.util.*;
import java.util.Map.Entry;
public class Hiscore 
{
	//method to store a player's high score with their name.
	//if a name is the same but score is higher, it updates the score, if score is lower, just returns the map with no changes
	public static TreeMap<String, Integer> calculateScores (String name, int score, TreeMap<String, Integer> hiscores)
	{
		
		for(Entry<String, Integer> entry: hiscores.entrySet())
		{
			if (entry.getKey().equals(name))
				if (entry.getValue() >= score)
					return hiscores;
		}
		hiscores.put(name, score);
		return hiscores;
	}
		
	//method to sort by values instead of key
	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) 
	{
		Comparator<K> valueComparator =  new Comparator<K>() 
		{
			public int compare(K k1, K k2) 
			{
				int compare = map.get(k2).compareTo(map.get(k1));
				if (compare == 0) 
					return 1;
				else 
					return compare;
			}
		};
		    Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		    sortedByValues.putAll(map);
		    return sortedByValues;
	}
		
	//displays the high scores, stops after 5 iterations
	public static void display (TreeMap<String, Integer> hiscores)
	{
		Map<String, Integer> display = sortByValues(hiscores);
		int i = 0;
		for (Entry<String, Integer> entry : display.entrySet()) 
		{
			System.out.println(entry.getKey() + ": " + entry.getValue());
			i++;
			if (i == 5)
				break;
		}
	}
	/*	
		 public static void main(String[] args) {
			TreeMap<String, Integer> test = new TreeMap<String, Integer>();
			test.put("Terry", 10); 
			test.put("Larry", 7); 
			test.put("Tom", 9); 
			test.put("Mick", 8); 
			test.put("Cale", 6); 
		
			
			display(test); //Test initial display
			System.out.println();
			test = cool("Andy", 10, test);		
			display(test);//Test Display with a new entry
			System.out.println();
			test = cool("Cale", 10, test);	
			display(test);//Test Display with an updated entry
			System.out.println();
			test = cool("Andy", 3, test);		
			display(test);//Test display with a failed updated entry
		}
		*/
	
}
