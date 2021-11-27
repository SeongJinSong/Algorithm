package programers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class l68644 {
	public static void main(String[] args) {
		int[] numbers= {2,1,3,4,1};
//		int[] numbers= {5,0,2,7};
		new l68644().print(new l68644().solution2(numbers));
	}
	/* 처음 한풀이는 combination을 생각했다.
	 * 그러다보니 nC2 성능이라 성능이 너무 안나왔다.
	 * 브루드포스로 푸는 경우 2n 의 성능이다.
	 * 시간은 시간대로 날리고 통과는 못하는 결과를 낳았다.
	 * 좀 더 단순하게 효율적으로 짜는걸 항상 생각하자!!
	 * */
	boolean[] visited;
    HashSet<Integer> hs;
    public int[] solution(int[] numbers) {
    	int n = numbers.length;
    	hs=new HashSet<Integer>();
        visited = new boolean[n];
        comb(numbers, 0, n, 2);
        Iterator<Integer> it = hs.iterator();
        int[] answer = new int[hs.size()];
        int idx=0;
        while(it.hasNext()) {
        	answer[idx++]=it.next();
        }
        Arrays.sort(answer);
        return answer;
    }
    public void comb(int[] numbers, int depth, int n, int r){
        if(depth==r){
        	System.out.println("n:"+n+" r:"+r);
            int sum=0;
            for(int i=0;i<n;i++){
                if(visited[i])sum+=numbers[i];
            }
            hs.add(sum);
        }
        for(int i=depth;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                comb(numbers, depth+1, n, r);
                visited[i]=false;
            }
        }
    }
    public void print(int[] arr) {
    	for(int i:arr)System.out.print(i+" ");
    	System.out.println();
    }
    /*ArrayList도 set같이 사용할 수 있다.*/
    public int[] solution2(int[] numbers) {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	for(int i=0;i<numbers.length;i++) {
    		for(int j=i+1;j<numbers.length;j++) {
    			int a = numbers[i]+numbers[j];
    			if(arr.indexOf(a)<0)arr.add(a);
    		}
    	}
    	Collections.sort(arr);
    	return arr.stream().mapToInt(x->x).toArray();
    }
    /*TreeSet을 활용하여 set을 정렬할 수 있다.*/
    public int[] solution3(int[] numbers) {
    	TreeSet<Integer> ts = new TreeSet<Integer>((a,b)->a-b);
    	for(int i=0;i<numbers.length;i++) {
    		for(int j=i+1;j<numbers.length;j++) {
    			ts.add(numbers[i]+numbers[j]);
    		}
    	}
    	return ts.stream().mapToInt(Integer::intValue).toArray();
    }
}	
