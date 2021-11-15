package programers.lv2;

public class l77485 {
	public static void main(String[] args) {
//		int rows=6, columns=6; int[][] queries= {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
//		int rows=3, columns=3; int[][] queries= {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		int rows=100, columns=97; int[][] queries= {{1,1,100,97}};
		new l77485().print(new l77485().solution(rows, columns, queries));
	}
	public int[] solution(int rows, int columns, int[][] queries) {
		int[][] arr = new int[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				arr[i][j]=(i) * columns + j+1;
			}
		}
		int[] answer = new int[queries.length];
        for(int i=0;i<queries.length;i++) {
        	answer[i]=rotationAndFindMin(arr, queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
        }
        return answer;
    }
	public int rotationAndFindMin(int[][] arr, int sy, int sx, int ey, int ex) {
		int start = arr[sy][sx];
		int min = start; 
		for(int i=sy; i<ey;i++) {
			arr[i][sx] = arr[i+1][sx];
			if(min>arr[i][sx])min=arr[i][sx];
		}
		for(int i=sx;i<ex;i++) {
			arr[ey][i]=arr[ey][i+1];
			if(min>arr[ey][i])min=arr[ey][i];
		}
		for(int i=ey;i>sy;i--) {
			arr[i][ex]=arr[i-1][ex];
			if(min>arr[i][ex])min=arr[i][ex];
		}
		for(int i=ex;i>sx+1;i--) {
			arr[sy][i]=arr[sy][i-1];
			if(min>arr[sy][i])min=arr[sy][i];
		}
		arr[sy][sx+1]=start;
		return min;
	}
	public void print(int[] arr) {
		for(int i: arr)System.out.print(i+" ");
		System.out.println();
	}
	/* 원리는 똑같지만 dx, dy 배열을 사용하면 조금 더 깔끔하게 짤 수 있다.*/
	public int rotate(int[][] map, int x1, int y1, int x2, int y2) {
		int x = x1;
		int y = y1;
		int[] dx= {0, -1, 0, 1};
		int[] dy= {1, 0, -1, 0};
		int dir=3;
		int temp=map[x][y];
		int min=temp;
		while(true) {
			if(x==x2&&y==y1)dir=0;
			if(x==x2&&y==y2)dir=1;
			if(x==x1&&y==y2)dir=2;
			map[x][y]=map[x+dx[dir]][y+dy[dir]];
			x+=dx[dir];
			y+=dy[dir];
			min=Math.min(map[x][y], min);
			if(x==x1&&y==y1) {
				map[x1][y1+1]=temp;
				break;
			}
		}
		return min;
	}
}
