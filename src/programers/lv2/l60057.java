package programers.lv2;

public class l60057 {
	public static void main(String[] args) {
//		String s="aabbaccc";
//		String s="ababcdcdababcdcd";
//		String s="abcabcdede";
//		String s="abcabcabcabcdededededede";
		String s="xababcdcdababcdcd";
		System.out.println(solution(s));
	}
	public static int solution(String s) {
        int answer = s.length();
        int size = 1;
        while(size<=s.length()/2) {
        	StringBuilder sb = new StringBuilder();
        	int curIdx = 0; // 현재 압축 기준이 되는 idx
        	int appendIdx; //압축 스트링에 넣은 idx
        	int cnt = 1;
        	for(appendIdx=curIdx;appendIdx+size<s.length();) {
        		String cur = s.substring(curIdx, curIdx+size);
        		if(appendIdx+2*size>s.length())break;
        		String next = s.substring(appendIdx+size,appendIdx+size+size);
        		if(cur.equals(next)) {
        			cnt++;
        			appendIdx+=size;
        			if(appendIdx+size>=s.length()) {
        				appendIdx+=size;
        				sb.append(cnt+cur);
        			}
        		}
        		else {
        			if(cnt!=1) {
        				sb.append(cnt+cur);
        				curIdx+=cnt*size;
        				appendIdx=curIdx;
        				cnt=1;
        			}
        			else {
        				sb.append(s.charAt(curIdx));
        				curIdx++;
        				appendIdx=curIdx;
        			}
        			
        		}
        	}
        	sb.append(s.substring(appendIdx));
        	if(sb.length()!=0&&answer>sb.length())answer = sb.length();
        	sb = new StringBuilder();
        	size++;
        }
        return answer;
    }
}
