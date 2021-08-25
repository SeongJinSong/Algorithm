package baekjoon.dynamic.sol5;

import java.io.*;
import java.util.*;

class LinearFunc {
    long a, b;
    double s;

    public LinearFunc(long a, long b) {
        this.a = a;
        this.b = b;
        this.s = 0; // 0���� ����
    }

    public void getCross(LinearFunc l){
        this.s = (b - l.b) / (l.a - a);
    }
}

public class CutTree_3 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long A[] = new long[N];
        long B[] = new long[N];
        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; ++n) {
            A[n] = Integer.parseInt(stA.nextToken());
            B[n] = Integer.parseInt(stB.nextToken());
        }
        long DP[] = new long[N];
        DP[0] = 0;
        LinearFunc stack[] = new LinearFunc[N];
        int top = 0;
        int posX = 0;
        for (int n = 1; n < N; ++n) {
            LinearFunc newFunc = new LinearFunc(B[n - 1], DP[n - 1]);
            while(top > 0){
                newFunc.getCross(stack[top - 1]);
                if(stack[top - 1].s < newFunc.s) break;
                if(--top == posX) posX--;
            }
            stack[top++] = newFunc;
            while(posX < top - 1 && stack[posX + 1].s < A[n]) posX++;
            DP[n] = stack[posX].a * A[n] + stack[posX].b;
        }

        bw.write(Long.toString(DP[N - 1]));
        bw.flush();
        bw.close();
    }
}