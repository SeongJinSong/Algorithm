package leetcode.lv2;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualK {
    public static void main(String[] args) {
        SubArraySumEqualK s = new SubArraySumEqualK();
        int[] nums1 = {1, 1, 1}; int k1 =2; int result1 = 2;
        int[] nums2 = {1, 2, 3}; int k2 =3; int result2 = 2;
        int[] nums4 = {1, -1, 0}; int k4 = 0; int result4 = 3;
        int[] nums5 = {-1, -1, 1}; int k5 = 0; int result5 = 1;
        int res1 = s.subarraySum(nums1, k1);
        int res2 = s.subarraySum(nums2, k2);
        int res4 = s.subarraySum(nums4, k4);
        int res5 = s.subarraySum(nums5, k5);
        System.out.println(res1+" "+(res1==result1));
        System.out.println(res2+" "+(res2==result2));
        System.out.println(res4+" "+(res4==result4));
        System.out.println(res5+" "+(res5==result5));
    }
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sum = new HashMap<>();
        int ans = 0;
        sum.put(0, 1); // 처음부터 모두 더해서 k인 곳을 위해서 넣어준다.

        int total = 0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];

            // S(0, i)-k가 HashMap에 있는지 확인한다.
            if (sum.containsKey(total - k)) {
                ans += sum.get(total - k);
            }

            // S(0, i)를 HashMap에 넣어준다.
            sum.put(total, sum.getOrDefault(total, 0) + 1);
        }
        return ans;
    }
    public boolean[][] map;
    public int subarraySum2(int[] nums, int k) {
        map = new boolean[nums.length][nums.length];
        return dfs(0, 0, nums, k);
    }
    public int dfs(int start, int depth, int[] nums, int k){
        if(depth>=nums.length)return 0;
        if(map[start][depth]){
            return 0;
        }
        else{
            map[start][depth] = true;
        }
        int sum = start == depth ? nums[start] : sum(start, depth, nums);
        int result = sum==k?1:0;
        return dfs(start,depth+1, nums, k) + dfs(start+1, depth+1, nums, k)+result;
    }

    public int dfs(int start, int depth){
        System.out.println("## "+start+","+depth);
        if(depth>3)return 0;
        return dfs(start, depth + 1) + dfs(start + 1, depth + 1)+1;

    }

    public int sum(int start, int end, int[] nums){
        int sum =0;
        for(int i=start; i<=end;i++){
            sum+=nums[i];
        }
        return sum;
    }
}
