package test.study3;

import java.util.ArrayList;

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
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=0;i<nums.length-2;i++) {
			int max = nums[i];
			for(int j=i;j<i+k;j++) {
				max=Math.max(max, nums[j]);
			}
			ans.add(max);
		}
		print(ans);
	}
	public static void print(ArrayList<Integer> list) {
		for(int i:list)System.out.print(i+" ");
		System.out.println();
	}
}
