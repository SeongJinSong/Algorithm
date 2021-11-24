package programers.lv2;

public class l81302 {
	public static void main(String[] args) {
		String[][] places= {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
//		String[][] places = { { "OOPOO", "OPOOO", "OOOOO", "OOOOO", "OOOOO" } };
		new l81302().print(new l81302().solution3(places));
	}
	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		for (int i = 0; i < places.length; i++) {
			answer[i] = check(places[i]);
		}
		return answer;
	}
	public int check(String[] place) {
		char[][] p = new char[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				p[i][j] = place[i].charAt(j);
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (p[i][j] == 'P' && !isOK(p, i, j)) {
					return 0;
				}
			}
		}
		return 1;
	}
	boolean flag = true;
	public boolean isOK(char[][] p, int y, int x) {
		boolean[][] visited = new boolean[5][5];
		flag = true;
		visited[y][x] = true;
		search(p, y, x, y, x, visited);
		return flag;
	}

	public void search(char[][] p, int y, int x, int cury, int curx, boolean[][] visited) {
		visited[cury][curx] = true;
		if (Math.abs(y - cury) + Math.abs(x - curx) > 2)
			return;
		if (p[cury][curx] == 'X')
			return;
		if (!(x == curx && y == cury) && p[cury][curx] == 'P') {
			flag = false;
			return;
		}
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		for (int i = 0; i < 3; i++) {
			if (curx + dx[i] >= 0 && curx + dx[i] < 5 && cury + dy[i] >= 0 && cury + dy[i] < 5
					&& !visited[cury + dy[i]][curx + dx[i]]) {
				search(p, y, x, cury + dy[i], curx + dx[i], visited);
			}
		}
	}

	public void print(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}

	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };
	boolean[][] visit;
	int[] answer;
	public void dfs(int num, int x, int y, int count, String[] places) {
		if(count>2)return;
		if(count>0 &&count<=2&&places[x].charAt(y)=='P'){
			answer[num]=0;
			return;
		}
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0&&nx<5&&ny>=0&&ny<5&&places[nx].charAt(ny)!='X') {
				if(visit[nx][ny])continue;
				visit[nx][ny]=true;
				dfs(num, nx, ny, count+1,places);
				visit[nx][ny]=false;
			}
		}
	}
	public int[] solution2(String[][] places) {
		answer = new int[places.length];
		for(int i=0;i<places.length;i++) {
			answer[i]=1;
		}
		for(int i=0;i<places.length;i++) {
			visit = new boolean[5][5];
			for(int j=0;j<5;j++) {
				for(int k=0;k<5;k++) {
					if(places[i][j].charAt(k)=='P') {
						visit[j][k]=true;
						dfs(i,j,k,0,places[i]);
						visit[j][k]=false;
					}
				}
			}
		}
		return answer;
	}
	int[] RD = {1,-1,0,0}, CD = {0,0,1,-1};
	boolean isPossible(int r, int c) {
		return 0<=r&&r<5&&0<=c&&c<5;
	}
	public int[] solution3(String[][] places) {
		int[] answer = new int[places.length];
		for(int tc=0;tc<places.length;++tc) {
			int res=1;
			char[][] board = new char[5][5];
			for(int r=0;r<5;++r) {
				board[r] = places[tc][r].toCharArray(); //자바가 이게 되네...
			}
			
			aaa:for(int r=0;r<5;++r) {
				for(int c=0;c<5;++c) {
					if(board[r][c] =='X')continue;
					int peopleCnt=0;
					if(board[r][c]=='P')++peopleCnt;
					for(int i=0;i<4;i++) {
						int nr = r+RD[i];
						int nc = c+CD[i];
						if(!isPossible(nr, nc))continue;
						if(board[nr][nc]=='P')++peopleCnt;
					}
					if(peopleCnt>=2) {
						res=0;
						break aaa;
					}
				}
			}
			answer[tc]=res;
		}
		return answer;
	}
}
