package baekjoon.basic.math;

import java.util.Scanner;

/*1978*/
public class PrimeNumber {
/*
 * �Ҽ� �˰���
 * 1. � �� N�� �Ҽ����� �ƴ��� �Ǻ��ϴ� ���
 * 2. N���� �۰ų� ���� ��� �ڿ��� �߿��� �Ҽ��� ã�Ƴ��� ���
 * 
 *  �Ҽ� �˰��� 1
 *  	�ð� ���⵵
 *  	1.�ڱ� �ڽű��� �˻� O(N)
 *  	2.N/2 ���� �˻� O(N/2)
 *  	3.��Ʈ N���� �˻� O(��Ʈ N)
 *  
 *  �Ҽ� �˰��� 2
 *  	1.N���� ��ƮN ������� �˻� O(N*��ƮN)
 *  	2.�����佺�׳׽��� ü O(N*loglogN)
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
		else if(a==2) return true;	// 1, 2 ����ó�� ����� ����
		for(int i=2;i*i<=a;i++) { // = �ε�ȣ ������ ����...
			if(a%i==0) return false;
		}
		return true;
	}
}
