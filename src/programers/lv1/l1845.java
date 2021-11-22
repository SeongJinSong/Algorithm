package programers.lv1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class l1845 {
	public static void main(String[] args) {
//		int[] nums = {3,1,2,3};
//		int[] nums = {3,3,3,2,2,4};
		int[] nums = {3,3,3,2,2,2};
		System.out.println(new l1845().solution(nums));
	}
	public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i:nums){
            hs.add(i);
        }
        return nums.length/2>hs.size()?hs.size():nums.length/2;
    }
	public int solution2(int[] nums) {
		return Arrays.stream(nums)
				.boxed()
				.collect(Collectors.collectingAndThen(
							Collectors.toSet(), 
							phonekemons->Integer.min(phonekemons.size(), nums.length/2)
							)
						);
	}
	
}
