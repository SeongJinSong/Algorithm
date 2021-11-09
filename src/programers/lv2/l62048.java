package programers.lv2;

public class l62048 {
	public static void main(String[] args) {
		int w=8, h=12;
		System.out.println(new l62048().solution(w, h));
	}
	public long solution(long w, long h) {
		/*
		 * 1. 가로x세로 첫번째 꼭지점을 구한다.
		 *   - 최소공배수
		 * 2. 첫번째 꼭지점까지 지나는 사각형의 개수를 구한다.
		 * 3. 첫번째 꼭지점 개수만큼 곱한다.
		 * */
		if(w==h)return w*(h-1);
		if(w==1||h==1)return 0;
		long val=gcd(w, h);
		long minW = w/val;
		long minH = h/val;
		if(minW==1||minH==1)return w*h-val*minW*minH;
		long cnt = 0;
        for(int i=0;i<minW;i++) {
        	for(int j=0;j<minH;j++) {
        		if(j*minW>minH*(i+1))continue;
        		if(i!=0&&(j+1)*minW<minH*i)continue;
        		cnt++;
        	}
        }
        return w*h-val*cnt;
    }
	public long gcd(long a, long b) {
		if(b==0)return a;
		else return gcd(b, a%b);
	}
}
