package test;
import java.util.Scanner;
/* input example
ex1)
6
3 6 3
2 4 2
10 12 8
11 15 5
1 8 10
12 13 1

ex2)
5
1 2 1
1 2 2
2 3 1
3 4 1
1 4 2
*/
public class PartTimeJob {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][]=new int[n+1][3];
		int max=0;
		for(int i=1;i<=n;i++) {
			a[i][0]=sc.nextInt();
			a[i][1]=sc.nextInt();
			if(a[i][1]>max)max=a[i][1];
			a[i][2]=sc.nextInt();
		}
		int d[] = new int[max+1];
		for(int i=1;i<=max;i++) {
			for(int j=1;j<=i-1;j++) {
				for(int k=1;k<=n;k++) {
					if(a[k][0]>=j&&a[k][1]<=i) {
						d[i]=d[i]>d[j]+a[k][2]?d[i]:d[j]+a[k][2];
					}
				}
			}
		}
		System.out.println(d[max]);
	}
}
