package baekjoon.dynamic.dp1;

import java.util.*;
public class WaveClassSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			long p[] = new long[n+1];
			p[0] = 0; p[1] = 1; 
			if(n>=2)p[2] = 1;
			for(int i=3; i<=n;i++) {
				p[i] = p[i-2] + p[i-3];
			}
			System.out.println(p[n]);
		}
	}
}
