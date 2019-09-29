package basic.math;

import java.util.Scanner;

/*1978*/
public class PrimeNumber {
/*
 * 소수 알고리즘
 * 1. 어떤 수 N이 소수인지 아닌지 판별하는 방법
 * 2. N보다 작거나 같은 모든 자연수 중에서 소수를 찾아내는 방법
 * 
 *  소수 알고리즘 1
 *  	시간 복잡도
 *  	1.자기 자신까지 검사 O(N)
 *  	2.N/2 까지 검사 O(N/2)
 *  	3.루트 N까지 검사 O(루트 N)
 *  
 *  소수 알고리즘 2
 *  	1.N개를 루트N 방법으로 검사 O(N*루트N)
 *  	2.에라토스테네스의 체 O(N*loglogN)
 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		while(n-->0) {
			int a = sc.nextInt();
			if(isPrime(a))sum++;
		}
		System.out.println(sum);
	}
	public static boolean isPrime(int a) {
		if(a==1) return false;
		else if(a==2) return true;	// 1, 2 예외처리 까먹지 말자
		for(int i=2;i*i<=a;i++) { // = 부등호 빼먹지 말자...
			if(a%i==0) return false;
		}
		return true;
	}
}
