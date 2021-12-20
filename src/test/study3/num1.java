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
		System.out.println(solution2(s));
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
	
	//2차 솔루션
	public static int solution2(String s) {
		int[] including = new int[256];
		// if including['a'] !=1, 'a' is in current substring window
		// if including['a'] ==0, 'a' is not in current substring window
		int max=0;
		int left=0;
		int right=0;
		int length = s.length();
		
		if(s.length()==1)return 1;
		while(left < length) {
			if(including[s.charAt(right)]==0) {
				including[s.charAt(right)]++;
				right++;
				max = Math.max(max, right-left);
				if(right==length) {
					break;
				}
			}else {
				including[s.charAt(left)]--;
				left++;
			}
		}
		return max;
	}
}
