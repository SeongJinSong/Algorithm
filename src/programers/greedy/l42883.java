package programers.greedy;

import java.util.Stack;
import java.util.TreeSet;

public class l42883 {
	public static void main(String[] args) {
//		String number="1924"; int k=3;
//		String number="1231234"; int k=3;
//		String number="4177252841"; int k=4;
//		String number="321924"; int k=2;
		String number="9998887776665554443332221110009"; int k=30;
		System.out.println(solution2(number, k));
	}
	/* 그리디 문제라 재귀호출로 풀면 죽었다 깨어나도 성능테스트를 통과 못함*/
	static TreeSet<String> ts = new TreeSet<String>((o1, o2)-> {
		if(o1.length()==o2.length()) {
			return (o1+o2).compareTo(o2+o1);
		}
		return o1.length()-o2.length();
	});
	public static String solution(String number, int k) {
		deleteChar(new StringBuilder(number), number, k);
        return String.valueOf(ts.pollLast());
    }
	public static void deleteChar(StringBuilder sb, String number, int k) {
		if(sb.toString().length()<number.length()-k)return;
		else if(sb.toString().length()==number.length()-k) {
			ts.add(sb.toString());
			return;
		}
		for(int i=0;i<sb.toString().length();i++) {
			deleteChar(new StringBuilder(sb).delete(i, i+1),number, k);
		}
	}
	
	/*그리디 알고리즘으로 풀어보자
	 * 1개를 지웠을 때 가장 큰 수가되는 index를 찾아서 지워준다.
	 * 그걸 k개까지 반복한다.
	 * 
	 * 질문에서 실수로 first, second를 봐버림;
	 * 1.다음에 올 숫자와 크기를 비교한다.
	 * 2.다음꺼가 더 크면 현재를 지운다.
	 * 
	 * 이게 내가 생각하는 최고 효율적인 알고리즘인데 절대 풀리지 않았다.
	 * 무슨짓을 해도 안풀렸는데 원인은 sb.toString()을 사용한 것이었다.
	 * sb.charAt(i), sb.deleteCharAt(i), sb.length() 전부 사용 가능한 로직이었다;
	 * toString을 사용하는게 이렇게까지 성능에 문제를 발생시킬거라곤 생각도 못했다.
	 * */
	public static String solution2(String number, int k) {
		StringBuilder sb = new StringBuilder(number);
		int index = 0;
		while(k>0&&index<sb.length()-1) {
			if(	sb.charAt(index)<sb.charAt(index+1)) {
				sb.deleteCharAt(index);
				index = index==0?0:index-1;
				k--;
			}
			else index++;
		}
		return sb.delete(sb.length()-k, sb.length()).toString();
    }
	/* 스택을 사용한 솔루션
	 * 테스트 해보니 삭제해야하는 문자가 많을 때 
	 * sb.deleteCharAt을 사용하는거보다 스택이 더 빠르다.
	 * */
	public static String solution3(String number, int k) {
		char[] result = new char[number.length()-k];
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<number.length();i++) {
			char c = number.charAt(i);
			while(!stack.isEmpty()&&stack.peek() < c&& k-->0) {
				stack.pop();
			}
			stack.push(c);
		}
		for(int i=0;i<result.length;i++) {
			result[i] = stack.get(i);
		}
		return new String(result);
	}
	
	/*특이한 풀이방식이라 가져와 봤다.*/
	public static String solution4(String number, int k) {
		StringBuilder sb = new StringBuilder();
		int cnt = number.length()-k;	// 선택해야하는 숫자
		int left = 0;
		int right = k; //최대값을 찾을 범위
		int max = -1;
		int idx = 0;
		while(cnt>0) {
			max = -1;
			// left와 right 사이의 최대값
			for(int i=left;i<=right;i++) {
				if(number.charAt(i)-'0' > max) {
					idx=i;
					max = number.charAt(i)-'0';
				}
			}
			sb.append(number.charAt(idx));
			left = idx+1; //시작점은 이전 max값 index의 다음부터
			right = number.length()- --cnt; // 선택해야하는 숫자가 줄을수록 뒤에까지 삭제가능
		}
		return sb.toString();
	}
}
