package test.study2;

import java.util.LinkedList;
import java.util.List;

public class past1 {
	public static void main(String[] args) {
		List<Integer> arr = new LinkedList<Integer>();
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		int cnt = 1; int width=4; int to=12;
		for(int i=cnt;i<=to;i++) {
			arr.add(i);
			if(i%width==0) {
				res.add(arr);
				arr = new LinkedList<Integer>();
			}
		}
		print(solution(res));
	}
	public static List<Integer> solution(List<List<Integer>> list){
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		int h = list.size();
		int w = list.get(0).size();
		int size = w*h;
		boolean[][] visited=new boolean[h][w];
		int dir=0;
		int cury=0;
		int curx=0;
		visited[0][0]=true;
		List<Integer> ans = new LinkedList<Integer>();
		ans.add(1);
		for(int i=0;i<size-1;i++) {
			int ny=cury+dy[dir%4];
			int nx=curx+dx[dir%4];
			if(cango(ny, nx, h, w, visited)) {
				visited[ny][nx]=true;
				ans.add(list.get(ny).get(nx));
				cury=ny;
				curx=nx;
			}else {
				cury+=dy[++dir%4];
				curx+=dx[dir%4];
				visited[cury][curx]=true;
				ans.add(list.get(cury).get(curx));
			}
		}
		return ans;
	}
	public static boolean cango(int ny, int nx, int h, int w, boolean[][] visited) {
		if(ny>=h||ny<0||nx>=w||nx<0||visited[ny][nx]) {
			return false;
		}
		return true;
	}
	public static void print(List<Integer> arr) {
		for(int i : arr)System.out.print(i+" ");
		System.out.println();
	}
}
