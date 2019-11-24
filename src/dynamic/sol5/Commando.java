package dynamic.sol5;

import java.util.Scanner;

class ComPair{
	long first, second;
	public ComPair() {}
	public ComPair(long first, long second) {
		this.first=first;
		this.second=second;
	}
}
public class Commando {
	static ComPair stack[] = new ComPair[1000001];
	static int size, last;
	static double cross(int x, int y) {
		double t1 = (double)(stack[y].second-stack[x].second);
		double t2 = (double)(stack[x].first-stack[y].first);
		return t1/t2;
	}
	static void insert(long x, long y) {
		stack[size] = new ComPair(x, y);
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
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();
		long a[] = new long[n+1];
		long s[] = new long[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextLong();
			s[i] = s[i-1]+a[i];
		}
		insert(0,0);
		long d[] = new long[n+1];
		for (int i=1; i<=n; i++) {
	        d[i] = query(s[i]) + A*s[i]*s[i] + B*s[i] + C;
	        insert(-2*A*s[i], A*s[i]*s[i] - B*s[i] + d[i]);
	    }
	    System.out.println(d[n]);
	}
}
