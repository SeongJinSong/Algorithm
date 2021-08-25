package baekjoon.basic.bruteforce;

import java.util.Scanner;

/*1476*/
/*
 * Ǯ�� ���
 * 	1. ���Ʈ���� ������� 1 �� ����O(n)
 * 	2. %�������� ���� �� �� �� �ְ� O(n)
 * 	3. �߱��� ������ ������ ���� ���� O(1)
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
