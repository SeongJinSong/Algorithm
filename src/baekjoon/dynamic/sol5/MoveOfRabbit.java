package baekjoon.dynamic.sol5;

import java.util.ArrayList;
import java.util.Scanner;

class Pair{
	int x, y;
	public Pair(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
public class MoveOfRabbit {
	static int popcount(int x) {
		int ans = 0;
		while(x>0){
			ans += x&1;
			x>>=1;
		}
		return ans;
	}
	static int check(String s, int state) {
		ArrayList<Pair> rabbit = new ArrayList<Pair>();
		int n = s.length();
		for(int i=0;i<n;i++) {
			if((state & (1<<i)) >0) {
				rabbit.add(new Pair(i, -1));
			}
		}
		while(n>2) {
			ArrayList<Pair> next = new ArrayList<Pair>();
			for(int i=0;i<rabbit.size();i++) {
				int now = rabbit.get(i).x;
				int prev = rabbit.get(i).y;
				if(now==0) {
					next.add(new Pair(now+1, now));
				}else if(now == n-1 || now == n-2) {
					next.add(new Pair(now-1, now));
				}else {
					if(s.charAt(now) == 'W') {
						next.add(new Pair(now-1, now));
					}else if(s.charAt(now) == 'B') {
						next.add(new Pair(now+1, now));
					}
					else {
						if(prev == -1) {
							next.add(new Pair(now-1, now));
						}else {
							next.add(new Pair(prev, now));
						}
					}
				}
			}
			int[] cnt = new int[n];
			for(int i=0;i<next.size();i++) {
				cnt[next.get(i).x]+=1;
			}
			rabbit.clear();
			for(int i=0;i<next.size();i++) {
				if(cnt[next.get(i).x] == 1) {
					rabbit.add(next.get(i));
				}
			}
			n-=1;
		}
		return rabbit.size();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int r = sc.nextInt();
		int bj=0;
		int bm=0;
		int n = s.length();
		for(int i=0;i<(1<<n);i++) {
			if(popcount(i)==r) {
				bm+=1;
				bj+=check(s,i);
			}
		}
		System.out.println((double)bj/bm);
	}
}
