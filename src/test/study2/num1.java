package test.study2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class num1 {
	public static void main(String[] args) {
//		int[] arr= {5,3,9,13}; int n=8;
		int[] arr= {5,3,9,13}; int n=7;
		System.out.println(new num1().solution(arr, n));
	}
	boolean[] visited;
	
	/** My Solution **/
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
	//Time complexity: O(NlongN)
	//Space complexity: O(1)
	
	/** Approach 1: Brute Force **/
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
	//Time complexity: O(N^2)
	//Space complexity: O(1). The space required does not depend on the size of the input array.
	// so noly constant space is used.
	
	/** Approach 2: Two-pass Hash Table **/
	public int[] solution3(int[] arr, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i], i);
		}
		for(int i=0;i<arr.length;i++) {
			int complement = n - arr[i];
			if(map.containsKey(complement)&&map.get(complement)!=i) {
				return new int[] {i, map.get(complement)};
			}
		}
		return null;
	}
	//Time Complexity:O(2N) -> O(N)
	//Space Complexity:O(N). The extra space required depends on the number of items stored in the hash table,
	// which stores exactly n elements.
	
	/** Approach 2: One-pass Hash Table **/
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }
	//Time Complexity:O(N)
	//Space Complexity:O(N)
}
