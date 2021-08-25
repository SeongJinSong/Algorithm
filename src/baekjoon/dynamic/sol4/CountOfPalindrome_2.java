package baekjoon.dynamic.sol4;

/*
���� ����. �ڹ� ���ʷ� �� ������ Ǯ��. by �ֿ켮
*/
import java.io.*;
import java.util.*;

public class CountOfPalindrome_2 {
   static int N,K;
   static long mod = 835454957;
   static String[][] w;
   static HashMap<Tuple, Long> hashMap;
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       K = Integer.parseInt(st.nextToken());

       w = new String[N][2];
       for (int i = 0; i < N; i++) {
           w[i][0] = br.readLine();
           StringBuilder sb = new StringBuilder(w[i][0]);
           w[i][1] = sb.reverse().toString();
       }

       hashMap = new HashMap<>();

       long ret = 0;
       for (int i = 1; i <= K; i++) {
           for (int j = 0; j < N; j++) {
               ret += sol(i-w[j][0].length(),w[j][0],0);
//               System.out.println("�Ӹ��帲 ���� : "+ i
//               +" w[j]�� �ε��� j : " +j +" ����� �� : "+ret);
               ret %= mod;
           }
       }
       System.out.println(ret);
       

   }
   public static boolean isPalindrom(String str){
       if(str.equals("")) return true;
       int s = 0; int e = str.length()-1;
       while(true){
           if(str.charAt(s) == str.charAt(e)) {
               s++; e--;
           }else return false;

           if(s == e || s > e) return true;
       }
   }

   public static long sol(int n, String s, int pos) {
       Tuple key = new Tuple(n,s,pos);
       if(n < 0) return 0;
       if(isPalindrom(s) && n == 0) {
//           System.out.println("���� s�� ���� : " + s);
           return 1;
       }
       if(hashMap.containsKey(key)) return hashMap.get(key);

       long ret = 0;
       for (int i = 0; i < N; i++) {
           String word = w[i][0];
           String r_word = w[i][1];
           int w_l = word.length();
           if(pos == 0){
               if(w_l > s.length() && r_word.startsWith(s))
                   ret += sol(n-w_l-1, word.substring(0,word.length()-s.length()), 1);
               else if(w_l <= s.length() && s.startsWith(r_word))
                   ret += sol(n-w_l-1, s.substring(word.length()), 0);

           }else {

               if(w_l > s.length() && r_word.endsWith(s))
                   ret += sol(n-w_l-1, word.substring(s.length()), 0);
               else if(w_l <= s.length() && s.endsWith(r_word))
                   ret += sol(n-w_l-1, s.substring(0,s.length()-word.length()), 1);

           }
           ret %= mod;
       }
//       System.out.println("n = [" + n + "], s = [" + s + "], pos = [" + pos + "]");
       ret %= mod;
       hashMap.put(key,ret);
       return ret;
   }
}
class Tuple {
   int k, pos;
   String s;
   public Tuple(int k, String s, int pos){
       this.k = k;
       this.s = s;
       this.pos = pos;
   }

   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       Tuple tuple = (Tuple) o;
       return k == tuple.k &&
               pos == tuple.pos &&
               Objects.equals(s, tuple.s);
   }

   @Override
   public int hashCode() {
       return Objects.hash(k, pos, s);
   }
}
/*
2 4
z
zz
*/