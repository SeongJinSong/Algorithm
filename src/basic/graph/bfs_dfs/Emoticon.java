package basic.graph.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Emo{
	int s, n, fn, t;
	public Emo(int s, int n, int t) {
		this.s = s;//location
		this.n = n;//clipboard
		this.t = t;//time
	}
}
public class Emoticon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int c[] = new int[1001];
		boolean cp[] = new boolean[1001];
		Queue<Emo> q = new LinkedList<Emo>();
		q.add(new Emo(1, 0, 1));
		c[1]=1;
		
		while(!q.isEmpty()) {
			Emo p = q.remove();
			for(int i=0;i<4;i++) {
				int ns;
				if(i==0) {
					if(p.s+p.n>1000||p.n==0||c[p.s+p.n] !=0)continue;
					c[p.s+p.n] = p.t+1;
					q.add(new Emo(p.s+p.n, p.n, p.t+1));
				}
				else if(i==1) {
					if(p.s-1<2||c[p.s-1] != 0)continue;
					c[p.s-1] = p.t+1;
					q.add(new Emo(p.s-1, p.n, p.t+1));
				}
				else if(i==2) {
					if(p.s+p.n-1>1000||p.n==0||c[p.s+p.n-1] !=0)continue;
					c[p.s+p.n-1] = p.t+2;
					q.add(new Emo(p.s+p.n, p.n, p.t+1));
				}
				else if(i==3) {
					if(p.s!=p.n)continue;
					if(p.s+p.s>1000||p.s==0||c[p.s+p.s] !=0)continue;
					c[p.s+p.s] = p.t+2;
					q.add(new Emo(p.s+p.s, p.s, p.t+1));
				}
			}
		}
		System.out.println(c[s]-1);
	}
}
