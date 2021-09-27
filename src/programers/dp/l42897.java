package programers.dp;

import java.util.Arrays;

public class l42897 {
	public static void main(String[] args) {
//		int[] money = {1000,0,0,1000,0,0,1000,0,0,1000}; //3000
//		int[] money = {1, 2, 3, 1};	//4
//		int[] money = {1,1,4,1,4};	//8
//		int[] money = {1000,1,0,1,2,1000,0}; //2001
//		int[] money = {1000,0,0,0,0,1000,0,0,0,0,0,1000};	//2000
//		int[] money = {90,0,0,95,1,1};	//185
		
//		int[] money = {1,2,3,4,5,6,7,8,9,10};	//30
//		int[] money = {11,0,2,5,100,100,85,1};	//198

//		int[] money = {1,2,3}; //3
		int[] money = {91,90,5,7,5,7}; //104
		
		System.out.println(solution(money));
	}
	/* 원형 상태에서 최대값을 구하는 방법을 고안하지 못해서 원형을 일직선으로 변형시켰다.
	 * 일직선으로 변형시킨 경우 3가지 케이스가 존재한다.
	 * 1) 첫번째를 선택하고, 마지막을 선택하지 않는 경우
	 * 2) 마지막을 선택하고, 첫번째것을 선택하지 않는 경우
	 * 3) 첫번째와 마지막 둘다 선택하지 않는 경우
	 * 
	 * 마지막으로 3개만 존재하는 경우는 예외처리해주었다.
	 */
	
	public static int solution(int[] money) {
		int n = money.length;
		if(n<=3)return getMax(money,0,n);
		int[] money3= money.clone();
		int[] money2= money.clone();
		for(int i=2;i<n-1;i++) {
			int a = i-2<2?0:money[i-2];
			int b = i-3<2?0:money[i-3];
			money[i]+=Math.max(a, b);
		}
		for(int i=1;i<n-2;i++) {
			int a = i-2<1?0:money2[i-2];
			int b = i-3<1?0:money2[i-3];
			money2[i]+=Math.max(a, b);
		}
		for(int i=1;i<n-1;i++) {
			int a = i-2<1?0:money3[i-2];
			int b = i-3<1?0:money3[i-3];
			money3[i]+=Math.max(a, b);
		}
		int answer = Math.max(money[0]+getMax(money,2,n-1), getMax(money3, 1,n-2));
		answer = Math.max(answer, money2[n-1]+getMax(money2, 1, n-2));
        return answer;
    }
	public static int getMax(int[] arr, int start, int end) {
		int max =0;
		for(int i=start;i<end;i++) {
			if(max<arr[i])max=arr[i];
		}
		return max;
	}
}
