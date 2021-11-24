package programers.lv1;

public class l68935 {
	public static void main(String[] args) {
		int n = 45;
		System.out.println(new l68935().solution2(n));
	}
	public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0) {
        	sb.insert(0,n%3);
        	n/=3;
        }
		int answer = 0;
		for(int i=0;i<sb.length();i++) {
			answer+=(sb.charAt(i)-'0')*Math.pow(3, i);
		}
        return answer;
    }
	//Integer.parseInt(a,3)을 사용하면 3진법을 10진법으로 바꿔주는걸 첨알았다.
	public int solution2(int n) {
		String a = "";
		while(n>0) {
			a=(n%3)+a;
			n/=3;
		}
		a=new StringBuilder(a).reverse().toString();
		System.out.println(a);
		return Integer.parseInt(a, 3);
	}
}
