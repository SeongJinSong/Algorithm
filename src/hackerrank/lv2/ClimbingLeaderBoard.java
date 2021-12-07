package hackerrank.lv2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class ClimbingLeaderBoard_Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
        List<Integer> newRanked =  new ArrayList<>();
        int prev = -1;
        for(int i=0;i<ranked.size();i++){
            if(prev!=ranked.get(i)){
                prev = ranked.get(i);
                newRanked.add(ranked.get(i));
            }
        }
        List<Integer> res =  new ArrayList<>();
        for(int i=0;i<player.size();i++){
            int start = 0;
            int end = newRanked.size();
            int mid = 0;
            while(start<end){
                mid = (start+end)/2;
                if(newRanked.get(mid)<player.get(i)){
                    end = mid;
                }else if(newRanked.get(mid)>player.get(i)){
                    start = mid+1;
                }else{
                    start=mid;
                    break;
                }
            }
            res.add(start+1);
        }
        return res;
    }
    public static void print(List<Integer> arr){
        for(int i:arr)System.out.print(i+" ");
        System.out.println();
    }
}

public class ClimbingLeaderBoard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] rankedTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ranked = new ArrayList<>();

        for (int i = 0; i < rankedCount; i++) {
            int rankedItem = Integer.parseInt(rankedTemp[i]);
            ranked.add(rankedItem);
        }

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] playerTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> player = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            int playerItem = Integer.parseInt(playerTemp[i]);
            player.add(playerItem);
        }

        List<Integer> result = ClimbingLeaderBoard_Result.climbingLeaderboard(ranked, player);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}