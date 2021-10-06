package programers.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 첫번째 풀이고안
 *   1)diff 배열 생성
 *   2) 가장 작은거 부터 없애기
 *    > i번째가 가장 diff가 작아 i+1을 지웠는데 i~i+2가 가장 작은 경우 확인해서 이동한다.
 * 
 * 두번째 풀이 고안
 *   1). Combination 후 diff확인
 *    > 조합만 최악의 경우 50000 C 25000 경우의 수가 나온다.
 */
public class l43236 {
	public static void main(String[] args) {
		int distance=25; int[] rocks= {2, 14, 11, 21, 17}; int n=2;
		System.out.println(new l43236().solution(distance, rocks, n));
	}
	class Node{
		int curIdx;
		int nextIdx;
		int diff;
		public Node(int curIdx, int nextIdx, int diff) {
			this.curIdx=curIdx;
			this.nextIdx=nextIdx;
			this.diff=diff;
		}
	}
	public int solution(int distance, int[] rocks, int n) {
		int[] totalRocks = new int[rocks.length+2];
		totalRocks[0]=0; totalRocks[totalRocks.length-1]=distance;
		for(int i=0;i<rocks.length;i++) {
			totalRocks[i+1]=rocks[i];
		}
		Arrays.sort(totalRocks);
		ArrayList<Node> totalDiff = new ArrayList<Node>();
		for(int i=0;i<totalRocks.length-2;i++) {
			totalDiff.add(new Node(i, i+1, totalRocks[i+1]-totalRocks[i]));
		}
		Collections.sort(totalDiff, (a, b)->a.diff-b.diff);
		for(int i=0;i<n;i++) {
			remove(totalDiff);
		}
		
        return totalDiff.get(0).diff;
    }
	public void remove(ArrayList<Node> arr) {
		Node n = arr.get(0);
		int nextIdx = findIdx(n.nextIdx, arr);
		n.nextIdx=arr.get(nextIdx).nextIdx;
		n.diff+=arr.get(nextIdx).diff;
		removeIdx(nextIdx, arr);
	}
	public int findIdx(int idx, ArrayList<Node> arr) {
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i).curIdx==idx)return i;
		}
		return -1;
	}
	public void removeIdx(int idx, ArrayList<Node> arr) {
		arr.remove(idx);
		int i=0;
		while(arr.get(++i).diff<arr.get(0).diff) {
			if(i==arr.size()-1)break;
		}
		move(arr, 0, i);
	}
	public void move(ArrayList<Node> arr, int i, int j) {
		if(i==j)return;
		Node tmp = new Node(arr.get(i).curIdx, arr.get(i).nextIdx, arr.get(i).diff);
		arr.add(j+1, tmp);
		arr.remove(0);
	}
}
