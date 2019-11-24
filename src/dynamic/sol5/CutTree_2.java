package dynamic.sol5;

import java.util.Scanner;
import java.util.Stack;

class CutPair{
	long first, second;
	public CutPair() {}
	public CutPair(long first, long second) {
		this.first=first;
		this.second=second;
	}
}
public class CutTree_2 {
	static int p;
	static CutPair stack[] = new CutPair[100001];
	static int size, last;
	static double cross(int x, int y) {
		double t1 = (double)(stack[y].second-stack[x].second);
		double t2 = (double)(stack[x].first-stack[y].first);
		return t1/t2;
	}
	static void insert(long x, long y) {
		stack[size] = new CutPair(x, y);
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
		CutPair a[]= new CutPair[n];
		for(int i=0;i<n;i++) {
			a[i] = new CutPair();
		}
		for (int i=0; i<n; i++) {
	        a[i].first = sc.nextLong();
	    }
	    for (int i=0; i<n; i++) {
	        a[i].second = sc.nextLong();
	    }
	    long d[] = new long[n];
	    insert(a[0].second, 0);
	    for (int i=1; i<n; i++) {
	        d[i] = query(a[i].first);
	        insert(a[i].second,d[i]);
	    }
	    System.out.println(d[n-1]);
	}
}
