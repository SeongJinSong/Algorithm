package dynamic.sol5;

import java.util.*;

class HolPair{
	int first, second;
	public HolPair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
public class Holidays {
	static ArrayList<HolPair> e = new ArrayList();
	static int dfs(int x, int parent, int road, int through) {
		int ans = through>0?1:0;
		for (int i=0; i<e.size(); i++) {
	        if (e.get(i).first == x || e.get(i).second == x) {
	            int y = e.get(i).first == x ? e.get(i).second : e.get(i).first;
	            if (y == parent) continue;
	            int nthrough = through;
	            if (i == road) nthrough = 1;
	            ans += dfs(y, x, road, nthrough);
	        }
	    }
	    return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=0;i<n-1;i++) {
			int x, y;
			x = sc.nextInt();
			y = sc.nextInt();
			e.add(new HolPair(x, y));
		}
		double ans = 0.0;
		int[] house = new int[m];
		for (int i=0; i<m; i++) {
	        house[i] = sc.nextInt();
	    }
		for (int i=0; i<n-1; i++) {
	        double p = 1.0;
	        for (int j=0; j<m; j++) {
	            int cnt = dfs(house[j], -1, i, 0);
	            p *= (double)cnt / (double)(n-1);
	        }
	        ans += p;
	    }
		System.out.println(ans);
	}
}
