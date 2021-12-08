package hackerrank.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleArraySum {
	public static int simpleArraySum(List<Integer> ar) {
		// Write your code here
		int sum = 0;
		for (int i : ar)
			sum += i;
		return sum;
	}
}
