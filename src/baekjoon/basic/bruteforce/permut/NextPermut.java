package baekjoon.basic.bruteforce.permut;

import java.util.Arrays;
import java.util.Scanner;

/*10972*/
public class NextPermut {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;i++) {
			nums[i] = sc.nextInt();
		}
		//System.out.println(nextPermu1(nums)==-1?-1:print1(nums));
		if(nextPermu2(nums))print2(nums);
		else System.out.println(-1);
	}
	//���� ����ϰ� ¥ ���ô�!
	public static boolean nextPermu2(int[] nums) {
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
	//ó�� § ��������
	public static int nextPermu1(int [] nums) {
		if(nums.length==1)return -1;
		/*1. nums[i-1] <= nums[i]�� ������Ű�� ���� ū iã��*/
		int i;
		for(i=nums.length-1;i>0;i--) {
			if(nums[i-1] <= nums[i]) {
				break;
			}
			if(i==1)return -1;
		}
		/*2. i<=j �̸� nums[i-1] <= nums[j]�� �����ϴ� ���� ū j ã��*/ 
		int j;
		for(j=nums.length-1;j>=0;j--) {
			if(i<=j && nums[i-1] <= nums[j]) {
				break;
			}
		}
		/*3. nums[i-1]�� nums[j]�� ����*/
		swap(nums, i-1, j);
		/*4. i�� �������� ������������ ����*/
		int[] tmpArr = new int[nums.length-i];
		for(int k = i; k<nums.length; k++) {
			tmpArr[k-i] = nums[k];
		}
		Arrays.sort(tmpArr);
		for(int k = i; k<nums.length; k++) {
			nums[k] = tmpArr[k-i];
		}
		return i;
	}
	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	public static String print1(int [] nums) {
		String res="";
		for(int i=0;i<nums.length;i++) {
			res+=nums[i]+" ";
		}
		return res;
	}
	public static void print2(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
		}
	}
}
