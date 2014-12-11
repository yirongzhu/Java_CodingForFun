package codingForFun;

import java.util.*;

// Write a program to display the advertised average for the list of numbers my omitting the three largest number in the series.
// E.g:3,6,12,55,289,600,534,900,172.  avg=(3+6+12+55+289+172) /6and eliminating534,900,600
public class AdvertisedAverage_12 {

	public double advertisedAverage(List<Integer> l) {
		if (l == null || l.size() <= 3) {
			return 0;
		}
		int[] max3 = new int[3];
		double sum = 0;
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i) > max3[2]) {
				max3[0] = max3[1];
				max3[1] = max3[2];
				max3[2] = l.get(i);
				sum += l.get(i);
			}
			else if (l.get(i) > max3[1]) {
				max3[0] = max3[1];
				max3[1] = l.get(i);
				sum += l.get(i);
			}
			else if (l.get(i) > max3[0]) {
				max3[0] = l.get(i);
				sum += l.get(i);
			}
			else {
				sum += l.get(i);
			}
		}
		sum -= (max3[0] + max3[1] + max3[2]);
		return sum / (l.size() - 3);
	}
	
	public static void main(String[] args) {
		AdvertisedAverage_12 aa = new AdvertisedAverage_12();
		List<Integer> l = new ArrayList<> (Arrays.asList(3,6,12,55,289,600,534,900,172));
		System.out.println(aa.advertisedAverage(l));
		System.out.println((double)(3+6+12+55+289+172) / 6);
	}
}
