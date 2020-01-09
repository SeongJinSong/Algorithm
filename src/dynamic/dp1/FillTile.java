package dynamic.dp1;

import java.util.*;
public class FillTile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d[] = new int[n+1];
		d[0] = 1;
		for(int i=2;i<=n;i++) {
			d[i] = d[i-2]*3;
			for(int j=2;2*j<=i;j++) {
				d[i] += d[i-2*j]*2;
			}
		}
		System.out.println(d[n]);
	}
}
