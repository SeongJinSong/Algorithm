package baekjoon.basic.bruteforce.permut;

import java.util.Scanner;

/*10819*/
public class MaxDiff {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] nums = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = i;
			nums[i] = sc.nextInt();
		}
		int max = 0;
		do {
			int sum = 0;
			for(int i=0;i<n-1;i++) {
				sum+=Math.abs(nums[a[i]]-nums[a[i+1]]);
			}
			if(max < sum) max = sum;
		}while(nextPermut(a));
		System.out.println(max);
	}
	public static boolean nextPermut(int[] nums) {
		int i = nums.length-1;
		while(i>0&&nums[i-1] >= nums[i]) {
			i--;
		}
		if(i<=0) return false;
		
		int j = nums.length-1;
		while(i<=j&&nums[i-1] >= nums[j]) {
			j--;
		}
		swap(nums, i-1, j);
		j=nums.length-1;
		while(i<j) {
			swap(nums, i, j);
			i++;
			j--;
		}
		return true;
	}
	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
