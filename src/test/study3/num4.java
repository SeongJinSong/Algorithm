package test.study3;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class num4 {
	//nums = {1, 3, -1, -3, 5, 3, 6, 7}
	//k=3
	//선택된 범위의 값에 가장 큰 값을 리턴한다.
	//시간복잡도, 공간복잡도 말하라
	// Math.max 시간복잡도 말하라
	
	//[1  3  -1] -3  5  3  6  7   // 3
	// 1 [3  -1  -3] 5  3  6  7   // 3
	// 1  3 [-1  -3  5] 3  6  7   // 5
	// 1  3  -1 [-3  5  3] 6  7   // 5
	// 1  3  -1  -3 [5  3  6] 7   // 6
	// 1  3  -1  -3  5 [3  6  7]  // 7
	
    // output: [3, 3, 5, 5, 6, 7]
	public static void main(String[] args) {
		int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		int k=3;
		print(solution2(nums, k));
	}
	public static ArrayList<Integer> solution(int[] nums, int k){
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=0;i<nums.length-2;i++) {
			int max = nums[i];
			for(int j=i;j<i+k;j++) {
				max=Math.max(max, nums[j]);
			}
			ans.add(max);
		}
		return ans;
	}
	public static ArrayList<Integer> solution2(int[] nums, int k){
		ArrayList<Integer> ans = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
		int prev = Integer.MIN_VALUE;
		for(int i=0;i<nums.length-(k-1);i++) {
			if(i!=0) {
				pq.remove(prev);
				pq.add(nums[i+k-1]);
				ans.add(pq.peek());
			}else {
				for(int j=i;j<i+k;j++) {
					pq.add(nums[j]);
				}
				ans.add(pq.peek());
			}
			prev=nums[i];
		}
		return ans;
	}
	public static void print(ArrayList<Integer> list) {
		for(int i:list)System.out.print(i+" ");
		System.out.println();
	}
}
