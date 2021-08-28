package baekjoon.basic.math;

import java.util.Scanner;

/*2609*/
public class GCD_LCM {
	/*
		★ Greatest Common Divison : 최대 공약수
			1. 1-N까지 %연산 O(N)
			2. 유클리드 호제법
			 	a를 b로 나눈 나머지를 r이라고 할 때
				GCD(a, b) = GCD(b, r)
				r이 0일때 b가 최대공약수
			※재귀함수 구현, while 구현 가능
			3. GCD(a, b, c) = GCD(GCD(a,b),c)를 만족한다.
		★ Least Common Multiple : 최소 공배수
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		//System.out.println(o_nGCD(18, 24));
		//System.out.println(euclideanRecursive(a, b));
		System.out.println(euclideanWhile(a,b));
	}
	public static int o_nGCD(int a, int b){
		int gcd = 1;
		for(int i=2;i< Math.min(a, b); i++) {
			if(a%i==0&&b%i==0)
				gcd = i;
		}
		return gcd;
	}
	public static int euclideanRecursive(int a, int b) {
		if(b==0)return a;
		else return euclideanRecursive(b, a%b);
	}
	public static int euclideanWhile(int a, int b) {
		while(b>0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	public static int lcm(int a, int b) {
		int gcd = euclideanRecursive(a, b);
		return a*b/gcd;
	}
}
