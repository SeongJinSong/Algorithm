package util.comb;

public class Combination {
	
	public static void main(String[] args) {
		int n=4;
		int[] arr= {1,2,3,4};
		boolean[] visited = new boolean[n];
		
//		for(int i=1;i<=n;i++) {
//			comb(arr, visited, 0, n, i);
//		}
//		comb_bt(arr, visited, 0, n, 2);
		comb_rc(arr, visited, 0, n, 2);
	}
	/* 백 트레킹 이용
	 * start 인덱스를 기준으로 start보다 작으면 뽑을 후보에서 제외하고
	 * start 보다 크면 뽑을 후보가 됩니다.
	 * 그리고 뽑는 개수를 1개부터 n개 까지 반복문을 통해 main 메소드에서 호출합니다.*/
	static void comb_bt(int[] arr, boolean[] visited, int start, int n, int r) {
		if(r==0) {
			print(arr, visited, n);
			return;
		}
		for(int i=start; i<n;i++) {
			visited[i] = true;
			comb_bt(arr, visited, i+1, n, r-1);
			visited[i] = false;
		}
	}
	/* 재귀를 이용하여 구현
	 * depth 변수는 현재 인덱스로 생각하면 된다.
	 * 현재 인덱스를 뽑는다면 visited[depth]=true, 뽑지 않으면 visited[depth]=false;
	 * 뽑은 경우와 뽑지 않은 경우 모두 호출한다.
	 * 종료하는 조건으로 0개를 뽑을 경우 또는 depth가 0이 되면 모든 인덱스를 다 보았으므로 재귀 종료
	 */
	static void comb_rc(int[] arr, boolean[] visited, int depth, int n, int r) {
		if(r==0) {
			print(arr, visited, n);
			return;
		}
		if(depth==n) {
			return;
		}
		visited[depth] = true;
		comb_rc(arr, visited, depth+1, n, r-1);
		visited[depth] = false;
		comb_rc(arr, visited, depth+1, n, r);
	}
	/*조합 경우의 수만 셀 경우*/
	public int combination(int n, int r) {
		if(n==r||r==0)return 1;
		return combination(n-1, r-1) + combination(n-1,r);
	}
	static void print(int[] arr, boolean[] visited, int n) {
		for(int i=0;i<n;i++) {
			if(visited[i]) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}
}
