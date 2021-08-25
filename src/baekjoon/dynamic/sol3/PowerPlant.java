package baekjoon.dynamic.sol3;

import java.util.*;

public class PowerPlant {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.nextLine();
        String str = sc.nextLine();
        int start = 0;
        for (int i=n-1; i>=0; i--) {
            start *= 2;
            if (str.charAt(i) == 'Y') {
                start += 1;
            }
        }
        int p = sc.nextInt();
        int[] d = new int[1<<n];
        Arrays.fill(d,-1);
        d[start] =0;
        for (int i=0; i<(1<<n); i++) {
            if (d[i] == -1) continue;
            for (int j=0; j<n; j++) {
                if ((i&(1<<j)) != 0) { // j�� ���� ����
                    for (int k=0; k<n; k++) {
                        if ((i&(1<<k))==0) { // k�� ��������
                            if (d[i|(1<<k)] == -1 || d[i|(1<<k)] > d[i] + a[j][k]) {
                                d[i|(1<<k)] = d[i]+a[j][k];
                            }
                        }
                    }
                }
            }
        }
        int ans = -1;
        for (int i=0; i<(1<<n); i++) {
            if (d[i] == -1) {
                continue;
            }
            int cnt = 0;
            for (int j=0; j<n; j++) {
                if ((i&(1<<j)) != 0) {
                    cnt += 1;
                }
            }
            if (cnt >= p) {
                if (ans == -1 || ans > d[i]) {
                    ans = d[i];
                }
            }
        }
        System.out.println(ans);
    }
}