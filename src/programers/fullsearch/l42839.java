package programers.fullsearch;

import java.util.HashSet;

public class l42839 {
	public static void main(String[] args) {
//		String numbers = "17";
		String numbers = "011";
		System.out.println(solution(numbers));
		
	}
	static HashSet<Integer> hs;
	static String[] digit;
	
	public static int solution(String numbers) {
		int answer=0;
		digit = new String[numbers.length()];
		for (int i = 0; i < numbers.length(); i++)
			digit[i] = numbers.charAt(i) + "";
		hs = new HashSet<Integer>();
		makeNumber("", 0);
		for(int s : hs) {
			if(isPrimeNumber(s))answer++;
		}
		return answer;
	}

	public static void makeNumber(String cur, int depth) {
		if(depth>digit.length-1) {
			hs.add(StringToInt(cur));
			return;
		}
		makeNumber(cur+digit[depth], depth+1);
		makeNumber(cur, depth+1);
		makeNumber(digit[depth]+cur, depth+1);

	}
	public static Integer StringToInt(String s) {
		try {
			return Integer.valueOf(s);
		}catch (Exception e) {
			return 0;
		}
	}

	public static boolean isPrimeNumber(int n) {
		if(n<2) return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
