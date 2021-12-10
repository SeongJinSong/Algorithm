package programers.lv2;

import java.util.HashSet;

public class l12981 {
	public static void main(String[] args) {
//		int n=3; String[] words= {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
//		int n=5; String[] words= {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		int n=2; String[] words= {"hello", "one", "even", "never", "now", "world", "draw"};
		new l12981().print(new l12981().solution(n, words));
	}
	public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        HashSet<String> hs = new HashSet<>();
        int err=-1;
        for(int i=0;i<words.length;i++) {
        	if(!hs.add(words[i])) {
        		err=i;
        		break;
        	}
        	if(i!=0) {
        		if(words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)) {
        			err=i;
        			break;
        		}
        	}
        }
        if(err!=-1) {
        	return new int[] {err%n+1, err/n+1};
        }
        return answer;
    }
	public void print(int[] arr) {
		for(int i : arr)System.out.print(i+" ");
		System.out.println();
	}
}
