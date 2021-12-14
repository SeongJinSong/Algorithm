package leetcode.lv2;

public class Reverse_Integer {
	public static void main(String[] args) {
		int x = -120;
		System.out.println(new Reverse_Integer().reverse2(x));
	}
	public int reverse(int x) {
        if(x==0)return 0;
        String s = x+"";
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<s.length();i++){
            sb.insert(0, s.charAt(i));
        }
        System.out.println(sb.toString());
        try{
            if(s.charAt(0)=='-'){
                int cnt = 0;
                for(int i=0;i<sb.length();i++) {
                    if(sb.charAt(i)=='0')cnt++;
                    else break;
                }
                return Integer.parseInt(s.charAt(0)+sb.substring(cnt));
            }else {
                sb.append(s.charAt(0));
                int cnt = 0;
                for(int i=0;i<sb.length();i++) {
                    if(sb.charAt(i)=='0')cnt++;
                    else break;
                }
                return Integer.parseInt(sb.substring(cnt));
            }    
        }catch(Exception e){
            return 0;
        }
    }
	public int reverse2(int x) {
		int result=0;
		try {
			char[] reverse = String.valueOf(Math.abs(x)).toCharArray();
			StringBuilder sb = new StringBuilder(new String(reverse)).reverse();
			if(x<0)sb.insert(0, "-");
			result = Integer.parseInt(sb.toString());
		}catch(NumberFormatException e) {
			result=0;
		}
		return result;
	}
}
