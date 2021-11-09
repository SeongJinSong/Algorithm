package programers.lv2;

import java.math.BigInteger;

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
		/*패턴 직사각형이 다음 꼭지점으로 도달하기 위해서는 가로 길이, 세로 길이만큼 움직여야 하는데
		 * 가로 길이, 세로 길이중 겹치는 부분이 있기 때문에 1을 빼는 것이다.*/
		long cnt = minW+minH-1;
		
		/* 성능 테스트 통과 못함        
		for(int i=0;i<minW;i++) {
			for(int j=0;j<minH;j++) {
				if(j*minW>minH*(i+1))continue;
				if(i!=0&&(j+1)*minW<minH*i)continue;
				cnt++;
			}
		}*/
        return w*h-val*cnt;
    }
	public long gcd(long a, long b) {
		if(b==0)return a;
		else return gcd(b, a%b);
	}
	/*BigInteger에 GCD 함수가 있는걸 첨 알았다. 유용하게 쓸 수 있을 것 같다.
	 * 대각선의 길이는 가로 + 세로 - 가로세로의 최대공약수*/
	public long solution2(int w, int h) {
		long totalCount = (long)w * (long)h;
		long diagonalCount = w+h-BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
		return totalCount-diagonalCount;
	}
}
