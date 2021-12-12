package leetcode.lv2;

public class LongestPalindrome {
	public static void main(String[] args) {
		String s = "ac";
		System.out.println(new LongestPalindrome().longestPalindrome2(s));
	}
	public String longestPalindrome(String s) {
        String max = "";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String curStr="";
                if(isPalindrome(s, i, j)){
                    curStr=s.substring(i,j+1);
                }; 
                if(max.length()<curStr.length()){
                    max=curStr;
                }
            }
        }
        return max;
    }
	public String longestPalindrome2(String s) {
        String max = "";
        for(int i=0;i<s.length();i++){
            String curStr1=getMax(s, i, i);
            String curStr2=i!=s.length()-1?getMax(s, i, i+1):"";
            String curStr = curStr1.length()>curStr2.length()?curStr1:curStr2;
            if(max.length()<curStr.length()){
                max=curStr;
            }
        }
        return max;
    }
	public String getMax(String s, int start, int to) {
		 if(isPalindrome(s, start-1, to+1))return getMax(s, start-1, to+1);
		 return isPalindrome(s, start, to)?s.substring(start, to+1):"";
	}
    public boolean isPalindrome(String s, int from, int to){
        if(from<0||to>s.length()-1)return false;
        if(from==to)return true;
        if(from==to-1)return s.charAt(from)==s.charAt(to);
        int mid = (to+from)/2;
        if((to-from+1)%2==0){
            if(s.charAt(mid)!=s.charAt(mid+1))return false;
            for(int i=0;i<=(mid-from);i++){
                if(s.charAt(mid-i)!=s.charAt(mid+1+i))return false;
            }
        }
        else{
            for(int i=0;i<=(mid-from);i++){
                if(s.charAt(mid-i)!=s.charAt(mid+i))return false;
            }
        }
        return true;
    }
}
