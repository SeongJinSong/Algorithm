package leetcode.lv3;

public class LongestDuplicateSubstring {
    public static void main(String[] args) {
        LongestDuplicateSubstring lds = new LongestDuplicateSubstring();

        String s1 = "banana"; //"ana"
        if(!lds.longestDupSubstring(s1).equals("ana")){
            System.out.println(s1 +" is wrong");
        }
//        String s2 = "abcd"; //""
//        if(!lds.longestDupSubstring(s2).equals("")){
//            System.out.println(s2 +" is wrong");
//        }
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
}
