package programers.fullsearch;

import java.util.HashSet;

public class l42839 {
	public static void main(String[] args) {
		String numbers = "123";
		//String numbers = "011";
		//System.out.println(isPrimeNumber(11));
		System.out.println(solution(numbers));
		System.out.println("cnt:"+cnt);
		
	}
	static HashSet<Integer> hs;
	static String[] digit;
	static int cnt=0;
	
	public static int solution(String numbers) {
		int answer=0;
		digit = new String[numbers.length()];
		for (int i = 0; i < numbers.length(); i++)
			digit[i] = numbers.charAt(i) + "";
		hs = new HashSet<Integer>();
		for(int i=0;i<digit.length;i++)
			makeNumber(digit[i], 0, i);
		for(int s : hs) {
			if(isPrimeNumber(s))answer++;
		}
		return answer;
	}

	public static void makeNumber(String cur, int depth, int start) {
		if(depth>digit.length-1) {
			cnt++;
			hs.add(StringToInt(cur));
			return;
		}
		makeNumber(cur, depth+1, start);
		if(depth!=start) {
			makeNumber(cur+digit[depth], depth+1, start);
			makeNumber(digit[depth]+cur, depth+1, start);
		}

	}
	public static Integer StringToInt(String s) {
		try {
			return Integer.valueOf(s);
		}catch (Exception e) {
			return 0;
		}
	}

	public static boolean isPrimeNumber(int n) {
		System.out.println("n:"+n);
		if(n<2) return false;
		for (int i = 2; i * i<= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
