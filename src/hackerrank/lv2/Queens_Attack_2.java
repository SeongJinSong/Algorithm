package hackerrank.lv2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Queens_Attack_2_ {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
    // Write your code here
        int sum = 0;
        sum+=findNext(r_q, c_q, 1, 0, obstacles, n); //상
        sum+=findNext(r_q, c_q, -1, 0, obstacles, n); //하
        sum+=findNext(r_q, c_q, 0, -1, obstacles, n); //좌
        sum+=findNext(r_q, c_q, 0, 1, obstacles, n); //우
        
        sum+=findNext(r_q, c_q, 1, 1, obstacles, n); //우상
        sum+=findNext(r_q, c_q, -1, 1, obstacles, n); //우하
        sum+=findNext(r_q, c_q, 1, -1, obstacles, n); //좌상
        sum+=findNext(r_q, c_q, -1, -1, obstacles, n); //좌하
        return sum;
    }
    public static int findNext(int cr, int cc, int dr, int dc, List<List<Integer>> obstacles, int n){
        int nr=cr+dr;
        int nc=cc+dc;
        if(cango(nr,nc,obstacles, n))return 1+findNext(nr, nc, dr, dc, obstacles, n);
        else return 0;
    }
    public static boolean cango(int nr, int nc, List<List<Integer>> obstacles, int n){
        if(nr<=0||nr>n||nc<=0||nc>n)return false;
        for(List<Integer> list:obstacles){
            if(list.get(0)==nr&&list.get(1)==nc)return false;
        }
        return true;
    }
    public static int queensAttack2(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
    	HashMap<String, String> hm = new HashMap<String, String>();
    	for(List<Integer> list : obstacles) {
    		hm.put(list.get(0)+"-"+list.get(1), "obs");
    	}
    	int answer=0;
    	int[] dy= {1, -1,  0, 0, 1, -1,  1,  -1};
    	int[] dx= {0,  0, -1, 1, 1,  1, -1, -1};
    	for(int i=0;i<dx.length;i++) {
    		int ny = r_q;
    		int nx = c_q;
    		while(true) {
    			ny+=dy[i];
    			nx+=dx[i];
    			if(nx<=0||ny<=0||nx>n||ny>n) {
    				break;
    			}
    			String key=ny+"-"+nx;
    			if(hm.containsKey(key)) {
    				break;
    			}
    			answer++;
    		}
    	}
    	return answer;
    }
}

public class Queens_Attack_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Queens_Attack_2_.queensAttack2(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
