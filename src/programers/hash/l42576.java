package programers.hash;

import java.util.HashMap;

public class l42576 {
	public static void main(String[] args) {
		String [] participant = {"leo", "kiki", "eden"};
		String [] competion= {"eden", "kiki"};
		
		System.out.println(solution(participant, competion));
	}
	public static String solution(String[] participant, String[] completion) {
		
		HashMap<String, Integer> par = new HashMap<String, Integer>();
		
        
        for(int i=0;i<participant.length;i++){
        	par.put(participant[i], 1);
        }
        
        for(int i=0;i<completion.length;i++) {
        	par.remove(completion[i]);
        }
        
        return par.keySet().toString();
    }
}
