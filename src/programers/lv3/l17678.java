package programers.lv3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;

public class l17678 {
	public static void main(String[] args) throws ParseException {
//		int n=1, t=1, m=5; String[] timetable= {"08:00", "08:01", "08:02", "08:03"};
//		int n=2, t=10, m=2; String[] timetable= {"09:10", "09:09", "08:00"};
//		int n=2, t=1, m=2; String[] timetable= {"09:00", "09:00", "09:00", "09:00"};
//		int n=1, t=1, m=5; String[] timetable= {"00:01", "00:01", "00:01", "00:01", "00:01"};
//		int n=1, t=1, m=1; String[] timetable= {"23:59"};
//		int n=2, t=10, m=3; String[] timetable= {"09:05","09:09","09:13"};
		int n=10, t=1, m=5; String[] timetable= {"09:00","09:00","09:00","09:00","09:00"};
		
		System.out.println(new l17678().solution(n, t, m, timetable));
	}
	public String solution(int n, int t, int m, String[] timetable) throws ParseException {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		for(String s : timetable) {
			if("24:00".equals(s))pq.add("23:59");
			else pq.add(s);
		}
		SimpleDateFormat format = new SimpleDateFormat("hh:mm");
		long start = format.parse("09:00").getTime();
		long end = start + 1000 * 60 * (n-1) * t;
		long result=end;
		loop: for(int i=0;i<n;i++) {
			int tmpM = m;
			while(getlongTime(pq.peek())<=start+60*1000*i*t&&tmpM-->0) {
				String out = pq.poll();
				if(i==n-1&&tmpM==0) {
					result = getlongTime(out)-60*1000;
					break loop;
				}
				else if (pq.isEmpty()) {
					result = end;
					break loop;
				}
			}
		}
        return getHHMMTime(new Date(result).toString());
    }
	public long getlongTime(String s) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm");
		return format.parse(s).getTime();
	}
	public String getHHMMTime(String s) {
		return s.split(" ")[3].substring(0, 5);
	}
}
