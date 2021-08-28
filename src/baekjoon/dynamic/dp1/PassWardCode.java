package baekjoon.dynamic.dp1;

import java.util.*;
public class PassWardCode {
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
		d[0] = 1; d[1] = 1;
		for(int i=1;i<=n;i++) {
			if(a[1]==0){//첫째 자리가 0인경우
				d[n]=0;
				break;
			}
			if(i>=2) {
				if(a[i-1]==0&&a[i]==0) { //00오는 경우
					d[n]=0;
					break;
				}
				else if(a[i] == 0) {
					if(a[i-1]*10+a[i]>=30){ //30이상인 경우
						d[n]=0;
						break;
					}
					d[i] = d[i-2];
				}
				else if(a[i-1]==0) { //앞자리가 0인경우
					d[i] = d[i-2];
				}
				else if(a[i-1]*10+a[i]<=26&&!(i+1<=n&&a[i+1]==0)) { //뒷자리가 0인경우
					d[i] = d[i-2] + d[i-1];
					d[i]%=mod;
				}
				else {
					d[i] = d[i-1];
				}
			}
		}
		System.out.println(d[n]%=mod);
	}
}
