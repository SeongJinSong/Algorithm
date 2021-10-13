package programers.lv2;

public class l60057 {
	public static void main(String[] args) {
//		String s="aabbaccc";
//		String s="ababcdcdababcdcd";
//		String s="abcabcdede";
		String s="abcabcabcabcdededededede";
//		String s="xababcdcdababcdcd";
		System.out.println(solution3(s));
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
        				cnt=1;
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
        				sb.append(cur);
        				curIdx+=size;
        				appendIdx=curIdx;
        			}
        			
        		}
        	}
        	if(cnt!=1)sb = new StringBuilder().append(cnt).append(sb);
        	sb.append(s.substring(appendIdx));
        	if(sb.length()!=0&&answer>sb.length())answer = sb.length();
        	sb = new StringBuilder();
        	size++;
        }
        return answer;
    }
	/* 재귀호출 방식을 이용하여 푼 예
	 *  - 1개도 일치하지 않은 경우 prestring 붙이고
	 *  - 1개 이상 일치했던 경우는 숫자 + preString 붙이고
	 *  - 일치하는 경우는 split한다.
	 * */
	public static int solution2(String s) {
		int answer = 0;
		for(int i=1;i<=(s.length()/2)+1;i++) {
			int result = getSplitedLength(s, i, 1).length();
			answer = i==1?result:(answer>result?result:answer); // 최소값 비교를 한줄로 하는 방법
		}
		return answer;
	}
	public static String getSplitedLength(String s, int n, int repeat) {
		if(s.length()<n) return s;
		String result = "";
		String preString = s.substring(0, n);
		String postString = s.substring(n, s.length());
		
		//불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
		if(!postString.startsWith(preString)) {
			if(repeat==1)return result+=preString + getSplitedLength(postString, n, 1);
			return result+=repeat+preString+getSplitedLength(postString, n, repeat+1);
		}
		return result+=getSplitedLength(postString, n, repeat+1);
	}
	
	/* 내가 푼 방법과 플이 원칙은 같지만 자릿수만 계산하는 풀이라서 내 풀이보다 조금더 깔끔하다.
	 * Math.log10(cnt)을 통해 자릿수만 계산
	 * */
	public static int solution3(String s) {
		int min = s.length();
		int len = s.length()/2+1;
		for(int size=1;size<len;size++) {
			String before = "";
			int sum = 0;
			int cnt = 1;
			for(int j=0;j<s.length();) {
				int start = j;
				j = (j+size>s.length())?s.length():j+size;
				String temp = s.substring(start, j);
				if(temp.equals(before)) {
					cnt++;
				}else {
					if(cnt!=1) {
						sum+=(int)Math.log10(cnt)+1;
					}
					cnt=1;
					sum+=before.length();
					before=temp;
				}
			}
			sum+=before.length();
			if(cnt!=1) {
				sum+=(int)Math.log10(cnt)+1;
			}
			min = (min>sum)?sum:min;
		}
		return min;
	}
}
