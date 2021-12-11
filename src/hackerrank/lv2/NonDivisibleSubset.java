package hackerrank.lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class NonDivisibleSubset {
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = NonDivisibleSubset_.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class NonDivisibleSubset_ {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
    // Write your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : s){
            int rest = i%k;
            hm.put(rest, hm.getOrDefault(rest, 0)+1);
        }
        int max=0;
        for(int i=1;i<=(k-1)/2;i++){
            max +=Math.max(hm.getOrDefault(i, 0), hm.getOrDefault(k-i, 0));
        }
        //when rest 0 exists, you can have only 1 rest 0 key;
        if(hm.containsKey(0))max++;
        //when rest k/2, you can have only 1
        if(k%2==0&&hm.containsKey(k/2))max++;
        return max;
    }

}
