package baekjoon.basic.bruteforce.recursive;

import java.util.ArrayList;
import java.util.Scanner;

public class Lotto2 {
	static ArrayList<Integer> lotto = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0)break;
			int[] a = new int[n];
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			solve(a, 0, 0);
			System.out.println();
		}
	}
	public static void solve(int[] a, int index, int cnt) {
		if(cnt == 6) {
			for(int num : lotto) {
				System.out.println(num +" ");
			}
			System.out.println();
			return;
		}
		int n = a.length;
		if(n==index)return;
		lotto.add(a[index]);
		solve(a, index+1, cnt+1);
		lotto.remove(lotto.size()-1);
		solve(a, index+1, cnt);
	}
}
