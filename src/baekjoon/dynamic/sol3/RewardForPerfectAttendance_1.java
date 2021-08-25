package baekjoon.dynamic.sol3;

import java.util.Scanner;

public class RewardForPerfectAttendance_1 {
	static int mod = 1000000;
	static int d[][][][][] = new int[1001][3][3][3][2];
	// �⼮: 0, �Ἦ: 1, ����: 2
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int now=0; now<3; now++) {
	        for (int prev=0; prev<3; prev++) {
	            for (int prev2=0; prev2<3; prev2++) {
	                if (now == prev && prev == prev2 && prev2 == 1) {
	                    // �Ἦ ���� 3��
	                    continue;
	                }
	                if ((now == 2 && prev == 2) ||
	                        (now == 2 && prev2 == 2) ||
	                        (prev == 2 && prev2 == 2)) {
	                    // ���� 1��
	                    continue;
	                }
	                if (now == 2 || prev == 2 || prev2 == 2) {
	                    d[3][now][prev][prev2][1] = 1;
	                } else {
	                    d[3][now][prev][prev2][0] = 1;
	                }
	            }
	        }
	    }
	    for (int i=4; i<=n; i++) {
	        for (int prev=0; prev<3; prev++) {
	            for (int prev2=0; prev2<3; prev2++) {
	                for (int prev3=0; prev3<3; prev3++) {
	                    // �⼮
	                    d[i][0][prev][prev2][0] += d[i-1][prev][prev2][prev3][0];
	                    d[i][0][prev][prev2][0] %= mod;
	                    d[i][0][prev][prev2][1] += d[i-1][prev][prev2][prev3][1];
	                    d[i][0][prev][prev2][1] %= mod;
	                    // �Ἦ
	                    if (prev == 1 && prev2 == 1) {
	                        // �Ἦ 3���� �Ұ���
	                    } else {
	                        d[i][1][prev][prev2][0] += d[i-1][prev][prev2][prev3][0];
	                        d[i][1][prev][prev2][0] %= mod;
	                        d[i][1][prev][prev2][1] += d[i-1][prev][prev2][prev3][1];
	                        d[i][1][prev][prev2][1] %= mod;
	                    }
	                    // ����
	                    d[i][2][prev][prev2][1] += d[i][prev][prev2][prev3][0];
	                    d[i][2][prev][prev2][1] %= mod;
	                }
	            }
	        }
	    }
	    if (n == 0) {
	    	System.out.println(0);
	    } else if (n == 1) {
	    	System.out.println(3);
	    } else if (n == 2) {
	    	System.out.println(8);
	    } else {
	        int ans = 0;
	        for (int i=0; i<3; i++) {
	            for (int j=0; j<3; j++) {
	                for (int k=0; k<3; k++) {
	                    for (int l=0; l<2; l++) {
	                        ans += d[n][i][j][k][l];
	                        ans %= mod;
	                    }
	                }
	            }
	        }
	        System.out.println(ans);
	    }
	}
}
