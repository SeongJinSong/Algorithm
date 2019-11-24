package dynamic.sol5;

import java.io.*;
import java.util.*;

class Fraction { // a + b/c
    long a;
    int b, c;

    public Fraction(long a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean biggerThan(Fraction f) {
        if (a > f.a) return true;
        if (a == f.a) {
            double my = b / c;
            double other = f.b / f.c;
            if (my > other) return true;
            return false;
        }
        return false;
    }
}

class LinearFunc2 {
    int a;
    long b;

    public LinearFunc2(int a, long b) {
        this.a = a;
        this.b = b;
    }

    public Fraction getCross(int pastIndex) {
        if (pastIndex == -1) return new Fraction(0, 0, 1);
        long up = b - Commando_2.stack.get(pastIndex).b;
        long down = Commando_2.stack.get(pastIndex).a - a;
        long b = up % down;
        return new Fraction(up / down, (int) b, (int) down);
    }
}

public class Commando_2 {
    static ArrayList<LinearFunc2> stack;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken()), C = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long DP[] = new long[2];
        int pSum[] = new int[2];
        stack = new ArrayList<>();
        for (int n = 1; n <= N; ++n) {
            pSum[0] = pSum[1];
            pSum[1] += Long.parseLong(st.nextToken());
            DP[0] = DP[1];
            LinearFunc2 newLine = new LinearFunc2(-2 * A * pSum[0], (long) A * pSum[0] * pSum[0] - B * pSum[0]
                    + DP[0]);
            while (stack.size() > 0) {
                if (newLine.getCross(stack.size() - 1).biggerThan(stack.get(stack.size() - 1).getCross(stack.size() - 2))) break;
                stack.remove(stack.size() - 1);
            }
            stack.add(newLine);
            while (1 < stack.size() && stack.get(1).getCross(0).a < pSum[1]) {
                stack.remove(0);
            }
            DP[1] = (long) stack.get(0).a * pSum[1] + stack.get(0).b + (long) A * pSum[1] * pSum[1] + B * pSum[1] + C;
        }
        bw.write(Long.toString(DP[1]));
        bw.flush();
        bw.close();
    }
}