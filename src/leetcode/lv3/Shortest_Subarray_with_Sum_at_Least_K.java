package leetcode.lv3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Shortest_Subarray_with_Sum_at_Least_K {
    public static void main(String[] args) {
        Shortest_Subarray_with_Sum_at_Least_K sp = new Shortest_Subarray_with_Sum_at_Least_K();
        int result = sp.shortestSubarray(new int[]{1}, 1);
        System.out.println("result = " + result);

        int result1 = sp.shortestSubarray(new int[]{1, 2}, 4);
        System.out.println("result1 = " + result1);

        int result2 = sp.shortestSubarray(new int[]{2, -1, 2}, 3);
        System.out.println("result2 = " + result2);

        int result3 = sp.shortestSubarray(new int[]{1,10,2,9,3,8,4,7,5,6}, 20);
        System.out.println("result3 = " + result3);

        int result4 = sp.shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167);
        System.out.println("result4 = " + result3);
    }
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length, ans = n+1;
        long[] lnums = new long[n+1];
        //단순히 사이즈를 1 증가시킴으로써 0일때 분기처리를 할 필요없이 로직이 깔끔해질 수 있다.
        for(int i=0;i<n;i++){
            lnums[i+1]=lnums[i]+(long)nums[i];
        }
        for(int i=1;i<=n;i++){
            //누적합을 만든다.
            if(lnums[i]>=k){
                //System.out.println("i = " + i);
                ans = Math.min(ans, i);
            }

            //가장 큰 i에서 dp에 있는 인덱스와 차이가 S보다 큰 가장 큰 인덱스를 찾아야 가장 작은 부분집합이 가능하다.
            //따라서 누적합이 lnums[i]보다 크거나 같은 i보다 작은 수들은 의미가 없으므로 전부 제거한다.
            while (!dq.isEmpty() && lnums[i] <= lnums[dq.getLast()]) {
                dq.removeLast();
            }

            //최소 길이를 구하므로 첫번째를 뺏을 때 S보다 큰지 확인한다.
            while (!dq.isEmpty() && lnums[i] - lnums[dq.getFirst()] >= k) {
                ans = Math.min(ans, i - dq.getFirst()); // 크다면, 이전 최소 길이와, i-getFirst의 최소 길이를 비교한다.
                dq.removeFirst(); //first를 삭제한다.
            }

            dq.addLast(i);
        }
        return ans==n+1?-1:ans;
    }
}
