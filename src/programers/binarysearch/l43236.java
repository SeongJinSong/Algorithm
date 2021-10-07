package programers.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 첫번째 풀이고안
 *   1)diff 배열 생성
 *   2) 가장 작은거 부터 없애기
 *    > i번째가 가장 diff가 작아 i+1을 지웠는데 i~i+2가 가장 작은 경우 확인해서 이동한다.
 *    
 *    : 이 알고리즘은 문제가 해결안된다 왜냐하면 diff가 더 커도 지우는게 이득인 케이스가 있기 때문이다ㅜ
 * 		ex)int distance=25; int[] rocks= {2, 14, 11, 21, 17}; int n=2; //4
 * 
 * 두번째 풀이 고안
 *   1). Combination 후 diff확인
 *    > 조합만 최악의 경우 50000 C 25000 경우의 수가 나온다.
 */
public class l43236 {
	public static void main(String[] args) {
		int distance=25; int[] rocks= {2, 14, 11, 21, 17}; int n=2; //4
//		int distance=23; int[] rocks= {3, 6, 9, 10, 14, 17}; int n=2; //3
//		int distance=42; int[] rocks= {10, 20, 30, 40, 41}; int n=1; //1
		
		int a = 1 ;
		System.out.println(a<<3);
		//System.out.println(new l43236().solution(distance, rocks, n));
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
		for(int i=0;i<totalRocks.length-1;i++) {
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
		if(n.curIdx==0) {
			int pointCurIdx = findPointCurIdx(n.nextIdx, arr);
			n.nextIdx = arr.get(pointCurIdx).nextIdx;
			n.diff += arr.get(pointCurIdx).diff;
			removeIdx(pointCurIdx, arr);
		}
		else {
			int pointCurIdx = findPointNextIdx(n.curIdx, arr);
			arr.get(pointCurIdx).nextIdx=n.nextIdx;
			arr.get(pointCurIdx).diff+=n.diff;
			removeIdx(0, arr);
		}
	}
	public int findPointNextIdx(int idx, ArrayList<Node> arr) {
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i).nextIdx==idx)return i;
		}
		return -1;
	}
	public int findPointCurIdx(int idx, ArrayList<Node> arr) {
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i).curIdx==idx)return i;
		}
		return -1;
	}
	public void removeIdx(int Idx, ArrayList<Node> arr) {
		arr.remove(Idx);
		int i=0;
		while(arr.size()>1&&arr.get(i+1).diff<arr.get(0).diff) {
			if(++i==arr.size()-1)break;
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
