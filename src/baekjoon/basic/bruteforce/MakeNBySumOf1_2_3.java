package baekjoon.basic.bruteforce;

import java.util.Scanner;

/*9095*/
public class MakeNBySumOf1_2_3 {
	/*
	 * 풀이방법
	 * 	1. 브루트 포스 : 10중 for문
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++){
			nums[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++){
			System.out.println(bruteForce(nums[i]));
		}
	}
	
	public static int bruteForce(int num) {
		int cnt=0;
		for(int i1=1;i1<=3;i1++) {
			if(num == i1) cnt++;
			for(int i2=1;i2<=3;i2++) {
				if(num == i1+i2) cnt++;
				for(int i3=1;i3<=3;i3++) {
					if(num == i1+i2+i3) cnt++;
					for(int i4=1;i4<=3;i4++) {
						if(num == i1+i2+i3+i4) cnt++;
						for(int i5=1;i5<=3;i5++) {
							if(num == i1+i2+i3+i4+i5) cnt++;
							for(int i6=1;i6<=3;i6++) {
								if(num == i1+i2+i3+i4+i5+i6) cnt++;
								for(int i7=1;i7<=3;i7++) {
									if(num == i1+i2+i3+i4+i5+i6+i7) cnt++;
									for(int i8=1;i8<=3;i8++) {
										if(num == i1+i2+i3+i4+i5+i6+i7+i8) cnt++;
										for(int i9=1;i9<=3;i9++) {
											if(num == i1+i2+i3+i4+i5+i6+i7+i8+i9) cnt++;
											for(int i10=1;i10<=3;i10++) {
												if(num == i1+i2+i3+i4+i5+i6+i7+i8+i9+i10) cnt++;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return cnt;
	}
}
