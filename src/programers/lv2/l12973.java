package programers.lv2;

public class l12973 {
	public static void main(String[] args) {
		String s = "baabaa";
		System.out.println(new l12973().solution(s));
	}
	public int solution(String s)
    {
        while(s.length()>0){
        	StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(i<s.length()-1&&s.charAt(i)==s.charAt(i+1)){
                    i++;
                    continue;
                }
                else sb.append(s.charAt(i));
            }
            if(s.length()==sb.length()) {
            	return 0;
            }
            else if(sb.length()>0) {
            	s=sb.toString();
            }
            else if(sb.length()==0) {
            	return 1;
            }
        }
        return 1;
    }
}
