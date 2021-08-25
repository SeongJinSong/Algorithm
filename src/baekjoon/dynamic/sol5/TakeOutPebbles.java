package baekjoon.dynamic.sol5;

import java.util.Scanner;

public class TakeOutPebbles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int total = 0;
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
			total+=a[i];
		}
		int k = sc.nextInt();
		double ans = 0;
		for(int i=0;i<n;i++) {
			if(a[i]>=k) {
				double temp = 1.0;
				for(int j=0;j<k;j++) {
					temp *= a[i]-j;
					temp /= total-j;
				}
				ans += temp;
			}
		}
		System.out.println(ans);
	}
}
