package dynamic.dp1;

import java.util.*;
public class PassWardCode_2 {
	public static long mod = 1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pw = sc.nextLine();
		int n = pw.length();
		int a[] = new int[n+1];
		for(int i=1;i<=pw.length();i++) {
			a[i] = pw.charAt(i-1)-'0';
		}
		long d[] = new long[n+1];
		d[0]=1;
		for (int i=1; i<=n; i++) {
            if (1 <= a[i] && a[i] <= 9) {
                d[i] += d[i-1];
                d[i] %= mod;
            }
            if (i==1) {
                continue;
            }
            if (a[i-1] == 0) {
                continue;
            }
            if (a[i-1]*10 + a[i] >=10 && a[i-1]*10 + a[i] <= 26) {
                d[i] += d[i-2];
                d[i] %= mod;
            }
        }
        System.out.println(d[n]);
	}
}
