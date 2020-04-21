package test;
import java.util.Scanner;
/* input example
스킬의 길이는 스킬 개수(N)보다 1 작습니다.
ex1)
121
5
1 2
1 3
3 6
3 4
3 5
*/
public class RPGSkillTree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long total = sc.nextLong();
		int n = sc.nextInt();
		int rel[][]=new int[n+2][n+2]; // graph
		int depth[] = new int[n+2]; // depth
		int sort[] = new int[n+2]; // sort as depth
		long res[] = new long[n+2];
		for(int i=1;i<=n+1;i++) {
			sort[i]=i;
			if(i==n+1)break;
			int p = sc.nextInt();
			int q = sc.nextInt();
			rel[p][q] = 1;
			depth[q] = depth[p]+1;
		}
		for(int i=1;i<=n+1;i++) {
			for(int j=i;j<=n+1;j++) {
				if(depth[i]<depth[j]) {
					int tmp = depth[i];
					depth[i]=depth[j];
					depth[j]=tmp;
					int tmpIdx = sort[i];
					sort[i] = sort[j];
					sort[j] = tmpIdx;
				}
			}
		}
		int div = 0;
		for(int i=1;i<=n+1;i++) {
			int sum=0;
			for(int j=1;j<=n+1;j++) {
				sum+=rel[sort[i]][j]==1?res[j]:0;
			}
			res[sort[i]]= sum!=0?res[sort[i]]=sum:1;
			div+=res[sort[i]];
		}
		for(int i=1;i<=n+1;i++) {
			res[i]=res[i]*total/div;
			System.out.println(res[i]);
		}
	}
}
