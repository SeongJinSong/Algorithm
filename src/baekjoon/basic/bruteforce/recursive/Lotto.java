package baekjoon.basic.bruteforce.recursive;

import java.util.Scanner;
/*6603*/
public class Lotto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int[] nums;
		int[] res;
		do {
			n = sc.nextInt();
			nums = new int[n];
			res = new int[n];
			for(int i=0;i<n;i++) {
				nums[i] = sc.nextInt();
			}
			go(nums, 0, 0, 1, res.clone());
			go(nums, 0, 0, 0, res.clone());
			System.out.println();
		}while(n!=0);
	}
	public static void go(int[] nums, int i, int count, int flg, int res[]) {
		if(count>6) return;
		if(count>=6&&flg==1) return;
		if(count==6) {
			for(int k=0;k<count;k++) {
				System.out.print(res[k]+" ");
			}
			System.out.println();
			return;
		}
		if(i>nums.length-1) return;		
		if(flg == 1) {
			res[count] = nums[i];
			go(nums, i+1, count+1, 1, res.clone());
			go(nums, i+1, count+1, 0, res.clone());
		}
		else {
			go(nums, i+1, count, 1, res.clone());
			go(nums, i+1, count, 0, res.clone());
		}
	}
}
