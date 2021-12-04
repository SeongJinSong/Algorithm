package programers.lv1;

public class l12922 {
	public static void main(String[] args) {
		int n=4;
		System.out.println(new l12922().solution(n));
	}
	public String solution(int n) {
		String[] a = {"수", "박"};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
        	sb.append(a[i%2]);
        }
        return sb.toString();
    }
	public String solution2(int n) {
		return new String(new char[n/2+1]).replace("\0", "수박").substring(0,n);
    }
}
