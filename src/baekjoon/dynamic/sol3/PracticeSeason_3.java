package baekjoon.dynamic.sol3;

import java.io.*;
import java.util.*;

public class PracticeSeason_3 {
    static int t,C,D,d;
    static int[] x,y;
    static int[][][][][] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());D = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            //x팀 입력
            st = new StringTokenizer(br.readLine());
            x = new int[st.countTokens()];
            for (int j = 1; j < x.length; j++) x[j] = Integer.parseInt(st.nextToken());

            //y팀 입력
            st = new StringTokenizer(br.readLine());
            y = new int[st.countTokens()];
            for (int j = 1; j < y.length; j++) y[j] = Integer.parseInt(st.nextToken());

            cache = new int[x.length+y.length][x.length+1][y.length+1][2][2];
            for (int j = 0; j < cache.length; j++) {
                for (int k = 0; k < cache[j].length; k++) {
                    for (int l = 0; l < cache[j][k].length; l++) {
                        for (int m = 0; m < cache[j][k][l].length; m++) {
                            for (int n = 0; n < cache[j][k][l][m].length; n++) {
                                cache[j][k][l][m][n] = -1;
                            }
                        }
                    }
                }
            }
//            System.out.println(Arrays.toString(x));
//            System.out.println(Arrays.toString(y));
            int ret = sol(1,1,1,0,0);
            System.out.println(ret);
        }
    }
    public static int sol(int n, int xi, int yi, int sx, int sy) {
//        System.out.println("n = [" + n + "], xi = [" + xi + "], yi = [" + yi + "], sx = [" + sx + "], sy = [" + sy + "]");
        if(xi == x.length && yi == y.length) return 0;
        if(n >= x.length+y.length) return 1000000;

        if(cache[n][xi][yi][sx][sy] != -1) return cache[n][xi][yi][sx][sy];

        int ret = Integer.MAX_VALUE;

        //X,Y 둘다 연습할 경우
        if(xi < x.length && yi < y.length){
            if(x[xi] == y[yi]){
                ret = sol(n+1, xi+1,yi+1,0,0)+C;
            }else {
                ret = sol(n+1, xi+1,yi+1,0,0)+2*C;
            }
        }
        //X만 연습
        if(xi < x.length) {
            int cost_rest= (sy == 1) ? d : D + d;
            ret = Math.min(sol(n+1,xi+1,yi,0,1)+cost_rest+C,ret);
        }
        //Y만 연습
        if(yi < y.length) {
            int cost_rest = (sx == 1) ? d : D + d;
            ret = Math.min(sol(n+1,xi,yi+1,1,0)+cost_rest+C,ret);
        }
        //둘다 연습 안함
        int cost_rest = 2*d;
        if(sx == 0) cost_rest += D;
        if(sy == 0) cost_rest += D;
        ret = Math.min(sol(n+1,xi,yi,1,1)+cost_rest, ret);

        cache[n][xi][yi][sx][sy] = ret;
        return ret;
    }

}
/*
5
4 5 2
3 5 6 7 5 0
3 5 6 7 0
10 5 1
1 2 3 4 5 6 7 0
2 3 4 5 6 7 1 0
2 9 1
1 2 3 4 5 6 7 0
2 3 4 5 6 7 1 0
8 1 3
1 2 3 4 5 6 7 6 5 4 3 0
2 5 4 0
4 3 3
5 6 7 1 4 5 6 7 0
3 5 6 7 0



1
4 5 2
3 5 6 7 5 0
3 5 6 7 0

 */