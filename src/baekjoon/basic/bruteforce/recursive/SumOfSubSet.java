package baekjoon.basic.bruteforce.recursive;

import java.util.Scanner;

/*1182*/
public class SumOfSubSet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++) {
			a[i]= sc.nextInt();
		}
		int ans = go(a, r, 0, 0);
		if(r==0) { //�ƹ��͵� �������� ���� ��쵵 ����� ���� ���Ƿ� 1���� ���־�� �Ѵ�.
			ans -=1;
		}
		System.out.println(ans);
	}

	public static int go(int[] a, int r, int sum, int index) {
		if(index>=a.length) {
			return 0;
		}
		if(sum == r) {//���Ⱑ Ʋ���� ������ �� ���� ������ ®��� �Ѵ�. �׷��� �� ���� ����� ���� �ľ� �����ϴ�!
			return 1;
		}
		return go(a, r, sum, index+1) + go(a, r, sum+a[index], index+1);
	}
	public static int go2(int[] a, int r, int sum, int index) {
		if(index >= a.length) { // length-1���� ����� �ϱ� ������ a.length ���� �����ϵ��� �Ѵ�!
			if(sum == r) {
				return 1;
			}else {
				return 0;
			}
		}
		return go(a, r, sum, index+1) + go(a, r, sum+a[index], index+1);
	}
	
}
