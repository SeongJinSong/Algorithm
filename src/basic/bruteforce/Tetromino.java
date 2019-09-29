package basic.bruteforce;

import java.util.Scanner;

/*14500*/
public class Tetromino {
	public static void main(String[] args) {
		int[][] map;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max = 0;
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int type=0;type<19;type++) {
					int sum = sumShape1(map, i, j, type);
					if(max < sum) {
						max = sum;
					}
				}
				
			}
		}
		System.out.println(max);
	}
	public static int sumShape1(int[][] map, int i, int j, int type){
		int m=map.length, n=map[0].length;
		int sum = 0;
		int[] dx = {0, 1, 2, 3};
		int[] dy = {0, 0, 0, 0};
		
		if(type == 0) {
			dx[0] = 0;dx[1] = 1;dx[2] = 2;dx[3] = 3;//{0, 1, 2, 3};
			dy[0] = 0;dy[1] = 0;dy[2] = 0;dy[3] = 0;//{0, 0, 0, 0};
		}
		else if(type == 1) {
			dx[0] = 0;dx[1] = 0;dx[2] = 0;dx[3] = 0;//{0, 0, 0, 0};
			dy[0] = 0;dy[1] = 1;dy[2] = 2;dy[3] = 3;//{0, 1, 2, 3};
		}
		else if(type == 2) {
			dx[0] = 0;dx[1] = 1;dx[2] = 0;dx[3] = 1;//{0, 1, 0, 1};
			dy[0] = 0;dy[1] = 0;dy[2] = 1;dy[3] = 1;//{0, 0, 1, 1};
		}
		else if(type == 3) {
			dx[0] = 0;dx[1] = 0;dx[2] = 0;dx[3] = 1;//{0, 0, 0, 1};
			dy[0] = 0;dy[1] = 1;dy[2] = 2;dy[3] = 2;//{0, 1, 2, 2};
		}
		else if(type == 4) {
			dx[0] = 0;dx[1] = 1;dx[2] = 2;dx[3] = 0;//{0, 1, 2, 0};
			dy[0] = 0;dy[1] = 0;dy[2] = 0;dy[3] = 1;//{0, 0, 0, 1};
		}
		else if(type == 5) {
			dx[0] = 0;dx[1] = 1;dx[2] = 1;dx[3] = 1;//{0, 1, 1, 1};
			dy[0] = 0;dy[1] = 0;dy[2] = 1;dy[3] = 2;//{0, 0, 1, 2};
		}
		else if(type == 6) {
			dx[0] = 0;dx[1] = 1;dx[2] = 2;dx[3] = 2;//{0, 1, 2, 2};
			dy[0] = 1;dy[1] = 1;dy[2] = 1;dy[3] = 0;//{1, 1, 1, 0};
		}
		else if(type == 7) {
			dx[0] = 0;dx[1] = 0;dx[2] = 1;dx[3] = 1;//{0, 0, 1, 1};
			dy[0] = 0;dy[1] = 1;dy[2] = 1;dy[3] = 2;//{0, 1, 1, 2};
		}
		else if(type == 8) {
			dx[0] = 0;dx[1] = 1;dx[2] = 1;dx[3] = 2;//{0, 1, 1, 2};
			dy[0] = 1;dy[1] = 0;dy[2] = 1;dy[3] = 0;//{1, 0, 1, 0};
		}
		else if(type == 9) {
			dx[0] = 0;dx[1] = 1;dx[2] = 1;dx[3] = 2;//{0, 1, 1, 2};
			dy[0] = 0;dy[1] = 0;dy[2] = 1;dy[3] = 0;//{0, 0, 1, 0};
		}
		else if(type == 10) {
			dx[0] = 1;dx[1] = 0;dx[2] = 1;dx[3] = 1;//{1, 0, 1, 1};
			dy[0] = 0;dy[1] = 1;dy[2] = 1;dy[3] = 2;//{0, 1, 1, 2};
		}
		else if(type == 11) {
			dx[0] = 0;dx[1] = 1;dx[2] = 1;dx[3] = 2;//{0, 1, 1, 2};
			dy[0] = 1;dy[1] = 0;dy[2] = 1;dy[3] = 1;//{1, 0, 1, 1};
		}
		else if(type == 12) {
			dx[0] = 0;dx[1] = 0;dx[2] = 0;dx[3] = 1;//{0, 0, 0, 1};
			dy[0] = 0;dy[1] = 1;dy[2] = 2;dy[3] = 1;//{0, 1, 2, 1};
		}
		else if(type == 13) {
			dx[0] = 1;dx[1] = 1;dx[2] = 1;dx[3] = 0;//{1, 1, 1, 0};
			dy[0] = 0;dy[1] = 1;dy[2] = 2;dy[3] = 2;//{0, 1, 2, 2};
		}
		else if(type == 14) {
			dx[0] = 0;dx[1] = 0;dx[2] = 1;dx[3] = 2;//{0, 0, 1, 2};
			dy[0] = 0;dy[1] = 1;dy[2] = 1;dy[3] = 1;//{0, 1, 1, 1};
		}
		else if(type == 15) {
			dx[0] = 0;dx[1] = 1;dx[2] = 0;dx[3] = 0;//{0, 1, 0, 0};
			dy[0] = 0;dy[1] = 0;dy[2] = 1;dy[3] = 2;//{0, 0, 1, 2};
		}
		else if(type == 16) {
			dx[0] = 0;dx[1] = 1;dx[2] = 2;dx[3] = 2;//{0, 1, 2, 2};
			dy[0] = 0;dy[1] = 0;dy[2] = 0;dy[3] = 1;//{0, 0, 0, 1};
		}
		else if(type == 17) {
			dx[0] = 1;dx[1] = 0;dx[2] = 1;dx[3] = 0;//{1, 0, 1, 0};
			dy[0] = 0;dy[1] = 1;dy[2] = 1;dy[3] = 2;//{0, 1, 1, 2};
		}
		else if(type == 18) {
			dx[0] = 0;dx[1] = 1;dx[2] = 1;dx[3] = 2;//{0, 1, 1, 2};
			dy[0] = 0;dy[1] = 0;dy[2] = 1;dy[3] = 1;//{0, 0, 1, 1};
		}
		for(int k=0; k<dx.length;k++) {
			if(j+dx[k]<0||j+dx[k]>=n||i+dy[k]<0||i+dy[k]>=m)
				return -1;
			else sum+=map[i+dy[k]][j+dx[k]];
		}
		return sum;
	}
}
