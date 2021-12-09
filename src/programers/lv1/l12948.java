package programers.lv1;

public class l12948 {
	public static void main(String[] args) {
		String phone_number = "01033334444";
//		String phone_number = "027778888";
		System.out.println(new l12948().solution2(phone_number));
	}
	public String solution(String phone_number) {
		int n = phone_number.length();
        return phone_number.substring(0, n-4).replaceAll("[0-9]","*")+phone_number.substring(n-4, n);
    }

	//. -> 임의의 문자 한 개 
	//(?=.) -> 뒷쪽에 임의의 문자 한 개를 제외하고 선택
	//{숫자} -> 숫자 만큼의 자릿수 
	//.(?=.{4}) ==> 뒤쪽에서 임의의 문자 4개를 제외한 임의의 문자 한 개 선택
	public String solution2(String phone_number) {
	    return phone_number.replaceAll(".(?=.{4})", "*");
	  }
}
