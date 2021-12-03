package programers.lv1;

public class l82612 {
	public static void main(String[] args) {
		int price=3, money=20, count=4;
		System.out.println(new l82612().solution2(price, money, count));
	}
	public long solution(int price, int money, int count) {
		long totalPrice = ((1+count)*count)/2*price;
        if(totalPrice<money)return 0;
        else return totalPrice-money;
    }
	public long solution2(int price, int money, int count) {
		return Math.max((long)price*(count*(count+1)/2)-money, 0);
	}
}
