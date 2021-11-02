package programers.lv2;

public class l1829 {
	public static void main(String[] args) {
		int m = 6, n=4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		new l1829().print(new l1829().solution(m, n, picture));
	}
	int[][] visit;
	int[] dx = {1,-1,0,0};
	int[] dy = {0,0,-1,1};
	int noa=0;
	public int[] solution(int m, int n, int[][] picture) {
        visit = new int[m][n];
        int max=0;
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		if(visit[i][j]==0&&picture[i][j]!=0) {
        			noa++;
        			int res = spread(i, j, picture, picture[i][j]);
        			if(max<res)max=res;
        		}
        	}
        }
        int[] answer = new int[2];
        answer[0] = noa;
        answer[1] = max;
        return answer;
    }
	public int spread(int curY, int curX, int[][]picture, int curVal) {
		if(visit[curY][curX]!=0) return 0;
		if(curY<0||curY>=picture.length)return 0;
		if(curX<0||curX>=picture[0].length)return 0;
		System.out.println("noa:"+noa+" curVal:"+curVal);
		visit[curY][curX]=noa;
		int sum = 1;
		for(int i=0;i<dx.length;i++) {
			int ny = curY+dy[i];
			int nx = curX+dx[i];
			if(ny<0||ny>=picture.length) {
				continue;
			}
			if(nx<0||nx>=picture[0].length) {
				continue;
			}
			if(picture[ny][nx]==curVal&&visit[ny][nx]==0) {
				System.out.println("ny:"+ny+" nx:"+nx);
				sum+=spread(ny, nx, picture, curVal);
			}
		}
		return sum;
	}
	public void print(int[] arr) {
		System.out.println("numOfArea:"+arr[0]);
		System.out.println("maxSizeOfOneArea:"+arr[1]);
	}
}
