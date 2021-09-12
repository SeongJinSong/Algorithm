package programers.fullsearch;

import java.util.HashSet;

public class l42839 {
	public static void main(String[] args) {
		String numbers = "123";
		//String numbers = "011";
		System.out.println(solution(numbers));
	}

	static HashSet<Integer> hs;
	static String[] digit;

	public static int solution(String numbers) {
		int answer = 0;
		digit = new String[numbers.length()];
		for (int i = 0; i < numbers.length(); i++)
			digit[i] = numbers.charAt(i) + "";
		hs = new HashSet<Integer>();
		makeNumber("", 0);
		for (int s : hs) {
			if (isPrimeNumber(s))
				answer++;
		}
		return answer;
	}

	public static void makeNumber(String cur, int depth) {
		if (depth > digit.length - 1) {
			hs.add(StringToInt(cur));
			return;
		}
		makeNumber(cur, depth + 1);
		/*모든 케이스의 재귀 호출을 위해 끼워넣음*/
		for (int i = 0; i <= cur.length(); i++) {
			makeNumber(cur.substring(0, i) + digit[depth] + cur.substring(i, cur.length()), depth + 1);
		}
	}

	public static Integer StringToInt(String s) {
		try {
			return Integer.valueOf(s);
		} catch (Exception e) {
			return 0;
		}
	}

	public static boolean isPrimeNumber(int n) {
		if (n == 2)
			return true;
		if (n < 2 || n % 2 == 0)
			return false;
		// 짝수를 거르고 하면 더 성능 개선 할 수 있다.
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	/*best solution*/
	public static int solution2(String numbers) {
		HashSet<Integer> set = new HashSet<>();
		permutation("", numbers, set);
		int count = 0;
		while (set.iterator().hasNext()) {
			int a = set.iterator().next();
			set.remove(a);
			if (a == 2)
				count++;
			if (a % 2 != 0 && isPrime(a)) {
				count++;
			}
		}
		return count;
	}

	public static boolean isPrime(int n) {
		if (n == 0 || n == 1)
			return false;
		for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void permutation(String prefix, String str, HashSet<Integer> set) {
		int n = str.length();
		if (!prefix.equals("")) {
			set.add(Integer.valueOf(prefix));
		}
		//자기 자신을 확실하게 제외하는 재귀호출 방법
		for (int i = 0; i < n; i++)
			permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);

	}
}
