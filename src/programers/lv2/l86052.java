package programers.lv2;

import java.util.ArrayList;

public class l86052 {
	public static void main(String[] args) {
//		String[] grid = {"SL","LR"};
//		String[] grid = {"S"};
		String[] grid = {"RLR","LRL","RRR"};
		new l86052().print(new l86052().solution(grid));
	}
	int R, C;
	int[] dr= {-1,0,1,0}, dc= {0,-1,0,1};// 아래, 왼, 위, 오른
	boolean[][][] visited;
	public int[] solution(String[] grid) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		R = grid.length;
		C = grid[0].length();
		visited = new boolean[R][C][4];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				for(int d=0;d<4;d++) {
					if(!visited[i][j][d])
						answer.add(light(grid, i, j ,d));
				}
			}
		}
		return answer.stream().sorted().mapToInt(i->i).toArray();
	}
	private int light(String[] grid, int r, int c, int d) {
		int cnt=0; //이동거리
		while(true) {
			if(visited[r][c][d])break;
			cnt++;
			visited[r][c][d] =true; //방문처리
			if(grid[r].charAt(c)=='L')d=d==0?3:d-1;// 좌회전
			else if(grid[r].charAt(c)=='R')d=d==3?0:d+1;//우회전
			r=(r+dr[d]+R)%R;
			c=(c+dc[d]+C)%C;
		}
		return cnt;
	}
	public void print(int[] arr) {
		for(int i:arr)System.out.print(i+" ");
		System.out.println();
	}
}
