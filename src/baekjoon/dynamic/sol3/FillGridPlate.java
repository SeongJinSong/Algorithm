package baekjoon.dynamic.sol3;

import java.util.*;

public class FillGridPlate {
    public static int go(int n, int m, int[][] d, int num, int state) {
        if (num == n*m && state == 0) {
            return 1;
        }
        if (num >= n*m) {
            return 0;
        }
        if (d[num][state] >= 0) {
            return d[num][state];
        }
        int ans = 0;
        if ((state & 1) == 1) {
            ans = go(n, m, d, num+1, (state >> 1));
        } else {
            ans = go(n, m, d, num+1, (state >> 1) | (1 << (m-1)));
            if ((num%m) != (m-1) && (state & 2) == 0) {
                ans += go(n, m, d, num+2, (state >> 2));
            }
        }
        ans %= 9901;
        d[num][state] = ans;
        return ans;

    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] d = new int[n*m][1<<m];
        for (int i=0; i<n*m; i++) {
            Arrays.fill(d[i], -1);
        }
        System.out.println(go(n, m, d, 0, 0));
    }
}