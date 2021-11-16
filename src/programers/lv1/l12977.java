package programers.lv1;

public class l12977 {
	public static void main(String[] args) {
		int[] nums = {1,2,7,6,4};
		System.out.println(new l12977().solution(nums));
	}
	public int solution(int[] nums) {
        return dfs(nums, 0, 0, 0);
    }
    public int dfs(int[] nums, int idx, int sum, int select){
        int total=0;
        if(select==3&&isPrime(sum)) return 1;
        if(select>=3) return 0;
        if(idx>=nums.length)return 0;
        total+=dfs(nums, idx+1, sum+nums[idx], select+1);
        total+=dfs(nums, idx+1, sum, select);
        return total;
    }
    public boolean isPrime(int num){
        if(num==1)return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0)return false;
        }
        return true;
    }
    /*3개 까지이므로 3중 for문을 쓰면 더 쉬울수도 있다.*/
    public int solution2(int[] nums) {
    	int ans =0;
    	for(int i=0;i<nums.length-2;i++) {
    		for(int j=i+1;j<nums.length-1;j++) {
    			for(int k=j+1;k<nums.length;k++) {
    				if(isPrime(nums[i]+nums[j]+nums[k]))ans++;
    			}
    		}
    	}
    	return ans;
    }
}
