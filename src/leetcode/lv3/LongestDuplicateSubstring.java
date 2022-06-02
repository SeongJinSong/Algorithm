package leetcode.lv3;

import java.util.*;

public class LongestDuplicateSubstring {
    public static void main(String[] args) {
        LongestDuplicateSubstring lds = new LongestDuplicateSubstring();

        String s1 = "banana"; //"ana"
        String res1 = lds.longestDupSubstring6(s1);
        if(!res1.equals("ana")){
            System.out.println(s1 +" is wrong" + " res:"+res1);
        }
        String s2 = "abcd"; //""
        String res2 = lds.longestDupSubstring6(s2);
        if(!res2.equals("")){
            System.out.println(s2 +" is wrong"+ " res:"+res2);
        }
        String s3 = "nnpxouomcofdjuujloanjimymadkuepightrfodmauhrsy";
        String res3 = lds.longestDupSubstring6(s3);
        if(!res3.equals("ma")){
            System.out.println(s3 +" is wrong"+ " res:"+res3);
        }
        String s4 = "aa";
        String res4 = lds.longestDupSubstring6(s4);
        if(!res4.equals("a")){
            System.out.println(s3 +" is wrong"+ " res:"+res4);
        }
    }
    public String longestDupSubstring(String s) {
        for(int len = s.length()-1; len>=1; len--){
            for(int i=0 ; i+len<=s.length();i++) {
                String start = s.substring(i, i + len);
                for (int j = i+1; j + len <= s.length(); j++) {
                    String cur = s.substring(j, j + len);
                    if (start.equals(cur)) {
                        return start;
                    }
                }
            }
        }
        return "";
    }

    /**
     * time : O(n^2)
     * space : O(n^2)
     */
    public String longestDupSubstring2(String s) {
        String res = "";
        int l = 0, r = 0;
        HashSet<String> memo = new HashSet<>();
        String before = null;
        int beforeIndex = 0;
        int len = s.length();
        while(l < len && r < len){
            if (before == null || l != beforeIndex) {
                before = s.substring(l + 1);
                beforeIndex = l;
            }
            String t = s.substring(l, r + 1);
            if (!memo.contains(t) && before.contains(t)) {
                r++;
                if (r - l > res.length()) {
                    res = s.substring(l, r);
                }
            } else {
                l++;
                r = l + res.length();
            }
            memo.add(t);
        }
        return res;
    }

