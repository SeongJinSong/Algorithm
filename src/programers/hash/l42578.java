package programers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import static java.util.stream.Collectors.*;

public class l42578 {
	public static void main(String[] args) {
//		String [][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String [][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(solution2(clothes));
	}
	public static int solution(String[][] clothes) {
		HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
		for(String[] a : clothes) {
			if(!map.containsKey(a[1])) {
				HashSet<String> hs = new HashSet<String>();
				hs.add(a[1]);
				map.put(a[1], hs);
			}
			else map.get(a[1]).add(a[0]);
		}
		int answer = 1;
		for(String a : map.keySet()) {
			answer *= (map.get(a).size()+1);
		}
        return answer-1;
    }
	
	/*스트림을 사용 import static stream Collectors -- groupingby, mapping, counting*/
	public static int solution2(String[][] clothes) {
		return Arrays.stream(clothes)
				.collect(groupingBy(p->p[1], mapping(p->p[0], counting())))
				.values()
				.stream()
				.collect(reducing(1L, (x,y)->x*(y+1))).intValue()-1;
	}
}
