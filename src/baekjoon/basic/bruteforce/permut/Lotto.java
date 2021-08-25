package baekjoon.basic.bruteforce.permut;

import java.util.Scanner;

/*6603*/
public class Lotto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			int[] k = new int[n];
			int[] a = new int[n];
			 if(n==0)break;
			 for(int i=0;i<n;i++) {
				 k[i] = sc.nextInt();
				 a[i]=i<6?1:0;
			 }
			 do {
				 for(int i=0;i<k.length;i++) {
					 if(a[i]==1)System.out.print(k[i]+" ");
				 }
				 System.out.println();
			 }while(prevPermu(a));
			 System.out.println();
		}
	}
	public static boolean prevPermu(int a[]) {
		int i = a.length-1;
		while(i>0&&a[i-1]<=a[i]) {
			i--;
		}
		if(i<=0)return false;
		int j = a.length-1;
		while(i<=j&&a[i-1]<=a[j]) {
			j--;
		}
		int tmp=a[i-1];
		a[i-1]=a[j];
		a[j]=tmp;
		
		j = a.length-1;
		while(i<j) {
			tmp=a[i];
			a[i]=a[j];
			a[j]=tmp;
			i++;
			j--;
		}
		return true;
	}
}
