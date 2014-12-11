package codingForFun;

import java.util.*;

public class NumPounds_other {

	public void calPound(int i) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		calPoundHelp(i, list, map);
		int sixteen = 0, seven = 0, three = 0;
		if (map.containsKey(0)) {
			for (Integer e : map.get(0)) {
				if (e == 16) {
					sixteen++;
				}
				else if (e == 7) {
					seven++;
				}
				else if (e == 3) {
					three++;
				}
				else {
					continue;
				}
			}
		}
		System.out.println("Sixteens = " + sixteen + " Sevens = " + seven + " Threes = " + three);
	}

	public void calPoundHelp(int i, ArrayList<Integer> list2, HashMap<Integer, ArrayList<Integer>> map) {
		if (map.containsKey(i) && map.get(i).size() < list2.size()) {
			list2 = map.get(i);
		}
		if (!map.containsKey(i)) {
			map.put(i, list2);
		}
		if (i - 3 >= 0) {
			ArrayList<Integer> list = new ArrayList<Integer>(list2);
			list.add(3);
			if (!map.containsKey(i - 3) || map.get(i - 3).size() > list.size()) {
				map.put(i - 3, list);
			}
			calPoundHelp(i - 3, list, map);
		}
		if (i - 7 >= 0) {
			ArrayList<Integer> list = new ArrayList<Integer>(list2);
			list.add(7);
			if (!map.containsKey(i - 7) || map.get(i - 7).size() > list.size()) {
				map.put(i - 7, list);
			}
			calPoundHelp(i - 7, list, map);
		}
		if (i - 16 >= 0) {
			ArrayList<Integer> list = new ArrayList<Integer>(list2);
			list.add(16);
			if (!map.containsKey(i - 16) || map.get(i - 16).size() > list.size()) {
				map.put(i - 16, list);
			}
			calPoundHelp(i - 16, list, map);
		}
	}
	

	// you have 3 7 16 pound weights
	public void calPound1(int tar) {
		List<Integer> res = new ArrayList<Integer>();
		find(res, tar);
		int sixteen = 0, seven = 0, three = 0;
		for (Integer e : res) {
			if (e == 16) {
				sixteen++;
			} else if (e == 7) {
				seven++;
			} else if (e == 3) {
				three++;
			} else {
				continue;
			}
		}
		System.out.println("Sixteens = " + sixteen + " Sevens = " + seven
				+ " Threes = " + three);
	}

	private boolean find(List<Integer> res, int tar) {
		if (tar == 0)
			return true; // find the solution
		if (tar < 3)
			return false; // no solution exist any more
		if (tar >= 16) { // if can put 16, put 16
			res.add(16);
			if (find(res, tar - 16)) // if remaining can be solved then
										// solution valid
				return true;
			else
				res.remove(res.size() - 1); // solution not valid, remove 16
		}
		if (tar >= 7) { // put 7
			res.add(7);
			if (find(res, tar - 7))
				return true;
			else
				res.remove(res.size() - 1);
		}

		res.add(3); // else put 3
		if (find(res, tar - 3))
			return true;
		else
			res.remove(res.size() - 1);

		return false; // no such solution
	}


	public static void main(String[] args) {
		NumPounds_other no = new NumPounds_other();
		for (int i = 7; i < 100; i += 3) {
			no.calPound1(i);
		}
	}
}
