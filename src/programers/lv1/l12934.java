package programers.lv1;

public class l12934 {
	public static void main(String[] args) {
		long n = 3;
		System.out.println(new l12934().solution(n));
	}
	public long solution(long n) {
		long sn = (long)Math.sqrt(n);
		if(sn*sn!=n)return -1;
        return (sn+1)*(sn+1);
    }
	public long solution2(long n) {
		if(Math.pow((long)Math.sqrt(n),2)==n){
			return(long)Math.pow(Math.sqrt(n)+1, 2);
		}
        return -1;
    }
}
