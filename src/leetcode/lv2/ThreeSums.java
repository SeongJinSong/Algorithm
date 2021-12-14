package leetcode.lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ThreeSums {
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		List res = new ThreeSums().threeSum2(nums);
		System.out.println();
	}
    public boolean[] visited;
    class Node{
        int n1;
        int n2;
        int n3;
        public Node(int n1, int n2, int n3){
            this.n1=n1;
            this.n2=n2;
            this.n3=n3;
        }
        @Override
        public int hashCode() {
        	return Objects.hash(n1+""+n2+""+n3);
        }
        @Override
        public boolean equals(Object obj) {
        	if(obj instanceof Node && obj!=null) {
        		return this.n1==((Node)obj).n1&&this.n2==((Node)obj).n2&&this.n3==((Node)obj).n3;
        	}
        	return true;
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Node> res = new HashSet<>();
        int n = nums.length;
        visited = new boolean[n];
        comb(res, nums, n, 3, 0, 0);
        
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Iterator<Node> it = res.iterator();
        while(it.hasNext()) {
        	Node nd = it.next();
        	List<Integer> list = new LinkedList<Integer>();
        	list.add(nd.n1);list.add(nd.n2);list.add(nd.n3);
        	ans.add(list);
        }
        return ans;
    }
    public void comb(HashSet<Node> res, int[] nums, int n, int r, int depth, int start){
        if(r==depth){
            int sum=0;
            List<Integer> list = new LinkedList<>();
            for(int i=0;i<n;i++){
                if(visited[i]){
                    sum+=nums[i];
                    list.add(nums[i]);
                }
            }
            if(sum==0){
                Collections.sort(list);
                res.add(new Node(list.get(0), list.get(1), list.get(2)));
            }
        }
        for(int i=start;i<n;i++){
            if(visited[i])continue;
            visited[i]=true;
            comb(res, nums, n, r, depth+1, i);
            visited[i]=false;
        }
    }
    /* 솔루션
     * 1. 배열을 오름차순으로 정렬
     * 배열의 양 끝에 있는 숫자의 합과 C를 비교한다.
     * 합이 C보다 작다면 left 증가
     * 합이 C보다 크다면 right 감소 
     * */
    public List<List<Integer>> threeSum2(int[] nums){
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length-2;i++) {
    		if(i>0&&nums[i]==nums[i-1])continue;
    		int left = i+1;
    		int right = nums.length-1;
    		while(left<right) {
    			int sum = nums[left]+nums[right]+nums[i];
    			if(sum==0) {
    				res.add(Arrays.asList(nums[i], nums[left], nums[right]));
    				left++;
    				right--;
    				while(nums[left]==nums[left-1]&&left<right)left++;
    				while(nums[right]==nums[right+1]&&left<right)right--;
    			}else if(sum>0) {
    				right--;
    			}else {
    				left++;
    			}
    		}
    	}
    	return res;
    }
}