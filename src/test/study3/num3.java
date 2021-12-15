package test.study3;

import java.util.ArrayList;

public class num3 {
	// 1  2  3  4  5
	// 6  7  8  9  10
	// 11 12 13 14 15
	// 16 17 18 19 20
	
	// 반시계방향으로 출력
	// 중복되지 않도록
	// 1 6 11 16 17 18 19 20 15 10 5 4 3 2 7 12 13 14 9 8 
	
	// 엣지케이스를 검증할 수 있는 testcase를 넣어봐라
	// 시간복잡도 O(n*m)
	// 공간복잡도 O(n*m*2)
	public static void main(String[] args) {
		int n=5;
		int m=5;
		int[][] map = new int[n][m];
		
		int cnt =1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=cnt++;
			}
		}
		print(solution(n, m, map));
	}
	static boolean[][] visited;
	
	public static ArrayList<Integer> solution(int n, int m, int[][] map) {
		int[] dx = {0, 1, 0,-1};
		int[] dy = {1, 0,-1, 0};
		ArrayList<Integer> ans = new ArrayList<>();
		visited = new boolean[n][m];
		int cury = 0;
		int curx = 0;
		ans.add(map[cury][curx]);
		visited[cury][curx]=true;
		int cnt =1;
		int dir=0;
		while(cnt!=n*m) {
			int ny = cury+dy[dir%4];
			int nx = curx+dx[dir%4];
			if(canGoNext(ny, nx, n, m)) {
				visited[ny][nx]=true;
				ans.add(map[ny][nx]);
				cnt++;
				cury=ny;
				curx=nx;
			}else {
				dir++;
			}
		}
		
		return ans;
	}
	public static boolean canGoNext(int ny, int nx, int n, int m) {
		if(ny<0||ny>=n||nx<0||nx>=m||visited[ny][nx]) {
			return false;
		}
		return true;
	}
	public static void print(ArrayList<Integer> list) {
		for(int i : list)System.out.print(i+" ");
		System.out.println();
	}
}
