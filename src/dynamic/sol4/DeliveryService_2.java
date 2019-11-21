package dynamic.sol4;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryService_2 {
	static int a[] = new int[3001];
	static int d[] = new int[3001];
	static int s[] = new int[3001];
	static int n, t, h;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		t = sc.nextInt();
		h = sc.nextInt();
		Arrays.parallelSort(a, 1, n+1);
		for (int i=1; i<=n; i++) {
	        s[i] = s[i-1] + a[i];
	    }
		for (int i=1; i<=n; i++) {
			d[i] = d[i-1] + a[i]*t;
	        for (int j=i; j>=1; j--) {
	            int c = h;
	            int x = (i+j)/2;
	            c += ((s[i]-s[x-1]) - a[x]*(i-x+1))*t;
	            c += (a[x]*(x-j+1) - (s[x]-s[j-1]))*t;
	            if (d[i] > d[j-1] + c) {
	                d[i] = d[j-1] + c;
	            }
	        }
	    }
		System.out.println(d[n]);
	}
}
