package dynamic.sol5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class DonutPair1{
	int x;
	int y;
	public DonutPair1(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public boolean equals(Object o) {
		DonutPair1 c = (DonutPair1)o;
		if(o instanceof DonutPair1) {
			if(this.x == c.x&&this.y==c.y) return true;
		}
		return false;
	}
	public int hashCode() {
		return this.x*31+this.y;
	}
}
public class Donuts_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<DonutPair1, Integer> d = new HashMap<DonutPair1, Integer>();
		int n, m, gx, gy;
		n = sc.nextInt();
		m = sc.nextInt();
		gx = sc.nextInt();
		gy = sc.nextInt();
		int x=0, y=0;
		for(int i=0;;i++) {
			DonutPair1 p = new DonutPair1(x, y);
			if(d.containsKey(p))break;
			d.put(p, i);
			x+=1;
			y+=1;
			x%=n;
			y%=m;
		}
		DonutPair1 tmp = new DonutPair1(gx, gy);
		if(d.containsKey(tmp)) {
			int cnt = d.size();
			int goal = d.get(tmp);
			System.out.println((double)(cnt-goal)*(double)goal);
		}else {
			System.out.println(-1);
		}
	}
}
