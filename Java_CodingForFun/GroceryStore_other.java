package codingForFun;

import java.util.*;

// There are two room mates. Each one prepares a list for grocery store. Make a combined list without any duplicates.
public class GroceryStore_other {

	public static ArrayList<String> getCombinedList(String[] l1, String[] l2)
	{
		HashSet<String> hashSet = new HashSet<String>();
		ArrayList<String> combinedList = new ArrayList<String>();

		for (int i = 0; i < l1.length; i++)
		{
			if (hashSet.add(l1[i].toLowerCase()))
			{
				combinedList.add(l1[i]);
			}
		}

		for (int i = 0; i < l2.length; i++)
		{
			if (!hashSet.contains(l2[i].toLowerCase()))
			{
				combinedList.add(l2[i]);
			}
		}

		return combinedList;
	}

	public static void main(String[] args)
	{
		String[] l1 = { "a", "b", "c", "d", "e" };
		String[] l2 = { "f", "b", "g", "d", "h" };

		ArrayList<String> combinedList = getCombinedList(l1, l2);
		for (String item : combinedList)
			System.out.println(item);
	}
}
