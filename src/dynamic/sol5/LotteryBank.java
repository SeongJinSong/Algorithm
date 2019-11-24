package dynamic.sol5;

import java.util.Scanner;

public class LotteryBank {
	static int a[] = new int[50];
	static int jackpot, week, total;
	static boolean c[][] = new boolean[1001][1001];
	static double d[][] = new double[1001][1001];
	static double go(int w, int win) {
		if (w == week) {
	        return a[0] + win * jackpot;
	    } else {
	        if (c[w][win]) return d[w][win];
	        c[w][win] = true;
	        double p = (double)(a[0] + win*jackpot) / (total+w*jackpot);
	        return d[w][win] = p * go(w+1, win+1) + (1-p) * go(w+1, win);
	    }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
			total+=a[i];
		}
		jackpot = sc.nextInt();
		week = sc.nextInt();
		System.out.println(go(0,0));
	}
}
