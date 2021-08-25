package baekjoon.basic.graph.bfs_dfs;

import java.util.*;
class Emo{
	int s, n, t;
	public Emo(int s, int n, int t) {
		this.s = s;//location
		this.n = n;//cnt of clipboard
		this.t = t;//time
	}
}
public class Emoticon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int c[] = new int[1001];
		int chk[][] = new int[1001][1001];
		
		Queue<Emo> q = new LinkedList<Emo>();
		q.add(new Emo(1, 0, 1));
		c[1]=1;
		
		while(!q.isEmpty()&&c[s]==0) {
			Emo p = q.remove();
			for(int i=0;i<3;i++) {
				if(i==0) {//paste
					if(p.s+p.n>1000||p.n==0)continue;
					if(chk[p.s+p.n][p.n] != 0)continue;
					if(c[p.s+p.n]==0||c[p.s+p.n]>p.t+1)
						c[p.s+p.n] = p.t+1;
					chk[p.s+p.n][p.n] = 1;
					q.add(new Emo(p.s+p.n, p.n, p.t+1));
				}
				else if(i==1) {//copy
					if(chk[p.s][p.s] != 0)continue;
					chk[p.s][p.s] = 1;
					q.add(new Emo(p.s, p.s, p.t+1));
				}
				else if(i==2) {//-1
					if(chk[p.s-1][p.n] != 0)continue;
					if(p.s-1<2)continue;
					if(c[p.s-1]==0||c[p.s-1]>p.t+1)
						c[p.s-1] = p.t+1;
					chk[p.s-1][p.n] = 1;
					q.add(new Emo(p.s-1, p.n, p.t+1));
				}
				
			}
		}
		System.out.println(c[s]-1);
		sc.close();
	}
	static void compare() {
		boolean chk = false;
		for(int i=2;i<=1000;i++) {
			int x = call1(i);
			int y = call2(i);
			if(x!=y) {
				System.out.println(i + ": ("+x+", "+y+")");
				chk = true;
			}
		}
		if(!chk)System.out.println("All Match");
	}
	static int call1(int s) {
		int c[] = new int[1001];
		int chk[][] = new int[1001][1001];
		
		Queue<Emo> q = new LinkedList<Emo>();
		q.add(new Emo(1, 0, 1));
		c[1]=1;
		
		while(!q.isEmpty()&&c[s]==0) {
			Emo p = q.remove();
			for(int i=0;i<3;i++) {
				if(i==0) {//paste
					if(p.s+p.n>1000||p.n==0)continue;
					if(chk[p.s+p.n][p.n] != 0)continue;
					if(c[p.s+p.n]==0||c[p.s+p.n]>p.t+1)
						c[p.s+p.n] = p.t+1;
					chk[p.s+p.n][p.n] = 1;
					q.add(new Emo(p.s+p.n, p.n, p.t+1));
				}
				else if(i==1) {//copy
					if(chk[p.s][p.s] != 0)continue;
					chk[p.s][p.s] = 1;
					q.add(new Emo(p.s, p.s, p.t+1));
				}
				else if(i==2) {//-1
					if(chk[p.s-1][p.n] != 0)continue;
					if(p.s-1<2)continue;
					if(c[p.s-1]==0||c[p.s-1]>p.t+1)
						c[p.s-1] = p.t+1;
					chk[p.s-1][p.n] = 1;
					q.add(new Emo(p.s-1, p.n, p.t+1));
				}
			}
		}
		return (c[s]-1);
	}
	static int call2(int n) {
        int[][] d = new int[n+1][n+1];
        for (int i=0; i<=n; i++) {
            Arrays.fill(d[i], -1);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(0);
        d[1][0] = 0;
        while (!q.isEmpty()) {
            int s = q.remove();
            int c = q.remove();
            if (d[s][s] == -1) {
                d[s][s] = d[s][c] + 1;
                q.add(s); q.add(s);
            }
            if (s+c <= n && d[s+c][c] == -1) {
                d[s+c][c] = d[s][c] + 1;
                q.add(s+c); q.add(c);
            }
            if (s-1 >= 0 && d[s-1][c] == -1) {
                d[s-1][c] = d[s][c] + 1;
                q.add(s-1); q.add(c);
            }
        }
        int ans = -1;
        for (int i=0; i<=n; i++) {
            if (d[n][i] != -1) {
                if (ans == -1 || ans > d[n][i]) {
                    ans = d[n][i];
                }
            }
        }
        return (ans);
	}
}
