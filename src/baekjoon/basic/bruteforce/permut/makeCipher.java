package baekjoon.basic.bruteforce.permut;

import java.util.Arrays;
import java.util.Scanner;
/*1759*/
public class makeCipher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];
		char[] c = new char[m];
		for(int i=0;i<m;i++) {
			c[i] = sc.next().charAt(0);
			a[i]=i<n?1:0;
		}
		Arrays.sort(c);
		String str;
		do {
			str = "";
			for(int i=0;i<m;i++) {
				if(a[i] == 1)
					str += c[i];
			}
			if(!chk(str))continue;
			System.out.println(str);
		}while(prevPermu(a));
	}
	public static boolean chk(String str) {
		int m = 0, j= 0;
		for(char c : str.toCharArray()) {
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
				m++;
			else
				j++;
		}
		return m>=1&&j>=2;
	}
	public static boolean prevPermu(int[] a) {
		int i = a.length-1;
		while(i>0&&a[i-1]<=a[i]) {
			i--;
		}
		if(i<=0)return false;
		int j = a.length-1;
		while(i<=j&&a[i-1]<=a[j]) {
			j--;
		}
		int tmp = a[i-1];
		a[i-1]=a[j];
		a[j]=tmp;
		
		j=a.length-1;
		while(i<j) {
			tmp= a[i];
			a[i]=a[j];
			a[j]=tmp;
			i++;
			j--;
		}
		return true;
	}
}
