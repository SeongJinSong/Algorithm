package baekjoon.dynamic.sol5;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

public class RandomSort_2 {

  static HashMap<Integer, Double> D;
  static int sorted;

  public static void main(String [] args) {
    InputReader scanner = new InputReader(System.in);
    int N = scanner.nextInt();
    D = new HashMap<>();
    int curr = 0;
    sorted = 0;
    for (int i = 0; i < N; i++) {
      int n = scanner.nextInt();
      curr = 10 * curr + n;
      sorted = 10 * sorted + (i + 1);
    }
    System.out.println(solve(curr));
  }

  static double solve(int curr) {
    if (D.containsKey(curr)) {
      return D.get(curr);
    }
    if (curr == sorted) {
      return 0;
    }
    Integer [] a = toArray(curr);
    int invCnt = 0;
    double res = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (a[i] > a[j]) {
          swap(a, i, j);
          res += solve(toInt(a));
          swap(a, i, j);
          invCnt++;
        }
      }
    }
    res = res / invCnt + 1;
    D.put(curr, res);
    return res;
  }

  static void swap(Integer [] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  static Integer [] toArray(int n) {
    ArrayList<Integer> d = new ArrayList<>();
    while (n > 0) {
      d.add(n % 10);
      n /= 10;
    }
    Collections.reverse(d);
    return d.toArray(new Integer[0]);
  }

  static int toInt(Integer [] a) {
    int res = 0;
    for (int i = 0; i < a.length; i++) {
      res = 10 * res + a[i];
    }
    return res;
  }

  static class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String nextLine() {
      try {
        return reader.readLine();
      } catch(IOException e) {
        return null;
      }
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
          if (!tokenizer.hasMoreTokens()) {
            return null;
          }
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }
  }
}
