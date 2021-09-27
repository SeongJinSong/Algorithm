package programers.dfs_bfs;

public class l43162 {
	public static void main(String[] args) {
//		int n=3; int[][] computers= {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int n=3; int[][] computers= {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(solution(n, computers));
	}
	static boolean[] check;
	public static int solution(int n, int[][] computers) {
		check = new boolean[computers.length];
		int answer = 0;
		for(int i=0;i<computers.length;i++) {
			if(check[i])continue;
			answer+=dfs(i, computers);
		}
        return answer;
    }
	public static int dfs(int idx, int[][] computers) {
		for(int i=0;i<computers.length;i++) {
			if(idx==i||check[i]||computers[idx][i]==0)continue;
			else check[i]=true;
			dfs(i, computers);
		}
		return 1;
	}
}
