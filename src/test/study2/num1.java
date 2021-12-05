package test.study2;

import java.util.Arrays;

public class num1 {
	public static void main(String[] args) {
//		int[] arr= {5,3,9,13}; int n=8;
		int[] arr= {5,3,9,13}; int n=7;
		System.out.println(new num1().solution(arr, n));
	}
	boolean[] visited;
	
	public boolean solution2(int[] arr, int n) {
		boolean answer=false;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>=n)break;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j]>n)break;
				if(arr[i]+arr[j]==n)return true;
			}
		}
		return answer;
	}
	public boolean solution(int[] arr, int n) {
		boolean answer=false;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>=n)return false;;
			int nx=n-arr[i];
			int start=i+1;
			int end=arr.length;
			while(start<end) {
				int mid=(start+end)/2;
				if(nx>arr[mid]) {
					start=mid+1;
				}else if(nx<arr[mid]) {
					end=mid;
				}else return true;
			}
		}
		return answer;
	}
}
