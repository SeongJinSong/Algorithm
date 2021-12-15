package test.study3;

import java.util.HashSet;

public class num1 {
	//문자열 substring 문제
	// abcabcabab
	// 중복되는 문자가 없는 가장 긴 substring의 길이를 리턴하라
	//return 3
	
	// 가장 긴 substring의 길이를 단순히 리턴하는 로직을 짜는 것 보다 최대한 효율적인 알고리즘을 생각해내는게 더 중요 
	public static void main(String[] args) {
		String s = "abcabcabab";
		System.out.println(solution(s));
	}
	//1차 솔루션
	public static int solution(String s) {
		int n = s.length();
		int max = 0;
		for(int i=0;i<n;i++) {
			int cnt=0;
			HashSet<Character> hs = new HashSet<>();
			for(int j=i;j<n;j++) {
				if(!hs.add(s.charAt(j)))break;
				cnt++;
			}
			max=Math.max(max, cnt);
		}
		return max;
	}
}
