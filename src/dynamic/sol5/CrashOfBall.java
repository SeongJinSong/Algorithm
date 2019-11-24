package dynamic.sol5;

import java.util.Arrays;
import java.util.Scanner;

public class CrashOfBall {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int t = sc.nextInt();
		int ans = 0;
		for(int s=0; s<(1<<n); s++) {
			for(int i=0;i<n;i++) {
				if((s&(1<<i))>0) {
					for(int j=i+1;j<n;j++) {
						if((s&(1<<j))<=0) {
							if(a[i]+t >= a[j]-t) {
								ans+=1;
							}
						}
					}
				}
			}
		}
		System.out.println((double)ans/(double)(1<<n));
	}
}
