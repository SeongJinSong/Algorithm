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
        	System.out.println("---- size:"+size);
        	StringBuilder sb = new StringBuilder();
        	int idx = 0;
        	int i;
        	int cnt = 1;
        	for(i=idx;i+size<s.length();) {
        		String cur = s.substring(idx, idx+size);
        		if(i+size+size>s.length())break;
        		String next = s.substring(i+size,i+size+size);
        		System.out.print("idx:"+idx);
        		System.out.print(" i:"+i);
        		System.out.print(" cur:"+cur);
        		System.out.println(" next: "+next);
        		if(cur.equals(next)) {
        			cnt++;
        			i+=size;
        			if(i+size>=s.length()) {
        				i+=size;
        				sb.append(cnt+cur);
        				System.out.println("sb.toString():"+sb.toString());
        			}
        		}
        		else {
        			if(cnt!=1) {
        				sb.append(cnt+cur);
        				System.out.println("sb : "+sb.toString());
        				idx+=cnt*size;
        				i=idx;
        				cnt=1;
        			}
        			else {
        				sb.append(s.charAt(idx));
        				System.out.println("sb2 : "+sb.toString());
        				idx++;
        				i=idx;
        			}
        			
        		}
        	}
        	System.out.print("i: "+i);
        	sb.append(s.substring(i));
        	System.out.println(" result sb:"+sb.toString());
        	if(sb.length()!=0&&answer>sb.length())answer = sb.length();
        	sb = new StringBuilder();
        	size++;
        	
        }
        return answer;
    }
}
