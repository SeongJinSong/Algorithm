package baekjoon.basic.bruteforce.permut;

import java.util.Scanner;

/*10971*/
public class TSM {
	/*Travelling Salesman Problem*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int [n];
		int[][]m = new int[n][n];
		int min = -1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				m[i][j] = sc.nextInt();
			}
			a[i] = i;
		}
		
		do {
			if(a[0]!=0)break;//���� Ư���� �������� 0�϶��� Ȯ���غ��� ������ ����!
			int sum = m[a[n-1]][a[0]];
			boolean ok = true;
			for(int i=0;i<n-1;i++) {
				if(sum==0||m[a[i]][a[i+1]] == 0) {
					ok = false;
					break;
				}
				sum+=m[a[i]][a[i+1]];
			}
			if(ok == false)continue;
			if(min > sum || min < 0) {
				min = sum;
			}
		}while(nextPermu(a));
		System.out.println(min);
	}
	public static boolean nextPermu(int[] a){
		int i = a.length-1;
		while(i>0&&a[i-1]>=a[i]) {
			i--;
		}
		
		if(i<=0)return false;
		
		int j = a.length-1;
		while(i<=j&&a[i-1]>=a[j]) {
			j--;
		}
		
		swap(a, i-1, j);
		
		j = a.length-1;
		
		while(i<j) {
			swap(a, i, j);
			i++;
			j--;
		}
		return true;
	}
	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
}
