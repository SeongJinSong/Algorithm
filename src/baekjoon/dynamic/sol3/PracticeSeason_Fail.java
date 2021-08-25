package baekjoon.dynamic.sol3;

import java.util.Scanner;

public class PracticeSeason_Fail {
	static int C, D, dd;
	static int d[][][][][];
	static int n, m;
	static int a[] = new int[111];
	static int b[] = new int[111];
	static int go(int day, int x, int y, int prevx, int prevy) {
		if(x==n&&y==m)return 0;
		if(day>=210) return 1000000;
		if(d[day][x][y][prevx][prevy]!=0)
			return d[day][x][y][prevx][prevy];
		if(x<n&&y<m) {
			int temp = C;
			if(a[x] != b[y])
				temp+=C;
			if(d[day][x][y][prevx][prevy]==0||
				d[day][x][y][prevx][prevy]>temp + go(day+1,x+1,y+1,0,0))
			{
				d[day][x][y][prevx][prevy] = temp + go(day+1,x+1,y+1,0,0);
			}
		}
		if(x<n) {
			int temp = C;
			temp+=dd;
			if(prevy==0) temp+=D;
			if(d[day][x][y][prevx][prevy]==0||
				d[day][x][y][prevx][prevy]>temp + go(day+1,x+1,y,0,1))
			{
				d[day][x][y][prevx][prevy] = temp + go(day+1,x+1,y,0,1);
			}
		}
		if(y<m) {
			int temp = C;
			temp+=dd;
			if(prevx==0) temp+=D;
			if(d[day][x][y][prevx][prevy]==0||
				d[day][x][y][prevx][prevy]>temp + go(day+1,x,y+1,1,0))
			{
				d[day][x][y][prevx][prevy] = temp + go(day+1,x,y+1,1,0);
			}
		}
		int temp = 0;
		temp+=dd;
		temp+=dd;
		if(prevx==0)temp+=D;
		if(prevy==0)temp+=D;
		if(d[day][x][y][prevx][prevy]==0||
				d[day][x][y][prevx][prevy]> temp + go(day+1,x,y,1,1)) 
		{
			d[day][x][y][prevx][prevy] = temp + go(day+1,x,y,1,1);
		}
		return d[day][x][y][prevx][prevy];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			C = sc.nextInt();
			D = sc.nextInt();
			dd = sc.nextInt();
			n=0;
			m=0;
			while(true) {
				int temp = sc.nextInt();
				if(temp==0)break;
				a[n++]=temp;
			}
			while(true) {
				int temp = sc.nextInt();
				if(temp==0)break;
				b[m++]=temp;
			}
			
			d = new int[222][111][111][2][2];
			System.out.println(go(0,0,0,0,0));
		}
	}
}
