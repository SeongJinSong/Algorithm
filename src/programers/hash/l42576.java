package programers.hash;

	import java.util.HashMap;

public class l42576 {
	public static void main(String[] args) {
		String [] participant = {"mislav", "stanko", "mislav", "ana"};
		String [] competion= {"stanko", "ana", "mislav"};
		
		System.out.println(solution(participant, competion));
	}
	public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> par = new HashMap<String, Integer>();
        for(int i=0;i<participant.length;i++){
        	par.put(participant[i], par.getOrDefault(participant[i],0)+1);
        }
        for(int i=0;i<completion.length;i++) {
        	par.put(completion[i], par.get(completion[i])-1);
        }
        for(String key : par.keySet())
        {
        	if(par.get(key)!=0)return key;
        }
        return "error";
    }
}
