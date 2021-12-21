package test.study2;

import java.util.ArrayDeque;
import java.util.Deque;

public class num2 {
	public static void main(String[] args) {
//		int[] A = {1,10,2,9,3,8,4,7,5,6}; int S=20;
		int[] A = {84, -37, 32, 40, 95}; int S=167;
		System.out.println(new num2().solution4(A, S));
	}
	public int solution(int []A, int S) {
        int total=0;
        int sums[] = new int[A.length];
        for(int i=0;i<A.length;i++) {
        	sums[i]+=total+A[i];
        	total=sums[i];
        }
        if(total<S)return 0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++) {
        	for(int j=i+1;j<A.length;j++) {
        		if(sums[j]-sums[i]>=S) {
        			int len=j-i;
        			if(min>len)min=len;
        			break;
        		}
        	}
        }
        return min;
    }
	public int solution2(int []A, int S) {
        int total=0;
        for(int i:A)total+=i;
        if(total<S)return 0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++) {
        	int sum=A[i];
        	if(sum>=S)return 1;
        	for(int j=i+1;j<A.length;j++) {
        		sum+=A[j];
        		if(sum>=S) {
        			int len = j-i+1;
        			if(min>len)min=len;
        			break;
        		}
        	}
        }
        return min;
    }
	public int solution3(int []A, int S) {
        int answer = 0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++) {
        	int sum=A[i];
        	if(sum>=S)return 1;
        	for(int j=i+1;j<A.length;j++) {
        		sum+=A[j];
        		if(sum>=S) {
        			int len = j-i+1;
        			if(min>len)min=len;
        			answer++;
        			break;
        		}
        	}
        }
        return answer==0?0:min;
    }
	//DeQueue를 이용한 monoqueue solution
	public int solution4(int []nums, int k) {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		int n = nums.length, ans = n+1;
		long[] lnums = new long[n+1];
		//단순히 사이즈를 1을 증가시킴으로써 0일때 분기처리를 할 필요없이 로직이 깔끔해질 수 있다.
        for(int i=0;i<n;i++){
            lnums[i+1]=lnums[i]+(long)nums[i];
        }
		for(int i=1;i<=n;i++) {
			//누적합을 만든다.
			if(lnums[i]>=k) {
				System.out.println("# i:"+i);
				ans = Math.min(ans, i);
			}
			//최소길이를 구하므로 첫번째를 뺐을때 S보다 큰지 확인한다.
			while(!dq.isEmpty()&&lnums[i]-lnums[dq.getFirst()]>=k) { 
				System.out.println("## i:"+i+" dq.getFirst():"+dq.getFirst()+" nums[i]:"+lnums[i]+" A[dq.getFirst()]:"+lnums[dq.getFirst()]);
				ans=Math.min(ans, i-dq.getFirst()); // 크다면, 이전최소길이와, i-getFirst의 최소길이를 비교한다.
				dq.removeFirst(); // first를 삭제한다.
			}
			//dq에 포함된 인덱스(누적합)이 현재 인덱스(누적합)보다 크다는 의미는 현재 인덱스가 -라는걸 의미하므로
			//바로 위 while문에서 제거할 수 있다.
			while(!dq.isEmpty()&&lnums[i]<=lnums[dq.getLast()]) {
				System.out.println("### i:"+i+" dq.getLast():"+dq.getLast()+" nums[i]:"+lnums[i]+" A[dq.getLast()]:"+lnums[dq.getLast()]);
				dq.removeLast();
			}
			dq.addLast(i);
		}
		return ans==n+1?-1:ans;
	}
	//Time Complexity: O(N), where N is the length of A.
	//Space Complexity: O(N).
}
