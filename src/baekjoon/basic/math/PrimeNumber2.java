package baekjoon.basic.math;

import java.util.Scanner;

/*1929*/
public class PrimeNumber2 {
/*
 * �����佺�׳׽��� ü 
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		boolean[] chk = new boolean[n+1];
		chk[0] = chk[1] = true;
		for(int i = 2; i * i <= n;i++) {
			if(chk[i] == true)continue;
			for(int k = i + i; k <= n; k += i) {
				chk[k] = true;
			}
		}
		
		for(int i=m; i<=n;i++) {
			if(chk[i] == false)System.out.println(i);
		}
	}
	public static void oldSolution() {
		Scanner sc = new Scanner(System.in);
		int [] primeNums = new int[1000001];
		int [] chk		 = new int[1000001];
		int m = sc.nextInt();
		int n = sc.nextInt();
		for(int i=2;i<=n;i++) {
			primeNums[i]=i;
			chk[i]=1;
		}
		int k = 2;
		while(k*k <= n) {
			for(int i = k+k; i <= n; i+=k){
				if(chk[i] == 1) {
					chk[i] = 0;
				}else continue;
			}
			k = nextPrime(chk, k);
		}
		for(int i=m; i<=n;i++) {
			if(chk[i] == 1)
				System.out.println(primeNums[i]);
		}
	}
	public static int nextPrime(int []chk, int k) {
		for(int i=k+1; i<chk.length;i++) {
			if(chk[i] == 1) {
				return i;
			}
		}
		return -1;
	}
}
