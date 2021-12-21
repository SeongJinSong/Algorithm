package test.study3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class num1 {
	//문자열 substring 문제
	// abcabcabab
	// 중복되는 문자가 없는 가장 긴 substring의 길이를 리턴하라
	//return 3
	
	// 가장 긴 substring의 길이를 단순히 리턴하는 로직을 짜는 것 보다 최대한 효율적인 알고리즘을 생각해내는게 더 중요 
	public static void main(String[] args) {
//		String s = "abcabcabab";
		String s = "banana";
		System.out.println(lengthOfLongestSubstring4(s));
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
				//이건 left를 1씩 증가시키는 것이므로 완전 최적은 아님!
				left++;
			}
		}
		return max;
	}
	
	/** Approach 1: Brute Force **/
	public int lengthOfLongestSubstring1(String s) {
		int n = s.length();
		int res = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(checkRepetition(s, i, j)) {
					res = Math.max(res,  j-i+1);
				}
			}
		}
		return res;
	}
	private boolean checkRepetition(String s, int start, int end) {
		int[] chars = new int[128];
		for(int i=start; i<=end;i++) {
			char c = s.charAt(i);
			chars[c]++;
			if(chars[c]>1) {
				return false;
			}
		}
		return true;
	}
	//Time Complexity: O(n3)
	//Space Complexity: O(min(s.length, 알파벳 수))
	//The size of the Set is upper bounded by the size of the string Set n and the size of the charset/alphabet m
	
	/** Approach 2: Sliding Window **/
	public int lengthOfLongestSubstring2(String s) {
		int[] chars = new int[128];
		int left=0;
		int right=0;
		int res=0;
		while(right<s.length()) {
			char r = s.charAt(right);
			chars[r]++;
			
			while(chars[r]>1) {
				char l = s.charAt(left);
				chars[l]--;
				left++;
			}
			res=Math.max(res, right-left+1);
			right++;
		}
		return res;
	}
	//Time Complexity : O(2n)=O(n). In the worst case each character will be visited twice by i and j
	//Space Complexity: O(min(s.length, 알파벳 수))
	
	/** Approach 3: Sliding Window Optimized **/
	public int lengthOfLongestSubstring3(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int j=0,i=0;j<n;j++) {
			if(map.containsKey(s.charAt(j))) {
				i=Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j-i+1);
			map.put(s.charAt(j),j+1);
		}
		return ans;
	}
	//Time Complexity : O(n).
	//Space Complexity:  O(min(s.length, 알파벳 수)). m is the size of the charset
	
	/** Approach 3: Sliding Window Optimized more space **/
	/*int[26] for Letters 'a' - 'z' or 'A' - 'Z'
	int[128] for ASCII
	int[256] for Extended ASCII*/
	public static int lengthOfLongestSubstring4(String s) {
		Integer[] chars = new Integer[128];
		int left = 0;
		int right = 0;
		int res = 0;
		while(right < s.length()) {
			char r = s.charAt(right);
			Integer index = chars[r];
			if(index!=null && index >=left && index<right) {
				left = index+1;
			}
			res = Math.max(res,  right-left+1);
			chars[r]=right;
			right++;
		}
		return res;
	}
	//Time Complexity : O(n).
	//Space Complexity:  O(m). m is the size of the charset
}
