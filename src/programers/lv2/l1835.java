package programers.lv2;

import java.util.HashMap;

public class l1835 {
	public static void main(String[] args) {
//		int n=2; String[] data= {"N~F=0", "R~T>2"};
		int n=2; String[] data= {"M~C<2", "C~M>1"};
		System.out.println(new l1835().solution(n, data));
	}
	String[] d;
	HashMap<Character, Integer> hm;
	boolean[] visited;
	int[] position;
	int answer;
	public int solution(int n, String[] data) {
        d = data;
        hm = new HashMap<Character, Integer>();
        visited = new boolean[8];
        position = new int[8];
        answer = 0;
        hm.put('A', 0);
        hm.put('C', 1);
        hm.put('F', 2);
        hm.put('J', 3);
        hm.put('M', 4);
        hm.put('N', 5);
        hm.put('R', 6);
        hm.put('T', 7);
        dfs(0);
        print(position);
        return answer;
    }
	
	public void dfs(int idx) {
		if(idx==8) {
			if(check())answer++;
		}
		else {
			for(int i=0;i<8;i++) {
				if(!visited[i]) {
					visited[i] = true;
					position[idx]=i;
					dfs(idx+1);
					visited[i]=false;
				}
			}
		}
	}
	
	public boolean check() {
		int a, b, res;
		char op;
		for(String s : d) {
			a=position[hm.get(s.charAt(0))];
			b=position[hm.get(s.charAt(2))];
			op=s.charAt(3);
			res=s.charAt(4)-'0' + 1;
			
			if(op=='=') {
				if(Math.abs(a-b)!=res) return false;
			}
			else if(op=='>') {
				if(Math.abs(a-b)<=res) return false;
			}
			else {
				if(Math.abs(a-b) >= res) return false;
			}
		}
		return true;
	}
	public void print(int[] arr) {
		for(int i : arr)System.out.print(i+" ");
		System.out.println();
	}
	boolean check[];
	char friends[] = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	int result;
	
	public boolean isPossible(StringBuilder sb, String[] data) {
		for(int i=0;i<data.length;i++) {
			int gap = Math.abs(sb.indexOf(String.valueOf(data[i].charAt(0))) - sb.indexOf(String.valueOf(data[i].charAt(2))));
			int condition_gap = data[i].charAt(4)-'0';
			switch(data[i].charAt(3)) {
			case '=':
				if(gap!= condition_gap) return false;
				break;
			case '>':
				if(gap < condition_gap) return false;
				break;
			case '<':
				if(gap > condition_gap) return false;
				break;
			}
		}
		return true;
	}
	public void dfs(int idx, StringBuilder sb, String[] data) {
		if(idx == friends.length) {
			if(isPossible(sb, data)) {
				answer++;
			}
			return;
		}
		for(int i=0;i<friends.length;i++) {
			if(check[i])continue;
			check[i] = true;
			sb.append(String.valueOf(friends[i]));
			dfs(idx+1, sb, data);
			check[i]=false;
			sb.delete(idx, friends.length);
		}
	}
	public int solution2(int n, String[] data) {
		StringBuilder sb = new StringBuilder();
		answer = 0;
		dfs(0, sb, data);
		return answer;
	}
}
