package programers.greedy;

import java.util.Arrays;

public class l42860 {
	public static void main(String[] args) {
//		String name = "JEROEN";
//		String name = "JAN";
		String name = "ZZAAZZ";
		System.out.println(solution2(name));
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
	/* 더 나은 해법
	 * 위아래값은 고정이므로 먼저 구한다.
	 * 0<=index<length까지 next까지 가는 길중 오른쪽 왼쪽중 최소값이 나오는 거리를 구한다.
	 * 그러면 전체케이스중 가장 최단거리로 좌우로 이동하는 거리가 된다.
	 * */
	public static int solution2(String name) {
		int answer = 0;
        int[] diff={0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
        // 위아래에 드는 비용을 먼저 계산한다.
        for(char c : name.toCharArray()) answer+=diff[c-'A'];
        
        int length = name.length();
        int min = length - 1;
        for(int i=0;i<length;i++) {
        	int next=i+1;
        	while(next<length && name.charAt(next)=='A') {
        		next++;
        	}
        	/* length-(next-i) -> next를 반대쪽으로 가는 경우
        	 * next : 인덱스 i부터 A가 아닌 다음것 */
        	/* Math.min(i, length-next) 
        	 * 0을 기준으로 i로 가는데 왼쪽과 오른쪽 중 더 가까운곳의 비용 */
        	min=Math.min(min, length-(next-i)+Math.min(i, length-next));
        	/*MIN(
        	 * 	한쪽으로 쭉 가거나, 
        	 * 	오른쪽에서 i까지 왔다가 반대쪽으로 가거나, 
        	 * 	왼쪽으로 next까지 갔다가 i로  오는것)
        	 */
        }
        return answer+min;
	}
}
