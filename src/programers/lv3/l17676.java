package programers.lv3;

import java.util.*;
import java.text.SimpleDateFormat;

public class l17676 {
	public static void main(String[] args) throws Exception {
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
		System.out.println(solution2(lines));
	}
	
	public static int solution2(String[] lines) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
		int[] counts = new int[lines.length];
		int max = 0;
		
		for(int i=0; i<lines.length;i++) {
			// 이전 로그의 완료 시점
			String[] pre = lines[i].split(" ");
			Date preEndDate = format.parse(pre[1]);
			long preEnd = preEndDate.getTime();
			// 해당 로그보다 늦게 종료되는 로그 체크
			for(int j=i;j<lines.length;j++) {
				//다음 로그의 시작시점
				String[] next = lines[j].split(" ");
				Date nextEndDate = format.parse(next[1]);
				double sec = Double.parseDouble(next[2].substring(0, next[2].length()-1));
				
				//다음로그의 정료시점 - 처리 초 + 1;
				long nextStart = (long)(nextEndDate.getTime() - sec*1000 + 1);
				
				//이전 로그의 종료 시점부터 +1 초 범위 안에 시작되면 +1
				if(preEnd+1000>nextStart) {
					counts[i] +=1;
					max = Math.max(max,  counts[i]);
				}
			}
		}
		return max;
	}
	class Log{
		private long start = 0;
		private long duration = 0;
		private long end = 0;
		public Log(String line) {
			String[] split = line.split(" ");
			String dateString = split[0]+" "+split[1];
			try {
				Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
				this.end = startDate.getTime();
				String[] split2 = split[2].split("s");
				double parseDouble = Double.parseDouble(split2[0]);
				this.duration = (long) (parseDouble * 1000);
				
				this.start = this.end - this.duration;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		public boolean isIn(long checkPointStart, long checkPointEnd) {
			if(this.end < checkPointStart || this.start >= checkPointEnd) {
				return false;
			}
			return true;
		}
		public long getStart() {
			return start;
		}
		public void setStart(long start) {
			this.start=start;
		}
		public long getDuration() {
			return duration;
		}
		public void setDuration(long duration) {
			this.duration = duration;
		}
		public long getEnd() {
			return end;
		}
		public void setEnd(long end) {
			this.end=end;
		}
	}
	public int solution3(String[] lines) {
		int answer = 0;
		List<Long> checkPointList = new ArrayList<Long>();
		List<Log> logList = new ArrayList<Log>();
		
		for(String line : lines) {
			Log log = new Log(line);
			checkPointList.add(log.getStart());
			checkPointList.add(log.getEnd());
			logList.add(log);
		}
		Collections.sort(checkPointList);
		int top=0;
		for(int i=0;i<checkPointList.size();i++) {
			int count=0;
			for(Log log : logList) {
				if(log.isIn(checkPointList.get(i), checkPointList.get(i)+999)) {
					count++;
				}
			}
			if(count>top) {
				top=count;
			}
		}
		answer = top;
		return answer;
	}
	/* 너무 쓰레기같이 풀어서 반성하려고 남겨둠 */
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
        	s+=0.001;
        	from[i] = String.format("%02d:%02d:%06.3f", h, m, s);
        }
        int max = 0;
        for(int i=0;i<from.length;i++) {
        	int cnt =1;
        	for(int j=0;j<lines.length;j++) {
        		if(i==j)continue;
            	int h = Integer.valueOf(from[i].split(":")[0]);
            	int m = Integer.valueOf(from[i].split(":")[1]);
            	Double s = Double.valueOf(from[i].split(":")[2]);
            	if(s<59) {
            		s++;
            	}
            	else {
            		s-=59;
            		if(m==59) {
            			m=0;
            			if(h==23) {
            				h=0;
            			}
            			else h++;
            		}
            		else m++;
            	}
            	String from_plus1 = String.format("%02d:%02d:%06.3f", h, m, s);
        		if(from[i].compareTo(from[j])<=0&&from[j].compareTo(from_plus1)<=0) {
        			cnt++;
        		}else if(from[i].compareTo(to[j])<=0&&to[j].compareTo(from_plus1)<=0) {
        			cnt++;
        		}
        	}
        	if(max<cnt)max=cnt;
        }
        for(int i=0;i<to.length;i++) {
        	int cnt =0;
        	for(int j=0;j<lines.length;j++) {
        		if(i==j)continue;
            	int h = Integer.valueOf(to[i].split(":")[0]);
            	int m = Integer.valueOf(to[i].split(":")[1]);
            	Double s = Double.valueOf(to[i].split(":")[2]);
            	if(s>1) {
            		s--;
            	}
            	else {
            		s+=59;
            		if(m==0) {
            			m=59;
            			if(h==0) {
            				h=23;
            			}
            			else h--;
            		}
            		else m--;
            	}
            	String to_minus1 = String.format("%02d:%02d:%06.3f", h, m, s);
        		if(to_minus1.compareTo(to[i])<=0&&to[j].compareTo(to[i])<=0) {
        			cnt++;
        		}else if(to_minus1.compareTo(from[j])<=0&&from[j].compareTo(to[i])<=0) {
        			cnt++;
        		}
        	}
        	if(max<cnt)max=cnt;
        }
        return max;
    }
}
