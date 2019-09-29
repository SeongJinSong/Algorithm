package basic.bruteforce.recursive;

import java.util.Scanner;

/*1182*/
public class SumOfSubSet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++) {
			a[i]= sc.nextInt();
		}
		int ans = go(a, r, 0, 0);
		if(r==0) { //아무것도 선택하지 않은 경우도 경우의 수로 들어가므로 1개를 빼주어야 한다.
			ans -=1;
		}
		System.out.println(ans);
	}

	public static int go(int[] a, int r, int sum, int index) {
		if(index>=a.length) {
			return 0;
		}
		if(sum == r) {//여기가 틀린것 끝까지 다 가는 것으로 짰어야 한다. 그래야 더 많은 경우의 수를 파악 가능하다!
			return 1;
		}
		return go(a, r, sum, index+1) + go(a, r, sum+a[index], index+1);
	}
	public static int go2(int[] a, int r, int sum, int index) {
		if(index >= a.length) { // length-1까지 해줘야 하기 때문에 a.length 부터 리턴하도록 한다!
			if(sum == r) {
				return 1;
			}else {
				return 0;
			}
		}
		return go(a, r, sum, index+1) + go(a, r, sum+a[index], index+1);
	}
	
}
