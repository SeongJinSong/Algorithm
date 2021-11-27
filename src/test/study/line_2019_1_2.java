package test.study;

import java.util.LinkedList;
import java.util.Queue;

public class line_2019_1_2 {
	public static void main(String[] args) {
		System.out.println(solution(11, 2));
	}
	static class Brown{
		int loc;
		int time;
		public Brown(int loc, int time) {
			this.loc=loc;
			this.time=time;
		}
	}
	public static int solution(int cony, int brown) {
		Queue<Brown> q = new LinkedList<Brown>();
		q.add(new Brown(brown, 0));
		while(!q.isEmpty()) {
			Brown nextb = q.poll();
			//System.out.println("nextb.loc:"+nextb.loc+" nextb.time:"+nextb.time);
			if(getConyLoc(cony, nextb.time)==nextb.loc)return nextb.time;
			
			if(isIn(nextb.loc*2))
				q.add(new Brown(nextb.loc*2, nextb.time+1));
			if(isIn(nextb.loc+1))
				q.add(new Brown(nextb.loc+1, nextb.time+1));
			if(isIn(nextb.loc-1))
				q.add(new Brown(nextb.loc-1, nextb.time+1));
		}
		return -1;
	}
	public static int getConyLoc(int c, int time) {
		for(int i=0;i<=time;i++) {
			c+=i;
		}
		return c;
	}
	public static boolean isIn(int loc) {
		return 0<=loc&&loc<=200000;
	}
}
