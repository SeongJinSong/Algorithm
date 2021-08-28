package test;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/* input example
스킬의 길이는 스킬 개수(N)보다 1 작습니다.
ex1)
121
5
1 2
1 3
3 6
3 4
3 5
*/
public class RPGSkillTree_BFS {
	public static int n;
	public static long rel[][];
	public static long res[];
	public static Queue<Integer> q = new LinkedList<Integer>();
	public static long div=0;
	public static long bfs(int node) {
		if(q.poll()==null)return 0;
		long sum = 0;
		for(int i=1;i<=n+1;i++) {
			if(rel[node][i]==1) {
				q.add(i);
				sum+=bfs(i);
			}
		}
		div+=res[node]=sum==0?1:sum;
		return res[node];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long total = sc.nextLong();
		n = sc.nextInt();
		rel=new long[n+2][n+2]; // graph
		int depth[] = new int[n+2]; // depth
		res = new long[n+2];
		int start=1;
		for(int i=1;i<=n+1;i++) {
			if(i==n+1)break;
			int p = sc.nextInt();
			int q = sc.nextInt();
			rel[p][q] = 1;
			depth[q] = depth[p]+1;
		}
		for(int i=1;i<=n+1;i++) {
			if(depth[i]==0) {
				start = i;
			}
		}
		q.add(start);
		bfs(start);
		for(int i=1;i<=n+1;i++) {
			System.out.println(res[i]*total/div);
		}
	}
}
