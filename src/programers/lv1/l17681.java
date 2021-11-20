package programers.lv1;

public class l17681 {
	public static void main(String[] args) {
//		int n=5; int[] arr1= {9, 20, 28, 18, 11}; int[] arr2= {30, 1, 21, 17, 28};
		int n=6; int[] arr1= {46, 33, 33 ,22, 31, 50}; int[] arr2= {27 ,56, 19, 14, 14, 10};
		new l17681().print(new l17681().solution2(n, arr1, arr2));
	}
	public void print(String [] arr) {
		for(String s : arr)System.out.println(s);
	}
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
    public String[] solution2(int n, int[] arr1, int[] arr2) {
    	String[] result = new String[n];
    	for(int i=0;i<n;i++) {
    		result[i]=Integer.toBinaryString(arr1[i]|arr2[i]);
    	}
    	
    	for(int i=0;i<n;i++) {
    		result[i]=String.format("%"+n+"s", result[i]);
    		result[i]=result[i].replace("1", "#");
    		result[i]=result[i].replace("0", " ");
    	}
    	return result;
    }
}
