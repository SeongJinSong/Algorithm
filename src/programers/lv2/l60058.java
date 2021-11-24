package programers.lv2;

import java.util.EmptyStackException;
import java.util.Stack;

public class l60058 {
	public static void main(String[] args) {
//		String p = "(()())()";
//		String p = ")(";
		String p = "()))((()";
		System.out.println(new l60058().solution(p));
	}
	public String solution(String p) {
		StringBuilder sb = new StringBuilder();
		divide(p, sb);
		return sb.toString();
    }
	public void divide(String s, StringBuilder sb) {
		if("".equals(s))return;
		if(correct(s)) {
			sb.append(s);
			return;
		}
		int idx = balance(s);
		String u = s.substring(0, idx);
		String v = s.substring(idx);
		if(correct(u)) {
			sb.append(u);
			divide(v, sb);
		}
		else {
			sb.append("(");
			divide(v, sb);
			sb.append(")");
			convert(u, sb);
		}
	}
	public int balance(String s) {
		int i=0;
		int openCnt=0;
		int closeCnt = 0;
		for(i=0;i<s.length();i++) {
			if('('==s.charAt(i))openCnt++;
			if(')'==s.charAt(i))closeCnt++;
			if(openCnt>=1&&openCnt==closeCnt)return i+1;
		}
		return s.length();
	}
	public void convert(String s, StringBuilder sb) {
		for(int i=1;i<s.length()-1;i++) {
			if('('==s.charAt(i))sb.append(')');
			else if(')'==s.charAt(i))sb.append('(');
		}
	}
	public boolean correct(String s) {
		Stack<Character> stk = new Stack<Character>();
		try {
			for (int i = 0; i < s.length(); i++) {
				if ('(' == s.charAt(i))
					stk.add('(');
				else if (')' == s.charAt(i))
					stk.pop();
			}
		} catch (EmptyStackException e) {
			return false;
		}
		if (stk.size() == 0)
			return true;
		return false;
	}
}
