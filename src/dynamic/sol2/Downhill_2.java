package dynamic.sol2;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

class Cell implements Comparable<Cell>{
	int row, col, val;
	public Cell(int row, int col, int val){
		this.row=row;
		this.col=col;
		this.val=val;
	}
	@Override
	public int compareTo(Cell o) {
		// TODO Auto-generated method stub
		if(this.val < o.val) return -1;
		else if(this.val == o.val) return 0;
		else return 1;
	}
}
public class Downhill_2 {
	static int dx[] = {0,  0, 1, -1};
	static int dy[] = {1, -1, 0,  0};
	static int n, m;
	static int a[][] = new int[500][500];
	static long d[][] = new long[500][500];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		Vector<Cell> v = new Vector<Cell>();
		for (int i=0; i<n; i++) {
	        for (int j=0; j<m; j++) {
	            a[i][j] = sc.nextInt();
	            v.add(new Cell(i, j, a[i][j]));
	        }
	    }
		Collections.sort(v);
		d[n-1][m-1] = 1;
		for (int i=0; i<v.size(); i++) {
	        int x = v.get(i).row;
	        int y = v.get(i).col;
	        for (int k=0; k<4; k++) {
	            int nx = x+dx[k];
	            int ny = y+dy[k];
	            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
	                if (a[nx][ny] < a[x][y]) {
	                    d[x][y] += d[nx][ny];
	                }
	            }
	        }
	    }
		System.out.println(d[0][0]);
	}
}
