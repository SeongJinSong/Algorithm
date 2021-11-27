package test.study;

import java.util.LinkedList;
import java.util.Queue;

public class num3 {
	public static void main(String[] args) {
//		int n=5, k=12;
//		int n=5, k=16;
		int n=6, k=13;
		new num3().print(new num3().solution(n, k));
	}
	int[][] map;
	public int[] solution(int n, int k) {
		int[] answer = new int[2];
		int idx=3;
		if(k==1) {
			answer[0]=0;answer[1]=0;
			return answer;
		}
		if(k==2) {
			answer[0]=n-1;answer[1]=n-1;
			return answer;
		}
		map=new int[n][n];
		map[0][0]=1;
		map[n-1][n-1]=2;
		int lasty=0;
		int lastx=0;
		while(idx<=k) {
			int[] res = longDist(n);
			lasty=res[0];
			lastx=res[1];
			map[lasty][lastx]=idx++;
		}
		answer[0]=lasty+1;
		answer[1]=lastx+1;
        return answer;
    }
	class Node{
		int y;
		int x;
		int dist;
		public Node(int y, int x, int dist) {
			this.y=y;
			this.x=x;
			this.dist=dist;
		}
	}
	public int[] longDist(int n) {
		int[][] distMap = new int[n][n];
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		Queue<Node> q = new LinkedList<Node>();
		int max = 0;
		int maxy = 0;
		int maxx = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]!=0) {
					q.add(new Node(i, j, 0));
					distMap[i][j]=-1;
				}
			}
		}
		while(!q.isEmpty()) {
			Node next=q.poll();
			if(distMap[next.y][next.x]==0)
				distMap[next.y][next.x]=next.dist;
			
			for(int i=0;i<4;i++) {
				int ny=next.y+dy[i];
				int nx=next.x+dx[i];
				if(ny<0||ny>=n||nx<0||nx>=n) continue;
				if(distMap[ny][nx]==0) q.add(new Node(ny, nx, next.dist+1));
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(max<distMap[i][j]) {
					max=distMap[i][j];
					maxy=i;
					maxx=j;
				}else if(max==distMap[i][j]) {
					if(maxx>j) {
						maxy=i;
						maxx=j;
					}
				}
			}
		}
		int[] answer = new int[2];
		answer[0]=maxy;
		answer[1]=maxx;
		return answer;
	}
	public void print(int[] arr) {
		for(int i: arr)System.out.print(i+" ");
		System.out.println();
	}
}
