package basic.bruteforce;

import java.util.Scanner;

/*1476*/
/*
 * 풀이 방법
 * 	1. 브루트포스 방식으로 1 씩 증가O(n)
 * 	2. %연산으로 구현 할 수 도 있고 O(n)
 * 	3. 중국인 나머지 정리로 구현 가능 O(1)
*/public class CalcDate {
	public static void main(String[] args) {
		int E = 1, S = 1, M = 1;
		int e = 1, s = 1, m = 1;
		int year = 1;
		Scanner sc = new Scanner(System.in);
		E = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();
		while(true) { 
			if(e==E&&s==S&&m==M)break;
			if(e++==15)e=1;
			if(s++==28)s=1;
			if(m++==19)m=1;
			year++;
			if(year>15*28*19) {
				System.out.println("weard");
				break;
			}
		}
		System.out.println(year);
	}
}
