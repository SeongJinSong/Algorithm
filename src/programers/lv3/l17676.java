package programers.lv3;

import java.util.Arrays;

public class l17676 {
	public static void main(String[] args) {
//		String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
//		String[] lines = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
		String[] lines = {
				"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
		System.out.println(solution(lines));
	}
	public static int solution(String[] lines) {
        String[] from = new String[lines.length];
        String[] to = new String[lines.length];
        for(int i=0;i<lines.length;i++) {
        	to[i] = lines[i].split(" ")[1];
        	int h = Integer.valueOf(to[i].split(":")[0]);
        	int m = Integer.valueOf(to[i].split(":")[1]);
        	Double s = Double.valueOf(to[i].split(":")[2]);
        	String last = lines[i].split(" ")[2];
        	Double mm3 = Double.valueOf(last.substring(0, last.length()-1));
        	if(s>mm3) {
        		s-=mm3;
        	}
        	else {
        		s=60.0-mm3+s;
        		if(m==0) {
        			m=59;
        			if(h==0) {
        				h=23;
        			}
        			else h-=1;
        		}
        		else m--;
        	}
        	from[i] = String.format("%02d:%02d:%06.3f", h, m, s);
        }
        String fromMin = Arrays.stream(from).min((a,b)->a.compareTo(b)).get().split("\\.")[0];
        String toMax = Arrays.stream(to).max((a,b)->a.compareTo(b)).get().split("\\.")[0];
        int max = 0;
        while(!toMax.equals(fromMin)) {
        	int cnt =0;
        	for(int i=0;i<lines.length;i++) {
        		if(from[i].compareTo(fromMin)<=0&&fromMin.compareTo(to[i])<=0) {
        			System.out.println("line:"+lines[i]+" \tfrom : "+from[i]+" cur:"+fromMin+" to:"+to[i]);
        			cnt++;
        		}
        	}
        	if(max<cnt)max=cnt;
        	fromMin = next(fromMin);
        }
        return max;
    }
	public static String next(String str) {
		System.out.println("str:"+str);
		int h = Integer.valueOf(str.split(":")[0]);
    	int m = Integer.valueOf(str.split(":")[1]);
    	int s = Integer.valueOf(str.split(":")[2]);
    	if(s==59) {
    		s=0;
    		if(m==59) {
    			m=0;
    			if(h==23)h=0;
    			else h++;
    		}else m++;
    	}
    	else s++;
    	return String.format("%02d:%02d:%02d", h,m,s);
	}
	public static void print(String[] arr) {
		for(String s : arr)System.out.println(s);
	}
}
