package programers.lv2;

import java.util.Stack;

public class l12973 {
	public static void main(String[] args) {
		String s = "baabaa";
		System.out.println(new l12973().solution(s));
	}
	public int solution(String s)
    {
        while(s.length()>0){
        	StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(i<s.length()-1&&s.charAt(i)==s.charAt(i+1)){
                    i++;
                    continue;
                }
                else sb.append(s.charAt(i));
            }
            if(s.length()==sb.length()) {
            	return 0;
            }
            else if(sb.length()>0) {
            	s=sb.toString();
            }
            else if(sb.length()==0) {
            	return 1;
            }
        }
        return 1;
    }
	// 스택으로 풀면 되는 간단한 문제를 순간 생각하지 못하고 뻘짓을 했다;;;
	public int solution2(String s)
    {
        Stack<Character> stk = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(stk.isEmpty()){
                stk.push(s.charAt(i));
                continue;
            }
            if(stk.peek()==s.charAt(i))stk.pop();
            else stk.push(s.charAt(i));
        }
        if(stk.isEmpty()) return 1;
        return 0;
    }
}
