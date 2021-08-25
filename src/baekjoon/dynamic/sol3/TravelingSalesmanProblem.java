package baekjoon.dynamic.sol3;

import java.util.*;
import java.math.*;

public class TravelingSalesmanProblem {
    public static int MAX = 1000000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int[][]d = new int[1<<n][n];
        for (int i=0; i<(1<<n); i++) {
            for (int j=0; j<n; j++) {
                d[i][j] = MAX;
            }
        }
        d[1][0] = 0;
        for (int i=0; i<(1<<n); i++) {
            for (int j=1; j<n; j++) {
                if ((i&(1<<j)) != 0) {
                    for (int k=0; k<n; k++) {
                        if (k != j && (i&(1<<k)) != 0 && a[k][j] != 0) {
                            d[i][j] = Math.min(d[i][j], d[i-(1<<j)][k] + a[k][j]);
                        }
                    }
                }
            }
        }
        int ans = MAX;
        for (int i=1; i<n; i++) {
            if (a[i][0] != 0) {
                ans = Math.min(ans, d[(1<<n)-1][i] + a[i][0]);
            }
        }
        System.out.println(ans);
    }
}