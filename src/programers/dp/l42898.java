package programers.dp;

public class l42898 {
	public static void main(String[] args) {
		int m=4; int n=3; int[][] puddles= {{2, 2}};
//		int m=7; int n=4; int[][] puddles= {{2, 1}, {2, 2}, {2, 3}, {4, 2}, {4, 3}, {4, 4}, {6, 2}, {6, 3}};
//		int m=100; int n=100; int[][] puddles= {};
		System.out.println(solution(m, n, puddles));
	}
	public static int solution(int m, int n, int[][] puddles) {
        int[][] d = new int[m+1][n+1];
        for(int[] a: puddles)d[a[0]][a[1]]=-1;
        d[1][1]=1;
        for(int i=1;i<m+1;i++) {
        	for(int j=1;j<n+1;j++) {
        		if((i==1&&j==1)||d[i][j]==-1)continue;
        		d[i][j]=((d[i-1][j]==-1?0:d[i-1][j])+(d[i][j-1]==-1?0:d[i][j-1]))%1000000007;
        	}
        }
        return d[m][n];
    }
}
 