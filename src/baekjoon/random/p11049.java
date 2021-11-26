package baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p11049 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][2];
		int[][] dp = new int[n][n];
		
		for(int i=0;i<n;i++) {
			map[i][0]=sc.nextInt();
			map[i][1]=sc.nextInt();
		}
		System.out.println();
	}
}
