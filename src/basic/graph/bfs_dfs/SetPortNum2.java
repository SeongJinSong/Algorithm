package basic.graph.bfs_dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SetPortNum2 {
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	static int a[][];
	static int c[][];
	static int n;
	static ArrayList<Integer> ans = new ArrayList();
	public static void dfs(int x, int y, int s) {
		if(c[x][y] != 0&&a[x][y]==0) {
			return;
		}
		c[x][y] = s;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||nx>=n||ny<0||ny>=n) {
				continue;
			}
			if(c[nx][ny]==0&a[nx][ny]==1) {
				dfs(nx, ny, s);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		a = new int[n][n];
		c = new int[n][n];
		for(int i=0;i<n;i++) {
			String line = sc.nextLine();
			for(int j=0;j<line.length();j++	) {
				a[i][j] = line.charAt(j)-'0';
			}
		}
		int k=1;
		ans.add(0);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(c[i][j]==0&&a[i][j]==1) {
					dfs(i,j,k++);
				}
			}
		}
		for(int i=0;i<k-1;i++) {
			ans.add(0);
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(c[i][j]!=0) {
					ans.set(c[i][j]-1, ans.get(c[i][j]-1)+1);
				}
			}
		}
		Collections.sort(ans);
		System.out.println(k-1);
		for(int i=1;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
}
