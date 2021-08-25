package baekjoon.dynamic.sol3;

import java.io.*;
import java.util.*;

public class PracticeSeason_1 {
    private static Integer[][][][] cache;

    private static int solve(int C, int D, int d, List<Integer> S1, List<Integer> S2, int index1, int index2, int numRestDays1, int numRestDays2) {
        if (index1 == S1.size() && index2 == S2.size()) {
            return 0;
        }

        if (cache[index1][index2][numRestDays1][numRestDays2] == null) {
            int result = Integer.MAX_VALUE;
        
            if (index1 < S1.size()) {
                result = Math.min(result, solve(C, D, d, S1, S2, index1 + 1, index2, 0, numRestDays2 + 1) + C + (numRestDays2 == 0 ? D + d : d));
            }
            
            if (index2 < S2.size()) {
                result = Math.min(result, solve(C, D, d, S1, S2, index1, index2 + 1, numRestDays1 + 1, 0) + (numRestDays1 == 0 ? D + d : d) + C);
            }
            
            if (index1 < S1.size() && index2 < S2.size()) {
                result = Math.min(result, solve(C, D, d, S1, S2, index1 + 1, index2 + 1, 0, 0) + (S1.get(index1) == S2.get(index2) ? C : 2 * C));
            }

            cache[index1][index2][numRestDays1][numRestDays2] = result;
        }

        return cache[index1][index2][numRestDays1][numRestDays2];
    }

    private static int solve(int C, int D, int d, List<Integer> S1, List<Integer> S2) {
        return solve(C, D, d, S1, S2, 0, 0, 0, 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        for (int i = 0; i < T; ++i) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            List<Integer> S1 = new ArrayList<>();

            st = new StringTokenizer(in.readLine());
            while (true) {
                int c = Integer.parseInt(st.nextToken());
                if (c == 0) {
                    break;
                }

                S1.add(c);
            }

            List<Integer> S2 = new ArrayList<>();

            st = new StringTokenizer(in.readLine());
            while (true) {
                int c = Integer.parseInt(st.nextToken());
                if (c == 0) {
                    break;
                }

                S2.add(c);
            }

            cache = new Integer[S1.size() + 1][S2.size() + 1][Math.max(S1.size(), S2.size()) + 1][Math.max(S1.size(), S2.size()) + 1];

            System.out.println(solve(C, D, d, S1, S2));
        }

        in.close();
    }
}