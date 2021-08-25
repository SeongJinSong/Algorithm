package baekjoon.basic.bruteforce.permut;

import java.util.Scanner;

/*14888*/
public class PutOperator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] nums = new long[n];
		for(int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
		}
		int sum = 0;
		int op[] = new int[4];
		for(int i=0;i<4;i++) {
			sum+=op[i] = sc.nextInt();
		}
		int ops[] = new int[sum];
		for(int i=0;i<sum;i++) {
			if(i<op[0]) {
				ops[i]=0;
			}else if(i<op[0]+op[1]) {
				ops[i]=1;
			}else if(i<op[0]+op[1]+op[2]) {
				ops[i]=2;
			}else if(i<op[0]+op[1]+op[2]+op[3]) {
				ops[i]=3;
			}
		}
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		do {
			long res = getResult(nums, ops);
			if(res==Long.MIN_VALUE)continue;
			if(res>max)max = res;
			if(res<min)min = res;
		}while(nextPermu(ops));
		System.out.println(max);
		System.out.println(min);
		
	}
	public static long getResult(long [] nums, int[] ops) {
		long[] a;
		a = nums.clone();
		for(int i=0;i<ops.length;i++) {
			switch(ops[i]) {
			case 0:
				a[i+1] = a[i]+a[i+1];
				break;
			case 1:
				a[i+1] = a[i]-a[i+1];
				break;
			case 2:
				a[i+1] = a[i]*a[i+1];
				break;
			case 3:
				a[i+1] = a[i]/a[i+1];
				break;
			}
		}
		return a[a.length-1];
	}
	public static boolean nextPermu(int[] a) {
		int i = a.length-1;
		while(i>0&&a[i-1]>=a[i]) {
			i--;
		}
		if(i<=0)return false;
		
		int j = a.length-1;
		while(i<=j&&a[i-1]>=a[j]) {
			j--;
		}
		int tmp = a[i-1];
		a[i-1]=a[j];
		a[j]=tmp;
		
		j = a.length-1;
		while(i<j) {
			tmp=a[i];
			a[i]=a[j];
			a[j]=tmp;
			i++;
			j--;
		}
		return true;
	}
}
