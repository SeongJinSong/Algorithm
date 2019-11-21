package dynamic.sol3;

import java.util.*;
import java.math.*;

public class StepNumber {
    public static long mod = 1000000000L;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][][] d = new long[n+1][10][1<<10];
        for (int i=1; i<=9; i++) {
            d[1][i][1<<i] = 1L;
        }
        for (int i=1; i<=n-1; i++) {
            for (int j=0; j<=9; j++) {
                for (int k=0; k<(1<<10); k++) {
                    if (d[i][j][k] == 0) {
                        continue;
                    }
                    if ((k&(1<<j)) == 0) {
                        continue;
                    }
                    if (j+1 <= 9) {
                        d[i+1][j+1][k | (1<<(j+1))] += d[i][j][k];
                        d[i+1][j+1][k | (1<<(j+1))] %= mod;
                    }
                    if (j-1 >= 0) {
                        d[i+1][j-1][k | (1<<(j-1))] += d[i][j][k];
                        d[i+1][j-1][k | (1<<(j-1))] %= mod;
                    }
                }
            }
        }
        long ans = 0;
        for (int i=0; i<=9; i++) {
            ans += d[n][i][(1<<10)-1];
            ans %= mod;
        }
        System.out.println(ans);
    }
}