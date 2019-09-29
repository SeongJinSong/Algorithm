package basic.bruteforce.recursive;

import java.util.Scanner;
/*9095*/
public class MakeNBySumOf1_2_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nums[] = new int[n];
		for(int i=0;i<n;i++) {
			nums[i] = sc.nextInt();
		}
		for(int i=0; i<n ;i++) {
			System.out.println(go(0,nums[i]));
		}
	}
	public static int go(int sum, int goal) {
		if(sum > goal) return 0;
		if(sum == goal) return 1;
		int now = 0;
		for(int i=1;i<=3;i++) {
			now += go(sum+i, goal);
		}
		return now;
	}
}
