package programers.lv1;

public class l12947 {
	public static void main(String[] args) {
		
	}
	public boolean solution(int x) {
        int sum=0;
        int tmpx=x;
        while(tmpx!=0) {
        	sum+=tmpx%10;
        	tmpx/=10;
        }
        return x%sum==0;
    }
	int sum=0;
	public boolean solution2(int x) {
        Integer.toString(x).chars().forEach(c->sum+=c-'0');
        return x%sum==0;
    }
	public boolean solution3(int x) {
        int sum = String.valueOf(x).chars().map(ch -> ch - '0').sum();
        return x%sum==0;
    }
}
