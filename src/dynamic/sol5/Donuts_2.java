package dynamic.sol5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class DonutPair2{
	int x;
	int y;
	public DonutPair2(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public boolean equals(Object o) {
		DonutPair2 c = (DonutPair2)o;
		if(o instanceof DonutPair2) {
			if(this.x == c.x&&this.y==c.y) return true;
		}
		return false;
	}
	public int hashCode() {
		return this.x*31+this.y;
	}
}
public class Donuts_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<DonutPair2, Integer> d = new HashMap<DonutPair2, Integer>();
		int n, m, gx, gy;
		n = sc.nextInt();
		m = sc.nextInt();
		gx = sc.nextInt();
		gy = sc.nextInt();
		int x=0, y=0;
		for(int i=0;;i++) {
			DonutPair2 p = new DonutPair2(x, y);
			if(d.containsKey(p))break;
			d.put(p, i);
			x+=1;
			y+=1;
			x%=n;
			y%=m;
		}
		DonutPair2 pg = new DonutPair2(gx, gy);
		if(!d.containsKey(pg)) {
			System.out.println(-1);
			return;
		}
		int cnt = d.size();
		double a[] = new double[cnt+1];
		double b[] = new double[cnt+1];
		a[0] = 0.0; b[0] = 0.0;
		a[1] = 1.0; b[1] = 0.0;
		for (int i=2; i<=cnt; i++) {
	        a[i] = 2*a[i-1] - a[i-2];
	        b[i] = 2*b[i-1] - b[i-2] - 2;
	    }
	    double e1 = -b[cnt] / a[cnt];
	    int g = d.get(pg);
	    double ans = a[g]*e1+b[g];
	    System.out.println(ans);
	}
}