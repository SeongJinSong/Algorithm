package programers.fullsearch;

import java.util.ArrayList;

public class l42840 {
	public static void main(String[] args) {
		int[] answers = { 1, 3, 2, 4, 2 };
		print(solution(answers));
	}

	public static int[] solution(int[] answers) {
		int[] m1 = { 1, 2, 3, 4, 5 };
		int[] m2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] m3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int[] cnt = { 0, 0, 0 };
		int max = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == m1[i % m1.length]) cnt[0]++;
			if (answers[i] == m2[i % m2.length]) cnt[1]++;
			if (answers[i] == m3[i % m3.length]) cnt[2]++;
		}
		for (int i = 0; i < cnt.length; i++) {
			if (max <= cnt[i]) max = cnt[i];
		}
		for (int i = 0; i < cnt.length; i++) {
			if (max == cnt[i]) arr.add(i + 1);
		}
		return arr.stream().mapToInt(i -> i).toArray();
	}

	public static void print(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
	}
}
