package dynamic.sol5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

class HopPair implements Comparable<HopPair>{
	long first, second;
	public HopPair() {}
	public HopPair(long first, long second) {
		this.first=first;
		this.second=second;
	}
	@Override
	public int compareTo(HopPair o) {
		if(this.first<o.first) {
			return -1;
		}else if(this.first==o.first) {
			if(this.second < o.second) {
				return -1;
			}else if(this.second == o.second) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return 1;
		}
	}
}
public class Hopscotch {
	static HopPair stack[] = new HopPair[100001];
	static int size, last;
	static double cross(int x, int y) {
		double t1 = (double)(stack[y].second-stack[x].second);
		double t2 = (double)(stack[x].first-stack[y].first);
		return t1/t2;
	}
	static void insert(long x, long y) {
		stack[size] = new HopPair(x, y);
		while (size > 1 && cross(size-2,size-1) > cross(size-1, size)) {
	        stack[size-1] = stack[size];
	        size -= 1;
	    }
	    size += 1;
	}
	static long query(long x) {
	    while (last+1 < size && cross(last, last+1) <= x) {
	        last += 1;
	    }
	    return x*stack[last].first + stack[last].second;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Vector<HopPair> b = new Vector<HopPair>();
		for(int i=0;i<n;i++) {
			b.add(new HopPair(sc.nextLong(), sc.nextLong()));
		}
		Collections.sort(b);
		Collections.reverse(b);
		Vector<HopPair> a = new Vector<HopPair>();
		a.add(b.get(0));
		for (int i=1; i<n; i++) {
			HopPair p = a.lastElement();
	        if (p.second >= b.get(i).second) continue;
	        a.add(b.get(i));
	    }
		Collections.sort(a);
		n = a.size();
		long d[] = new long[n+1];
		for(int i=1;i<=n;i++) {
			insert(a.get(i-1).second, d[i-1]);
			d[i] = query(a.get(i-1).first);
		}
		System.out.println(d[n]);
	}
}
