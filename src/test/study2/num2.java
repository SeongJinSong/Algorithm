package test.study2;

public class num2 {
	public static void main(String[] args) {
		int[] A = {1,10,2,9,3,8,4,7,5,6}; int S=20;
		System.out.println(new num2().solution(A, S));
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
}
