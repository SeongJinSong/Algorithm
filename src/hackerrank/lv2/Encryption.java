package hackerrank.lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Encryption_ {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
        int r = (int)Math.floor(Math.sqrt(s.length()));
        int c;
        if(r*r==s.length()) c= r;
        else c = r+1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<c;i++){
            for(int j=i;j<s.length();j+=c){
                sb.append(s.charAt(j));
            }
            sb.append(" ");  
        }
        return sb.toString();
    }

}
public class Encryption {
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Encryption_.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
