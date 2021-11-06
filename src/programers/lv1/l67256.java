package programers.lv1;

import java.util.HashMap;

public class l67256 {
	public static void main(String[] args) {
		int[] numbers= {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}; String hand="right"; //"LRLLLRLLRRL"
//		int[] numbers= {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}; String hand="left"; //"LRLLRRLLLRR"
//		int[] numbers= {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}; String hand=	"right"; //"LLRLLRLLRL"
		System.out.println(new l67256().solution(numbers, hand));
	}
	public String solution(int[] numbers, String hand) {
		//         1  2  3  4  5  6  7  8  9  *  0  #
		int[] x = {0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2};
		int[] y = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3};
        StringBuilder sb = new StringBuilder();
        int lPrev = 9;
        int rPrev = 11;
        for(int i=0;i<numbers.length;i++) {
        	if(numbers[i]==1||numbers[i]==4||numbers[i]==7) {
        		sb.append("L");
        	}
        	else if(numbers[i]==3||numbers[i]==6||numbers[i]==9) {
        		sb.append("R");
        	}
        	else {
        		int ldiff = getDiff(lPrev, numbers[i], x, y);
        		int rdiff = getDiff(rPrev, numbers[i], x, y);
        		if(ldiff<rdiff) {
        			sb.append('L');
        		}
        		else if(ldiff>rdiff) {
        			sb.append('R');
        		}
        		else {
        			if("right".equals(hand)) {
        				sb.append('R');
        			}
        			else {
        				sb.append('L');
        			}
        		}
        	}
        	if(sb.charAt(sb.length()-1)=='L')lPrev=numbers[i]==0?10:numbers[i]-1;
        	else rPrev=numbers[i]==0?10:numbers[i]-1;
        }
       
        return sb.toString();
    }
	public int getDiff(int prev, int numbers, int[] x, int[] y) {
		if(prev==0)prev=10;
		if(numbers==0)numbers=10;
		else numbers--;
		return Math.abs(x[prev]-x[numbers])+Math.abs(y[prev]-y[numbers]);
	}
}
