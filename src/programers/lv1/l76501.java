package programers.lv1;

public class l76501 {
	public static void main(String[] args) {
		
	}
	public int solution(int[] absolutes, boolean[] signs) {
        int answer=0;
        for(int i=0;i<absolutes.length;i++){
            answer+=absolutes[i]*(signs[i]?1:-1);
        }
        return answer;
    }
}