    /**
     * time O(n * log n)
     * space O(n)
     * 이제 이것도 통과 안된다.
     */
    public String longestDupSubstring3(String s) {
        //edge case
        if (s == null) {
            return null;
        }
        //binary search the max length
        int min = 0;
        int max = s.length() - 1;
        int mid;
        while (min < max - 1) {
            mid = (min + max) /2;
            if (searchForLength(s, mid) != null) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        String str = searchForLength(s, max);
        if (str != null) {
            return str;
        } else {
            return searchForLength(s, min);
        }
    }
    String searchForLength(String str, int len){
        //rolling hash method
        if (len == 0) {
            return "";
        } else if (len >= str.length()) {
            return null;
        }
        Map<Long, List<Integer>> map = new HashMap<>(); // hashcode -> list of all starting idx with identical hash
        long p = (1<<31) -1; //prime number
        long base = 256;
        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * base + str.charAt(i)) % p;
        }
        long multiplier = 1;
        for (int i = 1; i < len; i++) {
            multiplier = (multiplier * base) % p;
        }
        //first substring
        List<Integer> equalHashIdx = new ArrayList<>();
        equalHashIdx.add(0);
        map.put(hash, equalHashIdx);
        //other substrings
        int from = 0;
        int to = len;
        while (to < str.length()) {
            hash = ((hash + p - multiplier * str.charAt(from++) % p) * base + str.charAt(to++)) % p;
            equalHashIdx = map.get(hash);
            if (equalHashIdx == null) {
                equalHashIdx = new ArrayList<Integer>();
                map.put(hash, equalHashIdx);
            } else {
                for (int i0 : equalHashIdx) {
                    if (str.substring(from, to).equals(str.substring(i0, i0 + len))) {
                        return str.substring(i0, i0 + len);
                    }
                }
            }
            equalHashIdx.add(from);
        }
        return null;
    }

    /**
     * Rabin-Karp with polynomial rolling hash.
     * Search a substring of given length
     * that occurs at least 2 times.
     * Return start position if the substring exits and -1 otherwise.
     */
    /**
     * time O(n * log n)
     * space O(n)
     * "ymadkuepightrfodmauhrsy" -> "ma" 오류
     */
    public String longestDupSubstring4(String S){
        int n = S.length();
        //convert string to array of integers
        //to implement constant time slice
        int[] nums = new int[n];
        for(int i =0;i<n;i++) nums[i] = (int) S.charAt(i) - (int)'a';
        //base value for the rolling hash function
        int a = 26;
        //modulus value for the rolling hash function to avoid overflow
        long modulus = (long) Math.pow(2, 32);

        //binary search, L = repeating string length
        int left = 1, right = n;
        int L;
        while(left != right){
            L = left + (right - left) /2;
            if (search(L, a, modulus, n, nums) != -1) {
                left = L + 1;
            } else {
                right = L;
            }
        }
        int start = search(left - 1, a, modulus, n, nums);
        return start != -1 ? S.substring(start, start + left - 1) : "";
    }
    public int search(int L, int a, long modules, int n, int[] nums) {
        //compute the hash of string S[:L]
        long h = 0;
        for (int i = 0; i < L; i++) {
            h = (h * a + nums[i]) % modules;
        }

        //already seen hashes of strings of length L
        HashSet<Long> seen = new HashSet<>();
        seen.add(h);
        //const value to be used often : a**L % modulus;
        long aL = 1;
        for (int i = 1; i <= L; i++) {
            aL = (aL * a) % modules;
        }

        for (int start = 1; start < n - L + 1; ++start) {
            //compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modules + modules) % modules;
            h = (h + nums[start + L - 1]) % modules;
            if (seen.contains(h)) {
                return start;
            }
            seen.add(h);
        }
        return -1;
    }

    /**
     * Memory Limit Exceeded
     */
    // T = O(N*K), S = O(N), where N is length of S and K avg depth of trie.
    private String S;
    public String longestDupSubstring5(String S){
        this.S = S;
        int maxLo = 0, maxLength = 0;
        TrieNode root = new TrieNode(0, 0);
        for (int i = 1; i + maxLength < S.length(); i++) {
            int len = addNew(root, i);
            if (len > maxLength) {
                maxLength = len;
                maxLo = i;
            }
        }
        return S.substring(maxLo, maxLo + maxLength);
    }
    public static class TrieNode{
        private TrieNode[] next;
        private int i;
        private int depth;

        public TrieNode(int i, int depth) {
            this.i = i;
            this.depth = depth;
        }
    }
    private int addNew(TrieNode node, int i) {
        int depth = node.depth;
        if (i + depth == S.length()) {
            return depth;
        }
        if (isLeaf(node)) {
            node.next = new TrieNode[26];
            node.next[getIndex(node.i, node.depth)] = new TrieNode(node.i, depth + 1);
        }
        int c = getIndex(i, node.depth);
        TrieNode x = node.next[c];
        if (x == null) {
            node.next[c] = new TrieNode(i, depth + 1);
            return depth;
        }
        return addNew(x, i);
    }
    private int getIndex(int i, int depth) {
        return S.charAt(i + depth) - 'a';
    }

    private boolean isLeaf(TrieNode node) {
        return node.next == null;
    }

    /**
     * 정답좀 찾아보자
     */
    private static final long q = (1 << 31) - 1;
    private static final long R = 256;

    public String longestDupSubstring6(String S) {
        int left = 2;
        int right = S.length() - 1;
        int start = 0;
        int maxLen = 0;

        while (left <= right) {
            int len = left + (right - left) / 2;
            boolean found = false;

            Map<Long, List<Integer>> map = new HashMap<>();
            long hash = hash(S, len);
            map.put(hash, new ArrayList<>());
            map.get(hash).add(0);
            long RM = 1l;
            for (int i = 1; i < len; i++) {
                RM = (R * RM) % q;
            }

            loop: for (int i = 1; i + len <= S.length(); i++) {
                hash = (hash + q - RM * S.charAt(i - 1) % q) % q;
                hash = (hash * R + S.charAt(i + len - 1)) % q;
                if (!map.containsKey(hash)) {
                    map.put(hash, new ArrayList<>());
                } else {
                    for (int j : map.get(hash)) {
                        if (compare(S, i, j, len)) {
                            found = true;
                            start = i;
                            maxLen = len;
                            break loop;
                        }
                    }
                }
                map.get(hash).add(i);
            }
            if (found)
                left = len + 1;
            else
                right = len - 1;
        }
        return S.substring(start, start + maxLen);
    }

    private long hash(String S, int len) {
        long h = 0;
        for (int j = 0; j < len; j++)
            h = (R * h + S.charAt(j)) % q;
        return h;
    }

    private boolean compare(String S, int i, int j, int len) {
        for (int count = 0; count < len; count++) {
            if (S.charAt(i++) != S.charAt(j++))
                return false;
        }
        return true;
    }
}
