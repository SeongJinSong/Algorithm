package programers.lv1;

import java.util.HashMap;

public class l81301 {
	public static void main(String[] args) {
		String s = "one4seveneight";
		System.out.println(new l81301().solution(s));
	}
	public int solution(String s) {
		HashMap<String, String> hm = new HashMap<>();
		hm.put("zero", "0");
		hm.put("one", "1");
		hm.put("two", "2");
		hm.put("three", "3");
		hm.put("four", "4");
		hm.put("five", "5");
		hm.put("six", "6");
		hm.put("seven", "7");
		hm.put("eight", "8");
		hm.put("nine", "9");
		for(String str : hm.keySet()) {
			s=s.replaceAll(str, hm.get(str));
		}
        return Integer.valueOf(s);
    }
}
