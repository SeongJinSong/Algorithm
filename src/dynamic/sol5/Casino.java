package dynamic.sol5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Couple{
	long x;
	int k;
	public Couple(long x, int k) {
		this.x=x;
		this.k=k;
	}
	public boolean equals(Object o) {
		Couple c = (Couple)o;
		if(o instanceof Couple) {
			if(this.x == c.x&&this.k==c.k) return true;
		}
		return false;
	}
	public int hashCode() {
		return (int)this.x*31+this.k;
	}
}
public class Casino {
	static Map<Couple, Double> d = new HashMap<Couple, Double>();
	static double go(long n, int m, int k) {
		if(n<=0) return 0.0;
		if(k==0) {
			if(n>=1) {
				return 1.0;
			}else {
				return 0.0;
			}
		}
		Couple t = new Couple(n, k);
		if(d.containsKey(t)) {
			return d.get(t);
		}
		double p = (double)(n%m)/(double)m;
		double ans = p*go(n-(n/m+1), m, k-1);
		ans += (1.0-p)*go(n-(n/m), m, k-1);
		d.put(t, ans);
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int m = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(go(n,m,k));
	}
}
