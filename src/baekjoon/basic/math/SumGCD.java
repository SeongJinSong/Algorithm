package baekjoon.basic.math;

import java.util.Scanner;
/*9613*/
public class SumGCD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-->0) {
			int cnt = sc.nextInt();
			int [] nums = new int[cnt];
			for(int i=0; i<cnt; i++) {
				nums[i] = sc.nextInt();
			}
			long sum = 0; //�ڡڡ��ڷ����� ���� int�� �Ѿ���� �� �����ؾ� �Ѵ�.�ڡڡ�
			for(int i=0; i<cnt; i++){
				for(int j=i;j<cnt;j++) {
					if(i==j)continue;
					sum +=gcd(nums[i], nums[j]);
				}
			}
			System.out.println(sum);
		}
	}
	public static int gcd(int a, int b) {
		if(b==0)return a;
		else return gcd(b, a%b);
	}
}
