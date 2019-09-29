package basic.math;

import java.util.Scanner;
/*1934*/
public class LCM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a*b/gcd(a,b));
		}
	}
	public static int gcd(int a, int b) {
		if(b==0)return a;
		else return gcd(b, a%b);
	}
}
