package programers.greedy;

import java.util.Arrays;

public class l42860 {
	public static void main(String[] args) {
//		String name = "JEROEN";
//		String name = "JAN";
		String name = "ZZAAZZ";
		System.out.println(solution(name));
	}
	public static int solution(String name) {
        int answer = 0;
        
        char[] curName = new char[name.length()];
        for(int i=0;i<name.length();i++)curName[i]='A';
        
        int cursor=0;
        while(!concat(curName).equals(name)) {
        	// 위아래는 목표로 변경하려는 쪽과 가까운쪽
        	if(name.charAt(cursor)!=curName[cursor]) {
        		curName[cursor] = name.charAt(cursor);
        		answer += Math.min(name.charAt(cursor)-'A', 26-(name.charAt(cursor)-'A'));
        	}
        	// 좌우중 목표와 다른것과 가까운쪽
        	int left=cursor;
        	int right=cursor;
        	while(true) {
        		left=left==0?left=name.length()-1:left-1;
        		right=right==name.length()-1?right=0:right+1;
        		if(name.charAt(right)!=curName[right]) {
        			answer += right-cursor < 0 ? name.length() + right - cursor : right-cursor;
        			cursor=right;
        			break;
        		}
        		if(name.charAt(left)!=curName[left]) {
        			answer += cursor-left < 0 ? name.length()+cursor-left:cursor-left;
        			cursor=left;
        			break;
        		}
        		if(left==right)break;
        	}
        	
        }
        return answer;
    }
	public static String concat(char[] arr) {
		StringBuilder sb = new StringBuilder();
        for(char c:arr)sb.append(c);
        return sb.toString();
	}
}
