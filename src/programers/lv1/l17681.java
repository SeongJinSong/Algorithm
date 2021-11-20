package programers.lv1;

public class l17681 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            answer[i]=res(convert2(arr1[i], n), convert2(arr2[i], n));
        }
        return answer;
    }
    public String convert2(int num, int n){
        StringBuilder sb = new StringBuilder();
        while(num>0){
            sb.insert(0, num%2);
            num/=2;
        }
        int res = sb.length();
        if(res<n){
            for(int i=0;i<n-res;i++)
            sb.insert(0, "0");
        }
        return sb.toString();
    }
    public String res(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)=='0'&&s2.charAt(i)=='0'){
                sb.append(' ');
            }
            else sb.append('#');
        }
        return sb.toString();
    }
}
