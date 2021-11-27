package test.study;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class line_2019_1 {
	public static void main(String[] args) {
		int c = 11;
		int b = 2;
		System.out.println(new line_2019_1().solution2(c, b));
	}
	static HashMap<String, String> hm;
	static int minTime=Integer.MAX_VALUE;
	public static int solution(int c, int b) {
		hm = new HashMap<String, String>();
		match(c, b, 0, "");
		return minTime==Integer.MAX_VALUE?-1:minTime;
	}
	/* 재귀함수로 문제를 풀었을 때 문제점!
	 * 재귀함수는 선언한 순서대로 처리하기 때문에 엄청 늦게 찾아진다.
	 * 아래의 경우 1 -> 1 -> 1 -> 1 끝나면 2 -> 2 -> 2 -> 2
	 * 즉 DFS와 같은 방식으로 탐색을 하게 된다.
	 * 그렇기 때문에 BFS로 풀어야 한다.
	 * */
	public static void match(int c, int b, int time, String gap) {
		if(b<0||b>200000)return;
		if(c>200000)return;
		if(time>minTime) {
			return;
		}
		if(b==c&&time<minTime) {
			minTime=time;
			return;
		}
		if(!hm.containsKey(b+" "+time))hm.put(b+" "+time, "");
		else return;
		match(c+time+1, b*2, time+1, " 1");
		match(c+time+1, b+1, time+1, " 2");
		match(c+time+1, b-1, time+1, " 3");
	}
	/*
	 * 배열의 index를 시간으로 설정하여 푸는 방법
	 * */
	public static int solution2(int c, int b) {
		int pos[] = new int[200001];
		int answer = -1;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(b);
		while(true) {
			int curb = q.poll();
			int time = pos[curb];
			int cony = 0;
			for(int i=1;i<=time;i++)cony+=i;
			if(curb==c+cony) {
				answer = pos[curb];
				break;
			}
			int next=0;
			for(int i=0;i<3;i++) {
				if(i==0)next=curb-1;
				if(i==1)next=curb+1;
				if(i==2)next=curb*2;
				if(next>=0 && next<=200000&&pos[next]==0) {
					q.add(next);
					pos[next] = pos[curb]+1;
				}
			}
		}
		return answer;
	}
}
