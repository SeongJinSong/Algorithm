package baekjoon.basic.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

/*2309*/
public class SevenDwarfs {
	public static void main(String[] args) {
		int n = 9;	
		int sum = 0;
		int[] dwarfs = new int[n];
		boolean[] chk = new boolean[n];
		
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<n; i++){
			sum += dwarfs[i] = sc.nextInt();
		}
		Arrays.sort(dwarfs);
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(sum-dwarfs[i]-dwarfs[j]==100) {
					chk[i]=chk[j]=true;
					for(int k=0;k<n;k++) {
						if(chk[k]==false)
							System.out.println(dwarfs[k]);
					}
					//이떄 끝내지 않으면 답이 2개 이상일때 오류가 난다.
					return;
				}
			}
		}
	}
}
