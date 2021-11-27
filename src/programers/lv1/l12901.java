package programers.lv1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class l12901 {
	public static void main(String[] args) throws ParseException {
		int a=5, b=24;
		System.out.println(new l12901().solution(a, b));
	}
	public String solution(int a, int b) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd");
		Date d = format.parse("2016:"+String.format("%02d", a)+":"+String.format("%02d", b));
        return d.toString().split(" ")[0].toUpperCase();
    }
}