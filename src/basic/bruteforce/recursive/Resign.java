package basic.bruteforce.recursive;

import java.util.Scanner;

public class Resign {
	static int n;
	static int[] t;
	static int[] p;
	static int res = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = new int[n+1];
		p = new int[n+1];
		for(int i = 1 ;i < n+1 ; i++){
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		System.out.println(res);
		sc.close();
	}
	public static void go(int day, int sum) {
	}
}