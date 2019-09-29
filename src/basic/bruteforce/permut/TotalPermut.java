package basic.bruteforce.permut;

import java.util.Scanner;

/*10974*/
public class TotalPermut {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = i+1;
		}
		do{
			print(a);
		}while(nextPermut(a));
	}
	public static boolean nextPermut(int a[]) {
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
	public static void swap(int a[], int i, int j) {
		int tmp = a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
	public static void print(int a[]) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
