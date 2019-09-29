package basic.math;

import java.util.Scanner;

/*6588*/
public class Goldbach {
/*
 * 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 1000000;
		
		boolean[] chk = new boolean[n+1];
		chk[0] = chk[1] = true;
		for(int i = 2; i * i <= n;i++) {
			if(chk[i] == true)continue;
			for(int k = i + i; k <= n; k += i) {
				chk[k] = true;
			}
		}
		int flg = sc.nextInt();
		while(flg != 0) {
			for(int i=3; i<=flg/2;i++) {
				if(chk[i] == false && chk[flg-i] == false) {
					System.out.println(flg +" = " + i + " + " + (flg-i));
					break;
				}
			}
			flg = sc.nextInt();
		}
	}
}
